package it.infocert.demoportal.persistance.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import it.infocert.demoportal.persistance.model.Users;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsersRepository implements PanacheRepositoryBase<Users,String>{

}