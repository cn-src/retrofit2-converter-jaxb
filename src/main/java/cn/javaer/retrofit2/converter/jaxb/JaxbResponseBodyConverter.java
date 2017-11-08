package cn.javaer.retrofit2.converter.jaxb;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

final class JaxbResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Unmarshaller unmarshaller;

    JaxbResponseBodyConverter(final Class<T> cls) {
        try {
            final JAXBContext context = JAXBContext.newInstance(cls);
            this.unmarshaller = context.createUnmarshaller();
        } catch (final JAXBException e) {
            throw new UncheckedException(e);
        }
    }

    @SuppressWarnings({"unchecked","squid:S2093"})
    @Override
    public T convert(final ResponseBody value) throws IOException {
        try {
            return (T) this.unmarshaller.unmarshal(new StringReader(value.string()));
        } catch (final JAXBException e) {
            throw new UncheckedException(e);
        }finally {
            value.close();
        }
    }
}
