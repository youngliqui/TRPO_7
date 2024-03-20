package server.services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import server.catalog.Catalog;
import server.catalog.Producer;
import server.employees.Employee;
import server.employees.MaintenanceEngineer;
import server.employees.ProductionWorker;
import server.employees.QualityControlEngineer;
import server.product.Price;
import server.product.Product;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Catalog.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Producer.class);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(MaintenanceEngineer.class);
                configuration.addAnnotatedClass(ProductionWorker.class);
                configuration.addAnnotatedClass(QualityControlEngineer.class);
                configuration.addAnnotatedClass(Price.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Error!" + e);
            }
        }
        return sessionFactory;
    }
}
