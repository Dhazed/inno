package it.infocert.demoportal.persistance.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Companies extends PanacheEntityBase {

    @Id   
    @Column
    public String id_company_name;

    @Column
    public String company_description;

    @Column
    public String primary_color;

    @Column
    public String secondary_color;

    @Column(name = "logo_img", columnDefinition="TEXT")
    public String logo_img;
    
}