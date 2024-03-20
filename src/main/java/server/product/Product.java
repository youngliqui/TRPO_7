package server.product;

import jakarta.persistence.*;
import server.catalog.Catalog;
import server.catalog.Producer;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private String name;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;
    @Enumerated(EnumType.STRING)
    private Purpose purpose;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Price price;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    private static final String SEQ_NAME = "product_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public Product() {
    }

    public Product(String name, Producer producer, Purpose purpose, ProductType type, Price price, Catalog catalog) {
        this.name = name;
        this.producer = producer;
        this.purpose = purpose;
        this.type = type;
        this.price = price;
        this.catalog = catalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", producer=" + producer.getName() +
                ", purpose=" + purpose +
                ", type=" + type +
                ", price=" + price.getTotalPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name)
                && Objects.equals(producer, product.producer)
                && type == product.type && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, producer, type, price);
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
