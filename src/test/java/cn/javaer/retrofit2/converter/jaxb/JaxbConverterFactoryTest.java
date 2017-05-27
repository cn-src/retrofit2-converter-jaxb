package cn.javaer.retrofit2.converter.jaxb;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.xml.bind.UnmarshalException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * @author zhangpeng
 */
public class JaxbConverterFactoryTest
{
    @Rule public final MockWebServer server = new MockWebServer();
    private Service service;
    
    @Before
    public void setUp()
    {
        final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(this.server.url("/"))
            .addConverterFactory(JaxbConverterFactory.create())
            .build();
        this.service = retrofit.create(Service.class);
    }
    
    @Test
    public void bodyWays() throws IOException, InterruptedException
    {
        this.server.enqueue(new MockResponse().setBody(
            "<my-object><message>hello world</message><count>10</count></my-object>"));
        
        final Call<MyObject> call = this.service.post(new MyObject("hello world", 10));
        final Response<MyObject> response = call.execute();
        final MyObject body = response.body();
        assertThat(body.getMessage()).isEqualTo("hello world");
        assertThat(body.getCount()).isEqualTo(10);
        
        final RecordedRequest request = this.server.takeRequest();
        assertThat(request.getBody().readUtf8()).isIn(
            "<my-object><message>hello world</message><count>10</count></my-object>",
            "<my-object><count>10</count><message>hello world</message></my-object>");
        assertThat(request.getHeader("Content-Type")).isEqualTo("application/xml; charset=UTF-8");
    }
    
    @Test
    public void honorsCharacterEncoding() throws IOException
    {
        final Buffer buffer = new Buffer().writeString(
            "<my-object><message>你好，世界</message><count>10</count></my-object>",
            Charset.forName("GBK"));
        this.server.enqueue(
            new MockResponse().setBody(buffer).addHeader("Content-Type", "text/xml;charset=GBK"));
        
        final Call<MyObject> call = this.service.get();
        final Response<MyObject> response = call.execute();
        final MyObject body = response.body();
        assertThat(body.getMessage()).isEqualTo("你好，世界");
    }
    
    @Test
    public void deserializeWrongValue() throws IOException
    {
        this.server.enqueue(new MockResponse().setBody("<myObject><foo/><bar/></myObject>"));
        
        final Call<?> call = this.service.get();
        try
        {
            call.execute();
            fail();
        } catch (final RuntimeException e)
        {
            assertThat(e.getCause()).isInstanceOf(UnmarshalException.class);
        }
    }
    
    @Test
    public void deserializeWrongClass() throws IOException
    {
        this.server.enqueue(new MockResponse().setBody(
            "<my-object><message>hello world</message><count>10</count></my-object>"));
        
        final Call<?> call = this.service.wrongClass();
        try
        {
            call.execute();
            fail();
        } catch (final RuntimeException e)
        {
            assertThat(e.getCause()).isInstanceOf(UnmarshalException.class);
        }
    }
    
    interface Service
    {
        @GET("/")
        Call<MyObject> get();
        
        @POST("/")
        Call<MyObject> post(@Body MyObject impl);
        
        @GET("/")
        Call<String> wrongClass();
    }
}