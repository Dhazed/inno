
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-creation-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-creation-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tokens"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tokens" type="{http://www.infocert.it/legalbus/cop/onboarding/model}token" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-creation-info", propOrder = {
    "tokens"
})
public class DossierCreationInfo {

    @XmlElement(required = true)
    protected DossierCreationInfo.Tokens tokens;

    /**
     * Gets the value of the tokens property.
     * 
     * @return
     *     possible object is
     *     {@link DossierCreationInfo.Tokens }
     *     
     */
    public DossierCreationInfo.Tokens getTokens() {
        return tokens;
    }

    /**
     * Sets the value of the tokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierCreationInfo.Tokens }
     *     
     */
    public void setTokens(DossierCreationInfo.Tokens value) {
        this.tokens = value;
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
     *         &lt;element name="tokens" type="{http://www.infocert.it/legalbus/cop/onboarding/model}token" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "tokens"
    })
    public static class Tokens {

        @XmlElement(nillable = true)
        protected List<Token> tokens;

        /**
         * Gets the value of the tokens property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the tokens property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTokens().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Token }
         * 
         * 
         */
        public List<Token> getTokens() {
            if (tokens == null) {
                tokens = new ArrayList<Token>();
            }
            return this.tokens;
        }

    }

}
