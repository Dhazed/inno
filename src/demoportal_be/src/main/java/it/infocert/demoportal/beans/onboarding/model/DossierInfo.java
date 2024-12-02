
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;

import it.infocert.demoportal.beans.onboarding.model.properties.Properties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="signers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="signers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-info" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="documents"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="documents" type="{http://www.infocert.it/legalbus/cop/onboarding/model}document-info" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="additional-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-info", propOrder = {
    "signers",
    "documents",
    "additionalData"
})
public class DossierInfo
    extends DossierStatus
{

    @XmlElement(required = true)
    protected DossierInfo.Signers signers;
    @XmlElement(required = true)
    protected DossierInfo.Documents documents;
    @XmlElement(name = "additional-data")
    protected Properties additionalData;

    /**
     * Gets the value of the signers property.
     * 
     * @return
     *     possible object is
     *     {@link DossierInfo.Signers }
     *     
     */
    public DossierInfo.Signers getSigners() {
        return signers;
    }

    /**
     * Sets the value of the signers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierInfo.Signers }
     *     
     */
    public void setSigners(DossierInfo.Signers value) {
        this.signers = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link DossierInfo.Documents }
     *     
     */
    public DossierInfo.Documents getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierInfo.Documents }
     *     
     */
    public void setDocuments(DossierInfo.Documents value) {
        this.documents = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="documents" type="{http://www.infocert.it/legalbus/cop/onboarding/model}document-info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "documents"
    })
    public static class Documents {

        @XmlElement(nillable = true)
        protected List<DocumentInfo> documents;

        /**
         * Gets the value of the documents property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the documents property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocuments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentInfo }
         * 
         * 
         */
        public List<DocumentInfo> getDocuments() {
            if (documents == null) {
                documents = new ArrayList<DocumentInfo>();
            }
            return this.documents;
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
     *         &lt;element name="signers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "signers"
    })
    public static class Signers {

        @XmlElement(nillable = true)
        protected List<SignerInfo> signers;

        /**
         * Gets the value of the signers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the signers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSigners().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignerInfo }
         * 
         * 
         */
        public List<SignerInfo> getSigners() {
            if (signers == null) {
                signers = new ArrayList<SignerInfo>();
            }
            return this.signers;
        }

    }

}
