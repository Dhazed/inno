
package it.infocert.demoportal.beans.onboarding.model;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for token-details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="token-details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="token-expired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="token-expiration-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="token-use-count" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "token-details", propOrder = {
    "token",
    "tokenExpired",
    "tokenExpirationDate",
    "tokenUseCount"
})
public class TokenDetails {

    @XmlElement(required = true)
    protected String token;
    @XmlElement(name = "token-expired")
    protected boolean tokenExpired;
    @XmlElement(name = "token-expiration-date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tokenExpirationDate;
    @XmlElement(name = "token-use-count")
    protected int tokenUseCount;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the tokenExpired property.
     * 
     */
    public boolean isTokenExpired() {
        return tokenExpired;
    }

    /**
     * Sets the value of the tokenExpired property.
     * 
     */
    public void setTokenExpired(boolean value) {
        this.tokenExpired = value;
    }

    /**
     * Gets the value of the tokenExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    /**
     * Sets the value of the tokenExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTokenExpirationDate(XMLGregorianCalendar value) {
        this.tokenExpirationDate = value;
    }

    /**
     * Gets the value of the tokenUseCount property.
     * 
     */
    public int getTokenUseCount() {
        return tokenUseCount;
    }

    /**
     * Sets the value of the tokenUseCount property.
     * 
     */
    public void setTokenUseCount(int value) {
        this.tokenUseCount = value;
    }

}
