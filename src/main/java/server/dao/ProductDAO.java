package server.dao;

import server.product.Product;

import java.util.List;

public interface ProductDAO {
    Product findById(Long id);
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(Product product);
}
