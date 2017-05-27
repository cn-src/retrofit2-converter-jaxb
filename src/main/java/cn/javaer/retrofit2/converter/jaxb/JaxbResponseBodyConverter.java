package cn.javaer.retrofit2.converter.jaxb;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

final class JaxbResponseBodyConverter<T> implements Converter<ResponseBody, T>
{
    private final Unmarshaller unmarshaller;
    
    JaxbResponseBodyConverter(final Class<T> cls)
    {
        try
        {
            final JAXBContext context = JAXBContext.newInstance(cls);
            this.unmarshaller = context.createUnmarshaller();
        } catch (final JAXBException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public T convert(final ResponseBody value) throws IOException
    {
        try
        {
            //noinspection unchecked
            return (T) this.unmarshaller.unmarshal(new StringReader(value.string()));
        } catch (final JAXBException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            value.close();
        }
    }
}
