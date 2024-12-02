
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
 * <p>Java class for document-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="document-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="signature-field-results" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="signature-field-results" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field-result" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="keyword-signature-fields" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="keyword-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field-info" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="content" type="{http://www.infocert.it/legalbus/cop/onboarding/model}content" minOccurs="0"/&gt;
 *         &lt;element name="additional-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "document-info", propOrder = {
    "status",
    "signatureFieldResults",
    "keywordSignatureFields",
    "content",
    "additionalData"
})
public class DocumentInfo {

    @XmlElement(required = true)
    protected String status;
    @XmlElement(name = "signature-field-results")
    protected DocumentInfo.SignatureFieldResults signatureFieldResults;
    @XmlElement(name = "keyword-signature-fields")
    protected DocumentInfo.KeywordSignatureFields keywordSignatureFields;
    protected Content content;
    @XmlElement(name = "additional-data")
    protected Properties additionalData;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    protected String type;

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
     * Gets the value of the signatureFieldResults property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentInfo.SignatureFieldResults }
     *     
     */
    public DocumentInfo.SignatureFieldResults getSignatureFieldResults() {
        return signatureFieldResults;
    }

    /**
     * Sets the value of the signatureFieldResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentInfo.SignatureFieldResults }
     *     
     */
    public void setSignatureFieldResults(DocumentInfo.SignatureFieldResults value) {
        this.signatureFieldResults = value;
    }

    /**
     * Gets the value of the keywordSignatureFields property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentInfo.KeywordSignatureFields }
     *     
     */
    public DocumentInfo.KeywordSignatureFields getKeywordSignatureFields() {
        return keywordSignatureFields;
    }

    /**
     * Sets the value of the keywordSignatureFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentInfo.KeywordSignatureFields }
     *     
     */
    public void setKeywordSignatureFields(DocumentInfo.KeywordSignatureFields value) {
        this.keywordSignatureFields = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setContent(Content value) {
        this.content = value;
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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     *         &lt;element name="keyword-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field-info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "keywordSignatureField"
    })
    public static class KeywordSignatureFields {

        @XmlElement(name = "keyword-signature-field")
        protected List<SignatureFieldInfo> keywordSignatureField;

        /**
         * Gets the value of the keywordSignatureField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the keywordSignatureField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeywordSignatureField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignatureFieldInfo }
         * 
         * 
         */
        public List<SignatureFieldInfo> getKeywordSignatureField() {
            if (keywordSignatureField == null) {
                keywordSignatureField = new ArrayList<SignatureFieldInfo>();
            }
            return this.keywordSignatureField;
        }

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
     *         &lt;element name="signature-field-results" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field-result" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "signatureFieldResults"
    })
    public static class SignatureFieldResults {

        @XmlElement(name = "signature-field-results")
        protected List<SignatureFieldResult> signatureFieldResults;

        /**
         * Gets the value of the signatureFieldResults property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the signatureFieldResults property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSignatureFieldResults().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignatureFieldResult }
         * 
         * 
         */
        public List<SignatureFieldResult> getSignatureFieldResults() {
            if (signatureFieldResults == null) {
                signatureFieldResults = new ArrayList<SignatureFieldResult>();
            }
            return this.signatureFieldResults;
        }

    }

}
