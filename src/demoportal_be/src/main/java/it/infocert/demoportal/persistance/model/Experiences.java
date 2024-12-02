package it.infocert.demoportal.persistance.model;



import java.sql.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiences extends PanacheEntityBase {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long experience_id;

    @Column
    public String experience_name;

    @Column
    public String experience_category;

    @Column
    public boolean is_betaversion;

    @Column
    public boolean is_active;

    @Column
    public Date dt_last_modified;

}