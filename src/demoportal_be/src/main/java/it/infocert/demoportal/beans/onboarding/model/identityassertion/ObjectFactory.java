
package it.infocert.demoportal.beans.onboarding.model.identityassertion;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.infocert.legalbus.cop.onboarding.model.identityassertion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IdentityAssertion_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", "identity-assertion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.infocert.legalbus.cop.onboarding.model.identityassertion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IdentityAssertion }
     * 
     */
    public IdentityAssertion createIdentityAssertion() {
        return new IdentityAssertion();
    }

    /**
     * Create an instance of {@link Claimer }
     * 
     */
    public Claimer createClaimer() {
        return new Claimer();
    }

    /**
     * Create an instance of {@link Statement }
     * 
     */
    public Statement createStatement() {
        return new Statement();
    }

    /**
     * Create an instance of {@link IdentityAssertion.Statements }
     * 
     */
    public IdentityAssertion.Statements createIdentityAssertionStatements() {
        return new IdentityAssertion.Statements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentityAssertion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentityAssertion }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", name = "identity-assertion")
    public JAXBElement<IdentityAssertion> createIdentityAssertion(IdentityAssertion value) {
        return new JAXBElement<IdentityAssertion>(_IdentityAssertion_QNAME, IdentityAssertion.class, null, value);
    }

}
