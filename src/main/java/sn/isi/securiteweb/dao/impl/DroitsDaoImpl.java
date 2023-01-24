package sn.isi.securiteweb.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import sn.isi.securiteweb.dao.DroitsDao;
import sn.isi.securiteweb.entities.Droits;

import java.util.List;

public class DroitsDaoImpl extends RepositoryImpl<Droits> implements DroitsDao {

    public DroitsDaoImpl() {
        super();
    }

    @Override
    public List<Droits> findByIds(List<Integer> ids) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Droits> criteria = builder.createQuery(Droits.class);
        Root<Droits> from = criteria.from(Droits.class);

        criteria.select(from);
        criteria.where(session.getCriteriaBuilder().in(from.get("id"), ids));

        return session.createQuery(criteria).getResultList();
    }
}
