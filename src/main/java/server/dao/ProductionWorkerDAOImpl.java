package server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.employees.ProductionWorker;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductionWorkerDAOImpl implements ProductionWorkerDAO {

    @Override
    public ProductionWorker findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProductionWorker.class, id);
    }

    @Override
    public List<ProductionWorker> findAll() {
        return (List<ProductionWorker>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From ProductionWorker ").list();
    }


    @Override
    public void save(ProductionWorker engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(ProductionWorker engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(ProductionWorker engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(engineer);
        tx1.commit();
        session.close();
    }
}
