package server.catalog;

import jakarta.persistence.*;
import server.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;

@Entity
@Table(name = "catalogs")
public class Catalog implements Sortable<Product>, Filterable<Product> {
    private String name;

    @OneToMany(mappedBy = "catalog")
    private List<Product> products;
    @OneToMany(mappedBy = "catalog")
    private List<Producer> producers;
    private static final String SEQ_NAME = "catalog_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public Catalog() {
        products = new ArrayList<>();
        producers = new ArrayList<>();
    }

    public Catalog(String name) {
        this.name = name;
        products = new ArrayList<>();
        producers = new ArrayList<>();
    }

    public Catalog(String name, List<Product> products, List<Producer> producers) {
        this.name = name;
        this.products = products;
        this.producers = producers;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducer(Producer producer) {
        producers.add(producer);
    }

    @Override
    public List<Product> getByType(String type) {
        return products.stream()
                .filter(product -> product.getType() != null
                        && product.getType().getName().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByName(String name) {
        return products.stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByProducer(String producerName) {
        return products.stream()
                .filter(product -> product.getProducer().getName().contains(producerName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByPurpose(String purpose) {
        return products.stream()
                .filter(product -> product.getPurpose() != null
                        && product.getPurpose().getName().contains(purpose))
                .collect(Collectors.toList());
    }

    @Override
    public void sortByAscendingPrice() {
        products = products.stream()
                .sorted(comparingDouble(product -> product.getPrice().getTotalPrice()))
                .toList();
    }

    @Override
    public void sortByDescendingPrice() {
        products = products.stream()
                .sorted(comparingDouble((Product product) -> product.getPrice().getTotalPrice()).reversed())
                .toList();
    }

    @Override
    public void sortByName() {
        products = products.stream()
                .sorted(comparing(Product::getName))
                .toList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
