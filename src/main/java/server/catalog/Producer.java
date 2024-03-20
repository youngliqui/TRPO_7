package server.catalog;

import jakarta.persistence.*;
import server.employees.Employee;
import server.employees.MaintenanceEngineer;
import server.employees.ProductionWorker;
import server.employees.QualityControlEngineer;
import server.product.Product;

import java.util.ArrayList;
import java.util.List;

@Table(name = "producers")
@Entity
public class Producer {

    private static final String SEQ_NAME = "producer_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private Integer numberOfWorkers;
    @OneToMany(mappedBy = "producer")
    private List<Product> products;
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceEngineer> maintenanceEngineers;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductionWorker> productionWorkers;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QualityControlEngineer> qualityControlEngineers;
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Producer() {
        products = new ArrayList<>();
        maintenanceEngineers = new ArrayList<>();
        productionWorkers = new ArrayList<>();
        qualityControlEngineers = new ArrayList<>();
        numberOfWorkers = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addMaintenanceEngineer(MaintenanceEngineer maintenanceEngineer) {
        maintenanceEngineers.add(maintenanceEngineer);
        numberOfWorkers++;
    }

    public void addProductionWorker(ProductionWorker productionWorker) {
        productionWorkers.add(productionWorker);
        numberOfWorkers++;
    }

    public void addQualityControlEngineer(QualityControlEngineer qualityControlEngineer) {
        qualityControlEngineers.add(qualityControlEngineer);
        numberOfWorkers++;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfWorkers=" + numberOfWorkers +
                ", maintenanceEngineers=" + maintenanceEngineers +
                ", productionWorkers=" + productionWorkers +
                ", qualityControlEngineers=" + qualityControlEngineers +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }

    public List<Employee> getWorkers() {
        List<Employee> workers = new ArrayList<>();
        workers.addAll(maintenanceEngineers);
        workers.addAll(productionWorkers);
        workers.addAll(qualityControlEngineers);

        return workers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(Integer numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<MaintenanceEngineer> getMaintenanceEngineers() {
        return maintenanceEngineers;
    }

    public void setMaintenanceEngineers(List<MaintenanceEngineer> maintenanceEngineers) {
        this.maintenanceEngineers = maintenanceEngineers;
    }

    public List<ProductionWorker> getProductionWorkers() {
        return productionWorkers;
    }

    public void setProductionWorkers(List<ProductionWorker> productionWorkers) {
        this.productionWorkers = productionWorkers;
    }

    public List<QualityControlEngineer> getQualityControlEngineers() {
        return qualityControlEngineers;
    }

    public void setQualityControlEngineers(List<QualityControlEngineer> qualityControlEngineers) {
        this.qualityControlEngineers = qualityControlEngineers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
