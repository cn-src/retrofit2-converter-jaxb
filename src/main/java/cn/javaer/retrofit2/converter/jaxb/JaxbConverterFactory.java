package cn.javaer.retrofit2.converter.jaxb;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class JaxbConverterFactory extends Converter.Factory {
    private JaxbConverterFactory() { }
    
    @SuppressWarnings("WeakerAccess")
    public static JaxbConverterFactory create() {
        return new JaxbConverterFactory();
    }
    
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, final Annotation[] annotations,
        final Retrofit retrofit) {
        if (!(type instanceof Class)) {
            //noinspection ReturnOfNull
            return null;
        }
        final Class<?> cls = (Class<?>) type;
        return new JaxbResponseBodyConverter<>(cls);
    }
    
    @Override
    public Converter<?, RequestBody> requestBodyConverter(final Type type,
        final Annotation[] parameterAnnotations, final Annotation[] methodAnnotations, final Retrofit retrofit) {
        if (!(type instanceof Class)) {
            //noinspection ReturnOfNull
            return null;
        }
        final Class<?> cls = (Class<?>) type;
        return new JaxbRequestBodyConverter<>(cls);
    }
}
