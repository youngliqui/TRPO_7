package server.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import server.product.Product;
import server.services.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public Product findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Product").list();
    }

    @Override
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(product);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(product);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(product);
        tx1.commit();
        session.close();
    }
}
