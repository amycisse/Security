package sn.isi.securiteweb.dao;

import sn.isi.securiteweb.dto.UserDto;
import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;

import java.util.List;

public interface UserDao extends Repository<User> {

    public User findByCompte(Compte compte);

    public User adduser(User user);

    public List<User> findAll(User user);
}

