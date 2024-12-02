
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-tracking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-tracking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dossier" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status" minOccurs="0"/&gt;
 *         &lt;element name="signers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="signer" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-tracking-info" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="actions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="action" type="{http://www.infocert.it/legalbus/cop/onboarding/model}action" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="company-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dossier-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-tracking", propOrder = {
    "dossier",
    "signers",
    "actions"
})
public class DossierTracking {

    protected DossierStatus dossier;
    @XmlElement(required = true)
    protected DossierTracking.Signers signers;
    protected DossierTracking.Actions actions;
    @XmlAttribute(name = "company-id", required = true)
    protected String companyId;
    @XmlAttribute(name = "dossier-id", required = true)
    protected String dossierId;

    /**
     * Gets the value of the dossier property.
     * 
     * @return
     *     possible object is
     *     {@link DossierStatus }
     *     
     */
    public DossierStatus getDossier() {
        return dossier;
    }

    /**
     * Sets the value of the dossier property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierStatus }
     *     
     */
    public void setDossier(DossierStatus value) {
        this.dossier = value;
    }

    /**
     * Gets the value of the signers property.
     * 
     * @return
     *     possible object is
     *     {@link DossierTracking.Signers }
     *     
     */
    public DossierTracking.Signers getSigners() {
        return signers;
    }

    /**
     * Sets the value of the signers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierTracking.Signers }
     *     
     */
    public void setSigners(DossierTracking.Signers value) {
        this.signers = value;
    }

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link DossierTracking.Actions }
     *     
     */
    public DossierTracking.Actions getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierTracking.Actions }
     *     
     */
    public void setActions(DossierTracking.Actions value) {
        this.actions = value;
    }

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
     *         &lt;element name="action" type="{http://www.infocert.it/legalbus/cop/onboarding/model}action" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "action"
    })
    public static class Actions {

        protected List<Action> action;

        /**
         * Gets the value of the action property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the action property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Action }
         * 
         * 
         */
        public List<Action> getAction() {
            if (action == null) {
                action = new ArrayList<Action>();
            }
            return this.action;
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
     *         &lt;element name="signer" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-tracking-info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "signer"
    })
    public static class Signers {

        protected List<SignerTrackingInfo> signer;

        /**
         * Gets the value of the signer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the signer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSigner().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignerTrackingInfo }
         * 
         * 
         */
        public List<SignerTrackingInfo> getSigner() {
            if (signer == null) {
                signer = new ArrayList<SignerTrackingInfo>();
            }
            return this.signer;
        }

    }

}
