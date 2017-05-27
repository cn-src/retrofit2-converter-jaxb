package cn.javaer.retrofit2.converter.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhangpeng
 */
@XmlRootElement(name = "my-object")
@XmlAccessorType(XmlAccessType.FIELD)
final class MyObject
{
    @XmlElement
    private String message;
    @XmlElement
    private int    count;
    
    public MyObject()
    {
    }
    
    public MyObject(final String message, final int count)
    {
        this.message = message;
        this.count = count;
    }
    
    public String getMessage()
    {
        return this.message;
    }
    
    public void setMessage(final String message)
    {
        this.message = message;
    }
    
    public int getCount()
    {
        return this.count;
    }
    
    public void setCount(final int count)
    {
        this.count = count;
    }
    
    @Override
    public int hashCode()
    {
        int result = 1;
        result = result * 31 + this.count;
        result = result * 31 + (this.message == null ? 0 : this.message.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj)
    {
        if (obj == this) return true;
        if (!(obj instanceof MyObject)) return false;
        final MyObject other = (MyObject) obj;
        return this.count == other.count
               && (this.message == null ? other.message == null : this.message.equals(other.message));
    }
}