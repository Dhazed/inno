package it.infocert.demoportal.persistance.model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class Users extends PanacheEntityBase {
    
    @Id
    public String user_id;
    
    @Column
    public String given_name;

    @Column
    public String surname;
    
    @ManyToOne
    @JoinColumn(name = "id_company_name")
    public Companies company;

    @Column
    public int valid_from_epoch;

    @Column
    public int valid_until_epoch;

    @Column
    public int last_login;

    @Column
    public boolean is_active;

    @Column
    public String user_roles;
    
}