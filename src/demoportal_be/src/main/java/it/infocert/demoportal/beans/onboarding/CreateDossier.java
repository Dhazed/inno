
package it.infocert.demoportal.beans.onboarding;

import it.infocert.demoportal.beans.onboarding.model.Dossier;
import it.infocert.demoportal.beans.onboarding.model.Rao;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createDossier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createDossier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rao" type="{http://www.infocert.it/legalbus/cop/onboarding/model}rao" minOccurs="0"/&gt;
 *         &lt;element name="dossier" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDossier", propOrder = {
    "rao",
    "dossier"
})
public class CreateDossier {

    protected Rao rao;
    protected Dossier dossier;

    /**
     * Gets the value of the rao property.
     * 
     * @return
     *     possible object is
     *     {@link Rao }
     *     
     */
    public Rao getRao() {
        return rao;
    }

    /**
     * Sets the value of the rao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rao }
     *     
     */
    public void setRao(Rao value) {
        this.rao = value;
    }

    /**
     * Gets the value of the dossier property.
     * 
     * @return
     *     possible object is
     *     {@link Dossier }
     *     
     */
    public Dossier getDossier() {
        return dossier;
    }

    /**
     * Sets the value of the dossier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dossier }
     *     
     */
    public void setDossier(Dossier value) {
        this.dossier = value;
    }

}
