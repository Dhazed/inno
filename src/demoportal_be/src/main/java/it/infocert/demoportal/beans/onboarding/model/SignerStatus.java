
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;

import it.infocert.demoportal.beans.onboarding.model.properties.Properties;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signer-status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signer-status"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="signerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identification-status" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identifications-status" minOccurs="0"/&gt;
 *         &lt;element name="tasks" type="{http://www.infocert.it/legalbus/cop/onboarding/model}task-status" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="additional-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model/properties}properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signer-status", propOrder = {
    "role",
    "signerId",
    "status",
    "identificationStatus",
    "tasks",
    "additionalData"
})
public class SignerStatus {

    @XmlElement(required = true)
    protected String role;
    @XmlElement(required = true)
    protected String signerId;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(name = "identification-status")
    protected IdentificationsStatus identificationStatus;
    protected List<TaskStatus> tasks;
    @XmlElement(name = "additional-data")
    protected Properties additionalData;

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
     * Gets the value of the identificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationsStatus }
     *     
     */
    public IdentificationsStatus getIdentificationStatus() {
        return identificationStatus;
    }

    /**
     * Sets the value of the identificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationsStatus }
     *     
     */
    public void setIdentificationStatus(IdentificationsStatus value) {
        this.identificationStatus = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the tasks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTasks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskStatus }
     * 
     * 
     */
    public List<TaskStatus> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<TaskStatus>();
        }
        return this.tasks;
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

}
