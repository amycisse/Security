package sn.isi.securiteweb.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sn.isi.securiteweb.Util.HibernateUtil;
import sn.isi.securiteweb.dao.UserDao;
import sn.isi.securiteweb.dto.UserDto;
import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;

import java.util.List;

public class UserDaoImpl extends RepositoryImpl<User> implements UserDao {


    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public UserDaoImpl() {
        super();
    }

    @Override
    public User findByCompte(Compte compte) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> from = criteria.from(User.class);

        criteria.select(from);
        criteria.where(session.getCriteriaBuilder().equal(from.get("compte"),compte));

        return session.createQuery(criteria).getSingleResultOrNull();
    }

    @Override
    public User adduser(User user) {
        RepositoryImpl repoImpl = new RepositoryImpl();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            repoImpl.add(user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    return user;
    }

    @Override
    public List<User> findAll(User user) {
        RepositoryImpl repoImpl = new RepositoryImpl();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            repoImpl.list(user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list(user);
    }


}
