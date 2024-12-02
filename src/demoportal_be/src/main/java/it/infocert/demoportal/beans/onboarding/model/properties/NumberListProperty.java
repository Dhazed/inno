
package it.infocert.demoportal.beans.onboarding.model.properties;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for number-list-property complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="number-list-property"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}property"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="integer" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *           &lt;element name="float" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *           &lt;element name="double" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "number-list-property", propOrder = {
    "integerOrLongOrFloat"
})
public class NumberListProperty
    extends Property
{

    @XmlElements({
        @XmlElement(name = "integer", type = Integer.class),
        @XmlElement(name = "long", type = Long.class),
        @XmlElement(name = "float", type = Float.class),
        @XmlElement(name = "double", type = Double.class)
    })
    protected List<Comparable> integerOrLongOrFloat;

    /**
     * Gets the value of the integerOrLongOrFloat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the integerOrLongOrFloat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntegerOrLongOrFloat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * {@link Float }
     * {@link Integer }
     * {@link Long }
     * 
     * 
     */
    public List<Comparable> getIntegerOrLongOrFloat() {
        if (integerOrLongOrFloat == null) {
            integerOrLongOrFloat = new ArrayList<Comparable>();
        }
        return this.integerOrLongOrFloat;
    }

}
