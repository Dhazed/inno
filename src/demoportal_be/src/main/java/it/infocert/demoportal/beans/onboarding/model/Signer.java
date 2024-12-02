
package it.infocert.demoportal.beans.onboarding.model;

import it.infocert.demoportal.beans.onboarding.model.properties.Properties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="person" type="{http://www.infocert.it/legalbus/cop/onboarding/model}person"/&gt;
 *         &lt;element name="certificate" type="{http://www.infocert.it/legalbus/cop/onboarding/model}certificate" minOccurs="0"/&gt;
 *         &lt;element name="default-redirect-url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="failure-redirect-url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identity-assertion" type="{http://www.infocert.it/legalbus/cop/onboarding/model}content" minOccurs="0"/&gt;
 *         &lt;element name="authorization-assertion" type="{http://www.infocert.it/legalbus/cop/onboarding/model}content" minOccurs="0"/&gt;
 *         &lt;element name="additional-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="signer-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="identity-assertion-policy" use="required" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identity-assertion-policy" /&gt;
 *       &lt;attribute name="role" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signer", propOrder = {
    "person",
    "certificate",
    "defaultRedirectUrl",
    "failureRedirectUrl",
    "identityAssertion",
    "authorizationAssertion",
    "additionalData"
})
public class Signer {

    @XmlElement(required = true)
    protected Person person;
    protected Certificate certificate;
    @XmlElement(name = "default-redirect-url", required = true)
    protected String defaultRedirectUrl;
    @XmlElement(name = "failure-redirect-url")
    protected String failureRedirectUrl;
    @XmlElement(name = "identity-assertion")
    protected Content identityAssertion;
    @XmlElement(name = "authorization-assertion")
    protected Content authorizationAssertion;
    @XmlElement(name = "additional-data")
    protected Properties additionalData;
    @XmlAttribute(name = "signer-id", required = true)
    protected String signerId;
    @XmlAttribute(name = "identity-assertion-policy", required = true)
    protected IdentityAssertionPolicy identityAssertionPolicy;
    @XmlAttribute(name = "role", required = true)
    protected String role;
    @XmlAttribute(name = "lang")
    protected String lang;

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
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate }
     *     
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *     
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the defaultRedirectUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultRedirectUrl() {
        return defaultRedirectUrl;
    }

    /**
     * Sets the value of the defaultRedirectUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultRedirectUrl(String value) {
        this.defaultRedirectUrl = value;
    }

    /**
     * Gets the value of the failureRedirectUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureRedirectUrl() {
        return failureRedirectUrl;
    }

    /**
     * Sets the value of the failureRedirectUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureRedirectUrl(String value) {
        this.failureRedirectUrl = value;
    }

    /**
     * Gets the value of the identityAssertion property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getIdentityAssertion() {
        return identityAssertion;
    }

    /**
     * Sets the value of the identityAssertion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setIdentityAssertion(Content value) {
        this.identityAssertion = value;
    }

    /**
     * Gets the value of the authorizationAssertion property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getAuthorizationAssertion() {
        return authorizationAssertion;
    }

    /**
     * Sets the value of the authorizationAssertion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setAuthorizationAssertion(Content value) {
        this.authorizationAssertion = value;
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
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
