
package it.infocert.demoportal.beans.onboarding.model.properties;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for boolean-property complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="boolean-property"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}property"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="boolean" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boolean-property", propOrder = {
    "_boolean"
})
public class BooleanProperty
    extends Property
{

    @XmlElement(name = "boolean")
    protected boolean _boolean;

    /**
     * Gets the value of the boolean property.
     * 
     */
    public boolean isBoolean() {
        return _boolean;
    }

    /**
     * Sets the value of the boolean property.
     * 
     */
    public void setBoolean(boolean value) {
        this._boolean = value;
    }

}
