package cn.javaer.retrofit2.converter.jaxb;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

final class JaxbRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
    private static final String    CHARSET    = "UTF-8";
    
    private final Marshaller marshaller;
    
    JaxbRequestBodyConverter(final Class<T> cls) {
        final JAXBContext context;
        try {
            context = JAXBContext.newInstance(cls);
            this.marshaller = context.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_ENCODING, CHARSET);
            this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public RequestBody convert(final T value) throws IOException {
        final StringWriter sw = new StringWriter();
        try {
            this.marshaller.marshal(value, sw);
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
        return RequestBody.create(MEDIA_TYPE, sw.toString());
    }
}
