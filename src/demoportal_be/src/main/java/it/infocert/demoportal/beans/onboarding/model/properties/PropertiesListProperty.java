
package it.infocert.demoportal.beans.onboarding.model.properties;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for properties-list-property complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="properties-list-property"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}property"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="properties" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "properties-list-property", propOrder = {
    "properties"
})
public class PropertiesListProperty
    extends Property
{

    protected List<Properties> properties;

    /**
     * Gets the value of the properties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the properties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Properties }
     * 
     * 
     */
    public List<Properties> getProperties() {
        if (properties == null) {
            properties = new ArrayList<Properties>();
        }
        return this.properties;
    }

}
