package it.infocert.demoportal.persistance.entity;

import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransationLog extends PanacheEntityBase {
    @Id
    @Column(name="timestamp")
    public Instant timestamp = Instant.now();

    @Column(name="userid")
    public String userid;

	@Column(name="experience")
    public String experience;

    @Column(name="inputdata")
    public String inputdata;

    @Column(name="outcome")
    public String outcome;

}