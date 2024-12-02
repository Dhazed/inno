package it.infocert.demoportal.persistance.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.infocert.demoportal.persistance.model.Experiences;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExperiencesRepository implements PanacheRepository<Experiences> {

}