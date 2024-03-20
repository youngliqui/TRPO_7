package server.services;

import server.dao.ProductDAO;
import server.dao.ProductDAOImpl;
import server.product.Product;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;

public class ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    public Product findProduct(Long id) {
        return productDAO.findById(id);
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public List<Product> sortByIncreasePrice(List<Product> products) {
        products = products.stream().sorted(comparingDouble((product) -> product.getPrice().getTotalPrice())).toList();

        return products;
    }

    public List<Product> sortByDecreasePrice(List<Product> products) {
        products = products.stream()
                .sorted(comparingDouble((Product product) -> product.getPrice().getTotalPrice()).reversed())
                .toList();

        return products;
    }

    public List<Product> sortByName(List<Product> products) {
        products = products.stream().sorted(comparing(Product::getName)).toList();

        return products;
    }
}
