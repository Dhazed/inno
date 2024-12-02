
package it.infocert.demoportal.beans.onboarding.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identifications-status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identifications-status"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identity-assertion-policy" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identity-assertion-policy"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identity-assertion-type" type="{http://www.infocert.it/legalbus/cop/onboarding/model}modalita-riconoscimento" minOccurs="0"/&gt;
 *         &lt;element name="reject-reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="branch-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identifications-status", propOrder = {
    "identityAssertionPolicy",
    "status",
    "identityAssertionType",
    "rejectReason",
    "branchId"
})
public class IdentificationsStatus {

    @XmlElement(name = "identity-assertion-policy", required = true)
    @XmlSchemaType(name = "string")
    protected IdentityAssertionPolicy identityAssertionPolicy;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(name = "identity-assertion-type")
    protected String identityAssertionType;
    @XmlElement(name = "reject-reason")
    protected String rejectReason;
    @XmlElement(name = "branch-id")
    protected String branchId;

    /**
     * Gets the value of the identityAssertionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link IdentityAssertionPolicy }
     *     
     */
    public IdentityAssertionPolicy getIdentityAssertionPolicy() {
        return identityAssertionPolicy;
    }

    /**
     * Sets the value of the identityAssertionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityAssertionPolicy }
     *     
     */
    public void setIdentityAssertionPolicy(IdentityAssertionPolicy value) {
        this.identityAssertionPolicy = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the identityAssertionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityAssertionType() {
        return identityAssertionType;
    }

    /**
     * Sets the value of the identityAssertionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityAssertionType(String value) {
        this.identityAssertionType = value;
    }

    /**
     * Gets the value of the rejectReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * Sets the value of the rejectReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRejectReason(String value) {
        this.rejectReason = value;
    }

    /**
     * Gets the value of the branchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * Sets the value of the branchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchId(String value) {
        this.branchId = value;
    }

}
