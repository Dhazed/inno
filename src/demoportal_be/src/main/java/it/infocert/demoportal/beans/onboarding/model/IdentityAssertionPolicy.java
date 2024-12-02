
package it.infocert.demoportal.beans.onboarding.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identity-assertion-policy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="identity-assertion-policy"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="inline"/&gt;
 *     &lt;enumeration value="inline.webid"/&gt;
 *     &lt;enumeration value="inline.liveid"/&gt;
 *     &lt;enumeration value="inline.devisu"/&gt;
 *     &lt;enumeration value="inline.selfid"/&gt;
 *     &lt;enumeration value="inline.signature"/&gt;
 *     &lt;enumeration value="inline.cns"/&gt;
 *     &lt;enumeration value="wait"/&gt;
 *     &lt;enumeration value="attached"/&gt;
 *     &lt;enumeration value="existing"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "identity-assertion-policy")
@XmlEnum
public enum IdentityAssertionPolicy {

    @XmlEnumValue("inline")
    INLINE("inline"),
    @XmlEnumValue("inline.webid")
    INLINE_WEBID("inline.webid"),
    @XmlEnumValue("inline.liveid")
    INLINE_LIVEID("inline.liveid"),
    @XmlEnumValue("inline.devisu")
    INLINE_DEVISU("inline.devisu"),
    @XmlEnumValue("inline.selfid")
    INLINE_SELFID("inline.selfid"),
    @XmlEnumValue("inline.signature")
    INLINE_SIGNATURE("inline.signature"),
    @XmlEnumValue("inline.cns")
    INLINE_CNS("inline.cns"),
    @XmlEnumValue("wait")
    WAIT("wait"),
    @XmlEnumValue("attached")
    ATTACHED("attached"),
    @XmlEnumValue("existing")
    EXISTING("existing"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    IdentityAssertionPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentityAssertionPolicy fromValue(String v) {
        for (IdentityAssertionPolicy c: IdentityAssertionPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
