
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signer-tracking-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signer-tracking-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="signer-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="token-details" type="{http://www.infocert.it/legalbus/cop/onboarding/model}token-details" minOccurs="0"/&gt;
 *         &lt;element name="identification-status" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identifications-status" minOccurs="0"/&gt;
 *         &lt;element name="events" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="event" type="{http://www.infocert.it/legalbus/cop/onboarding/model}event" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tasks"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="task" type="{http://www.infocert.it/legalbus/cop/onboarding/model}task-status" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signer-tracking-info", propOrder = {
    "role",
    "signerId",
    "status",
    "tokenDetails",
    "identificationStatus",
    "events",
    "tasks",
    "actions"
})
public class SignerTrackingInfo {

    @XmlElement(required = true)
    protected String role;
    @XmlElement(name = "signer-id", required = true)
    protected String signerId;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(name = "token-details")
    protected TokenDetails tokenDetails;
    @XmlElement(name = "identification-status")
    protected IdentificationsStatus identificationStatus;
    protected SignerTrackingInfo.Events events;
    @XmlElement(required = true)
    protected SignerTrackingInfo.Tasks tasks;
    protected SignerTrackingInfo.Actions actions;

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
     * Gets the value of the tokenDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TokenDetails }
     *     
     */
    public TokenDetails getTokenDetails() {
        return tokenDetails;
    }

    /**
     * Sets the value of the tokenDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenDetails }
     *     
     */
    public void setTokenDetails(TokenDetails value) {
        this.tokenDetails = value;
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
     * Gets the value of the events property.
     * 
     * @return
     *     possible object is
     *     {@link SignerTrackingInfo.Events }
     *     
     */
    public SignerTrackingInfo.Events getEvents() {
        return events;
    }

    /**
     * Sets the value of the events property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerTrackingInfo.Events }
     *     
     */
    public void setEvents(SignerTrackingInfo.Events value) {
        this.events = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link SignerTrackingInfo.Tasks }
     *     
     */
    public SignerTrackingInfo.Tasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerTrackingInfo.Tasks }
     *     
     */
    public void setTasks(SignerTrackingInfo.Tasks value) {
        this.tasks = value;
    }

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link SignerTrackingInfo.Actions }
     *     
     */
    public SignerTrackingInfo.Actions getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerTrackingInfo.Actions }
     *     
     */
    public void setActions(SignerTrackingInfo.Actions value) {
        this.actions = value;
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
     *         &lt;element name="event" type="{http://www.infocert.it/legalbus/cop/onboarding/model}event" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "event"
    })
    public static class Events {

        protected List<Event> event;

        /**
         * Gets the value of the event property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the event property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Event }
         * 
         * 
         */
        public List<Event> getEvent() {
            if (event == null) {
                event = new ArrayList<Event>();
            }
            return this.event;
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
     *         &lt;element name="task" type="{http://www.infocert.it/legalbus/cop/onboarding/model}task-status" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "task"
    })
    public static class Tasks {

        protected List<TaskStatus> task;

        /**
         * Gets the value of the task property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the task property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTask().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TaskStatus }
         * 
         * 
         */
        public List<TaskStatus> getTask() {
            if (task == null) {
                task = new ArrayList<TaskStatus>();
            }
            return this.task;
        }

    }

}
