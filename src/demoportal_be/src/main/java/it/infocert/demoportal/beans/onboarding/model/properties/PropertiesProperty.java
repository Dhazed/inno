
package it.infocert.demoportal.beans.onboarding.model.properties;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for properties-property complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="properties-property"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}property"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="properties" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "properties-property", propOrder = {
    "properties"
})
public class PropertiesProperty
    extends Property
{

    @XmlElement(required = true)
    protected Properties properties;

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

}
