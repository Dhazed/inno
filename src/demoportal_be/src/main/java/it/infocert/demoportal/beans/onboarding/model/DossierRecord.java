
package it.infocert.demoportal.beans.onboarding.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="company-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dossier-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-record", propOrder = {
    "companyId",
    "dossierId"
})
public class DossierRecord
    extends DossierStatus
{

    @XmlElement(name = "company-id", required = true)
    protected String companyId;
    @XmlElement(name = "dossier-id", required = true)
    protected String dossierId;

    /**
     * Gets the value of the companyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyId(String value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the dossierId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierId() {
        return dossierId;
    }

    /**
     * Sets the value of the dossierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierId(String value) {
        this.dossierId = value;
    }

}
