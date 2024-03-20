package server.controllers;

import server.product.Product;
import server.services.*;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final CatalogService catalogService = new CatalogService();
    private final ProducerService producerService = new ProducerService();
    private final ProductService productService = new ProductService();
    private final PriceService priceService = new PriceService();
    private final ProductionWorkerService productionWorkerService = new ProductionWorkerService();
    private final MaintenanceEngineerService maintenanceEngineerService = new MaintenanceEngineerService();
    private final QualityControlEngineerService qualityControlEngineerService = new QualityControlEngineerService();

    public Controller() {
    }


    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    public List<Product> sortByIncreasePrice(List<Product> products) {
        return productService.sortByIncreasePrice(products);
    }

    public List<Product> sortByDecreasePrice(List<Product> products) {
        return productService.sortByDecreasePrice(products);
    }

    public List<Product> sortByName(List<Product> products) {
        return productService.sortByName(products);
    }

    public List<Product> filterByName(List<Product> products, String name) {
        return products.stream()
                .filter(product -> product.getName().toUpperCase().contains(name))
                .collect(Collectors.toList());
    }

    public List<Product> filterByProducer(List<Product> products, String producerName) {
        return products.stream()
                .filter(product -> product.getProducer().getName().toUpperCase().contains(producerName))
                .collect(Collectors.toList());
    }

    public List<Product> filterByPurpose(List<Product> products, String purpose) {
        return products.stream()
                .filter(product -> product.getPurpose().getName().toUpperCase().contains(purpose))
                .collect(Collectors.toList());
    }

    public List<Product> filterByType(List<Product> products, String type) {
        return products.stream()
                .filter(product -> product.getType().getName().toUpperCase().contains(type))
                .collect(Collectors.toList());
    }
}
