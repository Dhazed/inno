
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for graph-signature-document-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="graph-signature-document-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="graph-signature-fields" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="graph-signature-field-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}graph-signature-field-info" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sign-document-id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="token" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="mime-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="content-url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="redirect-url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="callback-url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="server-process" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="ignore-build-signature-structure" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="outcome" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="enforce-closure" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graph-signature-document-info", propOrder = {
    "graphSignatureFields"
})
public class GraphSignatureDocumentInfo {

    @XmlElement(name = "graph-signature-fields")
    protected GraphSignatureDocumentInfo.GraphSignatureFields graphSignatureFields;
    @XmlAttribute(name = "sign-document-id")
    protected String signDocumentId;
    @XmlAttribute(name = "token")
    protected String token;
    @XmlAttribute(name = "content")
    protected byte[] content;
    @XmlAttribute(name = "mime-type")
    protected String mimeType;
    @XmlAttribute(name = "content-url")
    protected String contentUrl;
    @XmlAttribute(name = "redirect-url")
    protected String redirectUrl;
    @XmlAttribute(name = "callback-url")
    protected String callbackUrl;
    @XmlAttribute(name = "server-process")
    protected Boolean serverProcess;
    @XmlAttribute(name = "ignore-build-signature-structure")
    protected Boolean ignoreBuildSignatureStructure;
    @XmlAttribute(name = "outcome")
    protected Boolean outcome;
    @XmlAttribute(name = "enforce-closure")
    protected Boolean enforceClosure;

    /**
     * Gets the value of the graphSignatureFields property.
     * 
     * @return
     *     possible object is
     *     {@link GraphSignatureDocumentInfo.GraphSignatureFields }
     *     
     */
    public GraphSignatureDocumentInfo.GraphSignatureFields getGraphSignatureFields() {
        return graphSignatureFields;
    }

    /**
     * Sets the value of the graphSignatureFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphSignatureDocumentInfo.GraphSignatureFields }
     *     
     */
    public void setGraphSignatureFields(GraphSignatureDocumentInfo.GraphSignatureFields value) {
        this.graphSignatureFields = value;
    }

    /**
     * Gets the value of the signDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDocumentId() {
        return signDocumentId;
    }

    /**
     * Sets the value of the signDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDocumentId(String value) {
        this.signDocumentId = value;
    }

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
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContent(byte[] value) {
        this.content = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    /**
     * Gets the value of the contentUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * Sets the value of the contentUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentUrl(String value) {
        this.contentUrl = value;
    }

    /**
     * Gets the value of the redirectUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Sets the value of the redirectUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedirectUrl(String value) {
        this.redirectUrl = value;
    }

    /**
     * Gets the value of the callbackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Sets the value of the callbackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackUrl(String value) {
        this.callbackUrl = value;
    }

    /**
     * Gets the value of the serverProcess property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServerProcess() {
        return serverProcess;
    }

    /**
     * Sets the value of the serverProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServerProcess(Boolean value) {
        this.serverProcess = value;
    }

    /**
     * Gets the value of the ignoreBuildSignatureStructure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreBuildSignatureStructure() {
        return ignoreBuildSignatureStructure;
    }

    /**
     * Sets the value of the ignoreBuildSignatureStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreBuildSignatureStructure(Boolean value) {
        this.ignoreBuildSignatureStructure = value;
    }

    /**
     * Gets the value of the outcome property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutcome() {
        return outcome;
    }

    /**
     * Sets the value of the outcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutcome(Boolean value) {
        this.outcome = value;
    }

    /**
     * Gets the value of the enforceClosure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnforceClosure() {
        return enforceClosure;
    }

    /**
     * Sets the value of the enforceClosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnforceClosure(Boolean value) {
        this.enforceClosure = value;
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
     *         &lt;element name="graph-signature-field-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}graph-signature-field-info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "graphSignatureFieldInfo"
    })
    public static class GraphSignatureFields {

        @XmlElement(name = "graph-signature-field-info")
        protected List<GraphSignatureFieldInfo> graphSignatureFieldInfo;

        /**
         * Gets the value of the graphSignatureFieldInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the graphSignatureFieldInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGraphSignatureFieldInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GraphSignatureFieldInfo }
         * 
         * 
         */
        public List<GraphSignatureFieldInfo> getGraphSignatureFieldInfo() {
            if (graphSignatureFieldInfo == null) {
                graphSignatureFieldInfo = new ArrayList<GraphSignatureFieldInfo>();
            }
            return this.graphSignatureFieldInfo;
        }

    }

}
