package server.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import server.product.Price;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class PriceDAOImpl implements PriceDAO {
    @Override
    public Price findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Price.class, id);
    }

    @Override
    public void save(Price price) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(price);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Price price) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(price);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Price> findAll() {
        return (List<Price>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Price").list();
    }
}