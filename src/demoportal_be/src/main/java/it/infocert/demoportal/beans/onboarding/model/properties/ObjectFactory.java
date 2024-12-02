
package it.infocert.demoportal.beans.onboarding.model.properties;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.infocert.legalbus.cop.onboarding.model.properties package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Properties_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding/model/properties", "properties");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.infocert.legalbus.cop.onboarding.model.properties
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Properties }
     * 
     */
    public Properties createProperties() {
        return new Properties();
    }

    /**
     * Create an instance of {@link StringProperty }
     * 
     */
    public StringProperty createStringProperty() {
        return new StringProperty();
    }

    /**
     * Create an instance of {@link DateProperty }
     * 
     */
    public DateProperty createDateProperty() {
        return new DateProperty();
    }

    /**
     * Create an instance of {@link BooleanProperty }
     * 
     */
    public BooleanProperty createBooleanProperty() {
        return new BooleanProperty();
    }

    /**
     * Create an instance of {@link NumberProperty }
     * 
     */
    public NumberProperty createNumberProperty() {
        return new NumberProperty();
    }

    /**
     * Create an instance of {@link PropertiesProperty }
     * 
     */
    public PropertiesProperty createPropertiesProperty() {
        return new PropertiesProperty();
    }

    /**
     * Create an instance of {@link StringListProperty }
     * 
     */
    public StringListProperty createStringListProperty() {
        return new StringListProperty();
    }

    /**
     * Create an instance of {@link BooleanListProperty }
     * 
     */
    public BooleanListProperty createBooleanListProperty() {
        return new BooleanListProperty();
    }

    /**
     * Create an instance of {@link NumberListProperty }
     * 
     */
    public NumberListProperty createNumberListProperty() {
        return new NumberListProperty();
    }

    /**
     * Create an instance of {@link DateListProperty }
     * 
     */
    public DateListProperty createDateListProperty() {
        return new DateListProperty();
    }

    /**
     * Create an instance of {@link PropertiesListProperty }
     * 
     */
    public PropertiesListProperty createPropertiesListProperty() {
        return new PropertiesListProperty();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model/properties", name = "properties")
    public JAXBElement<Properties> createProperties(Properties value) {
        return new JAXBElement<Properties>(_Properties_QNAME, Properties.class, null, value);
    }

}
