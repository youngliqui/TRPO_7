package server.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.catalog.Catalog;
import server.services.HibernateSessionFactoryUtil;

public class CatalogDAOImpl implements CatalogDAO {
    @Override
    public Catalog findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Catalog.class, id);
    }

    @Override
    public void save(Catalog catalog) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(catalog);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Catalog catalog) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(catalog);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Catalog catalog) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(catalog);
        tx1.commit();
        session.close();
    }
}
