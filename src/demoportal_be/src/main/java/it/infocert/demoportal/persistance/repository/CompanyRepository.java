package it.infocert.demoportal.persistance.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import it.infocert.demoportal.persistance.model.Companies;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheRepositoryBase<Companies,String>{

}