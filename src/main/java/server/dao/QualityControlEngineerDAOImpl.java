package server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.employees.QualityControlEngineer;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class QualityControlEngineerDAOImpl implements QualityControlEngineerDAO {

    @Override
    public QualityControlEngineer findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(QualityControlEngineer.class, id);
    }

    @Override
    public List<QualityControlEngineer> findAll() {
        return (List<QualityControlEngineer>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From QualityControlEngineer ").list();
    }


    @Override
    public void save(QualityControlEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(QualityControlEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(QualityControlEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(engineer);
        tx1.commit();
        session.close();
    }
}
