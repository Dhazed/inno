package it.infocert.demoportal.persistance.entity;



import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DemoPortalUser extends PanacheEntityBase {
    
    @Id
    @Column(name="userid")
    public String userid;

    @Column(name="name")
    public String name;

	@Column(name="surname")
    public String surname;

    @Column(name="company")
    public String company;

    @Column(name="status")
    public String status;
}