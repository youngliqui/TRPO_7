package server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.employees.MaintenanceEngineer;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class MaintenanceEngineerDAOImpl implements MaintenanceEngineerDAO {

    @Override
    public MaintenanceEngineer findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MaintenanceEngineer.class, id);
    }

    @Override
    public List<MaintenanceEngineer> findAll() {
        return (List<MaintenanceEngineer>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From MaintenanceEngineer").list();
    }

    @Override
    public void save(MaintenanceEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(MaintenanceEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(engineer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(MaintenanceEngineer engineer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(engineer);
        tx1.commit();
        session.close();
    }
}
