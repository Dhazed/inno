
package it.infocert.demoportal.beans.onboarding.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identity-documents-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identity-documents-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identity-document-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identity-document-data" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identity-documents-info", propOrder = {
    "identityDocumentInfo"
})
public class IdentityDocumentsInfo {

    @XmlElement(name = "identity-document-info")
    protected List<IdentityDocumentData> identityDocumentInfo;

    /**
     * Gets the value of the identityDocumentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the identityDocumentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentityDocumentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentityDocumentData }
     * 
     * 
     */
    public List<IdentityDocumentData> getIdentityDocumentInfo() {
        if (identityDocumentInfo == null) {
            identityDocumentInfo = new ArrayList<IdentityDocumentData>();
        }
        return this.identityDocumentInfo;
    }

}
