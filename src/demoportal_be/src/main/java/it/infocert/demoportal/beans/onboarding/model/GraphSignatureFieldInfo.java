
package it.infocert.demoportal.beans.onboarding.model;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for graph-signature-field-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="graph-signature-field-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="mandatory" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="signed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="reason" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="signer-id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="sign-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="sign-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="present" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="page" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="width" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="height" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="bottom-left-x" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="bottom-left-y" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="field-keyword" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="field-offset-x" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="field-offset-y" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="image" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graph-signature-field-info")
public class GraphSignatureFieldInfo {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "mandatory", required = true)
    protected boolean mandatory;
    @XmlAttribute(name = "signed", required = true)
    protected boolean signed;
    @XmlAttribute(name = "location")
    protected String location;
    @XmlAttribute(name = "reason")
    protected String reason;
    @XmlAttribute(name = "signer-id")
    protected String signerId;
    @XmlAttribute(name = "sign-date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signDate;
    @XmlAttribute(name = "sign-type")
    protected String signType;
    @XmlAttribute(name = "present", required = true)
    protected boolean present;
    @XmlAttribute(name = "page", required = true)
    protected int page;
    @XmlAttribute(name = "width", required = true)
    protected float width;
    @XmlAttribute(name = "height", required = true)
    protected float height;
    @XmlAttribute(name = "bottom-left-x", required = true)
    protected double bottomLeftX;
    @XmlAttribute(name = "bottom-left-y", required = true)
    protected double bottomLeftY;
    @XmlAttribute(name = "field-keyword")
    protected String fieldKeyword;
    @XmlAttribute(name = "field-offset-x", required = true)
    protected float fieldOffsetX;
    @XmlAttribute(name = "field-offset-y", required = true)
    protected float fieldOffsetY;
    @XmlAttribute(name = "image")
    protected byte[] image;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     */
    public void setMandatory(boolean value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the signed property.
     * 
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Sets the value of the signed property.
     * 
     */
    public void setSigned(boolean value) {
        this.signed = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
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
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSignDate(XMLGregorianCalendar value) {
        this.signDate = value;
    }

    /**
     * Gets the value of the signType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignType() {
        return signType;
    }

    /**
     * Sets the value of the signType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignType(String value) {
        this.signType = value;
    }

    /**
     * Gets the value of the present property.
     * 
     */
    public boolean isPresent() {
        return present;
    }

    /**
     * Sets the value of the present property.
     * 
     */
    public void setPresent(boolean value) {
        this.present = value;
    }

    /**
     * Gets the value of the page property.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public float getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(float value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(float value) {
        this.height = value;
    }

    /**
     * Gets the value of the bottomLeftX property.
     * 
     */
    public double getBottomLeftX() {
        return bottomLeftX;
    }

    /**
     * Sets the value of the bottomLeftX property.
     * 
     */
    public void setBottomLeftX(double value) {
        this.bottomLeftX = value;
    }

    /**
     * Gets the value of the bottomLeftY property.
     * 
     */
    public double getBottomLeftY() {
        return bottomLeftY;
    }

    /**
     * Sets the value of the bottomLeftY property.
     * 
     */
    public void setBottomLeftY(double value) {
        this.bottomLeftY = value;
    }

    /**
     * Gets the value of the fieldKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldKeyword() {
        return fieldKeyword;
    }

    /**
     * Sets the value of the fieldKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldKeyword(String value) {
        this.fieldKeyword = value;
    }

    /**
     * Gets the value of the fieldOffsetX property.
     * 
     */
    public float getFieldOffsetX() {
        return fieldOffsetX;
    }

    /**
     * Sets the value of the fieldOffsetX property.
     * 
     */
    public void setFieldOffsetX(float value) {
        this.fieldOffsetX = value;
    }

    /**
     * Gets the value of the fieldOffsetY property.
     * 
     */
    public float getFieldOffsetY() {
        return fieldOffsetY;
    }

    /**
     * Sets the value of the fieldOffsetY property.
     * 
     */
    public void setFieldOffsetY(float value) {
        this.fieldOffsetY = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage(byte[] value) {
        this.image = value;
    }

}
