package server.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import server.catalog.Producer;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class ProducerDAOImpl implements ProducerDAO {
    @Override
    public Producer findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Producer.class, id);
    }

    @Override
    public List<Producer> findAll() {
        return (List<Producer>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("FROM Producer").list();
    }

    @Override
    public void save(Producer producer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(producer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Producer producer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(producer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Producer producer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(producer);
        tx1.commit();
        session.close();
    }
}
