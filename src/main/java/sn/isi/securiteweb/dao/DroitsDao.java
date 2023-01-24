package sn.isi.securiteweb.dao;

import sn.isi.securiteweb.entities.Droits;

import java.util.List;

public interface DroitsDao extends Repository<Droits> {

    public List<Droits> findByIds(List<Integer> ids);
}
