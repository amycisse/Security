package sn.isi.securiteweb.dao;

import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;

import java.util.List;

public interface ComptesDao extends Repository<Compte> {

    public Compte findByUsernameAndPassword(String username, String password);

    public Compte addcompte(Compte compte);

    public List<Compte> findAll(Compte compte);
}
