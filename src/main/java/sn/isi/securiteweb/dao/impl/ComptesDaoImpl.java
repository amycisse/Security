package sn.isi.securiteweb.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.isi.securiteweb.Util.HibernateUtil;
import sn.isi.securiteweb.dao.ComptesDao;
import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;

import java.util.List;

public class ComptesDaoImpl extends RepositoryImpl<Compte> implements ComptesDao {

    public ComptesDaoImpl() {
        super();
    }

    @Override
    public Compte findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Compte> criteria = builder.createQuery(Compte.class);
        Root<Compte> from = criteria.from(Compte.class);

        criteria.select(from);

        criteria.select(from);
        criteria.where(builder.and(
                builder.equal(from.get("username"),username.toLowerCase()) ,
                builder.equal(from.get("password"),password.toLowerCase()))
        );

        return session.createQuery(criteria).getSingleResultOrNull();
    }

    @Override
    public Compte addcompte(Compte compte) {
        RepositoryImpl repoImpl = new RepositoryImpl();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            repoImpl.add(compte);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return compte;
    }

    @Override
    public List<Compte> findAll(Compte compte) {
        RepositoryImpl repoImpl = new RepositoryImpl();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            repoImpl.list(compte);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list(compte);
    }
}
