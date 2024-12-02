
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-result-set complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-result-set"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dossiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="dossiers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-record" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-result-set", propOrder = {
    "dossiers"
})
public class DossierResultSet
    extends DossierStatus
{

    @XmlElement(required = true)
    protected DossierResultSet.Dossiers dossiers;

    /**
     * Gets the value of the dossiers property.
     * 
     * @return
     *     possible object is
     *     {@link DossierResultSet.Dossiers }
     *     
     */
    public DossierResultSet.Dossiers getDossiers() {
        return dossiers;
    }

    /**
     * Sets the value of the dossiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierResultSet.Dossiers }
     *     
     */
    public void setDossiers(DossierResultSet.Dossiers value) {
        this.dossiers = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="dossiers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-record" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dossiers"
    })
    public static class Dossiers {

        @XmlElement(nillable = true)
        protected List<DossierRecord> dossiers;

        /**
         * Gets the value of the dossiers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the dossiers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDossiers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DossierRecord }
         * 
         * 
         */
        public List<DossierRecord> getDossiers() {
            if (dossiers == null) {
                dossiers = new ArrayList<DossierRecord>();
            }
            return this.dossiers;
        }

    }

}
