package it.infocert.demoportal.persistance.crud;

import java.util.List;
import java.util.stream.Collectors;

import it.infocert.demoportal.persistance.entity.DemoPortalUser;
import it.infocert.demoportal.persistance.models.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DemoPortalUserCRUD {
    
    public List<User> getAll() {
      List<DemoPortalUser> listAll = DemoPortalUser.findAll().list();
        return listAll.stream().map(ie -> {
            return new User(ie.userid, ie.name,ie.surname,ie.company,ie.status);
        }).collect(Collectors.toList());
    }

    public User getbyEmail(String userid) {
      DemoPortalUser userEntity = DemoPortalUser.findById(userid);
      if (userEntity != null)
          return new User(userEntity.userid, userEntity.name,userEntity.surname,userEntity.company,userEntity.status);
      else
           return null;
    }

    @Transactional
    public DemoPortalUser insert(User user) {
      try {
         DemoPortalUser userEntity = new DemoPortalUser();
      userEntity.userid = user.userid;
      userEntity.name = user.name;
      userEntity.surname = user.surname;
      userEntity.company = user.company;
      userEntity.status = user.status;
      userEntity.persistAndFlush();
      return userEntity;
      } catch (Exception pe) {
        pe.printStackTrace();
        return null;
      }

    }
    
    @Transactional
    public DemoPortalUser update(User user) {
      DemoPortalUser userEntity = DemoPortalUser.findById(user.userid);
      if (userEntity != null ) { 
        userEntity.name = user.name;
      userEntity.surname = user.surname;
      userEntity.company = user.company;
      userEntity.status = user.status;
      return userEntity;
      } else 
      return null;
    }

    @Transactional
    public void delete(String userid) {
      DemoPortalUser.delete(userid);
    }

}
