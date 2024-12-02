
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;

import it.infocert.demoportal.beans.onboarding.model.properties.Properties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signer-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signer-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identified" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="personal-data-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="address-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="identity-document-info-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="contact-info-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="person" type="{http://www.infocert.it/legalbus/cop/onboarding/model}person"/&gt;
 *         &lt;element name="clauses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="clause-result" type="{http://www.infocert.it/legalbus/cop/onboarding/model}clause-result" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="certificate" type="{http://www.infocert.it/legalbus/cop/onboarding/model}certificate-info" minOccurs="0"/&gt;
 *         &lt;element name="additional-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="signer-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signer-info", propOrder = {
    "identified",
    "personalDataUpdated",
    "addressUpdated",
    "identityDocumentInfoUpdated",
    "contactInfoUpdated",
    "person",
    "clauses",
    "certificate",
    "additionalData"
})
public class SignerInfo {

    protected boolean identified;
    @XmlElement(name = "personal-data-updated")
    protected boolean personalDataUpdated;
    @XmlElement(name = "address-updated")
    protected boolean addressUpdated;
    @XmlElement(name = "identity-document-info-updated")
    protected boolean identityDocumentInfoUpdated;
    @XmlElement(name = "contact-info-updated")
    protected boolean contactInfoUpdated;
    @XmlElement(required = true)
    protected Person person;
    protected SignerInfo.Clauses clauses;
    protected CertificateInfo certificate;
    @XmlElement(name = "additional-data")
    protected Properties additionalData;
    @XmlAttribute(name = "signer-id", required = true)
    protected String signerId;

    /**
     * Gets the value of the identified property.
     * 
     */
    public boolean isIdentified() {
        return identified;
    }

    /**
     * Sets the value of the identified property.
     * 
     */
    public void setIdentified(boolean value) {
        this.identified = value;
    }

    /**
     * Gets the value of the personalDataUpdated property.
     * 
     */
    public boolean isPersonalDataUpdated() {
        return personalDataUpdated;
    }

    /**
     * Sets the value of the personalDataUpdated property.
     * 
     */
    public void setPersonalDataUpdated(boolean value) {
        this.personalDataUpdated = value;
    }

    /**
     * Gets the value of the addressUpdated property.
     * 
     */
    public boolean isAddressUpdated() {
        return addressUpdated;
    }

    /**
     * Sets the value of the addressUpdated property.
     * 
     */
    public void setAddressUpdated(boolean value) {
        this.addressUpdated = value;
    }

    /**
     * Gets the value of the identityDocumentInfoUpdated property.
     * 
     */
    public boolean isIdentityDocumentInfoUpdated() {
        return identityDocumentInfoUpdated;
    }

    /**
     * Sets the value of the identityDocumentInfoUpdated property.
     * 
     */
    public void setIdentityDocumentInfoUpdated(boolean value) {
        this.identityDocumentInfoUpdated = value;
    }

    /**
     * Gets the value of the contactInfoUpdated property.
     * 
     */
    public boolean isContactInfoUpdated() {
        return contactInfoUpdated;
    }

    /**
     * Sets the value of the contactInfoUpdated property.
     * 
     */
    public void setContactInfoUpdated(boolean value) {
        this.contactInfoUpdated = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the clauses property.
     * 
     * @return
     *     possible object is
     *     {@link SignerInfo.Clauses }
     *     
     */
    public SignerInfo.Clauses getClauses() {
        return clauses;
    }

    /**
     * Sets the value of the clauses property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerInfo.Clauses }
     *     
     */
    public void setClauses(SignerInfo.Clauses value) {
        this.clauses = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link CertificateInfo }
     *     
     */
    public CertificateInfo getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateInfo }
     *     
     */
    public void setCertificate(CertificateInfo value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the additionalData property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getAdditionalData() {
        return additionalData;
    }

    /**
     * Sets the value of the additionalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setAdditionalData(Properties value) {
        this.additionalData = value;
    }

    /**
     * Gets the value of the signerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerId() {
        return signerId;
    }

    /**
     * Sets the value of the signerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerId(String value) {
        this.signerId = value;
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
     *         &lt;element name="clause-result" type="{http://www.infocert.it/legalbus/cop/onboarding/model}clause-result" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "clauseResult"
    })
    public static class Clauses {

        @XmlElement(name = "clause-result")
        protected List<ClauseResult> clauseResult;

        /**
         * Gets the value of the clauseResult property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the clauseResult property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClauseResult().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ClauseResult }
         * 
         * 
         */
        public List<ClauseResult> getClauseResult() {
            if (clauseResult == null) {
                clauseResult = new ArrayList<ClauseResult>();
            }
            return this.clauseResult;
        }

    }

}
