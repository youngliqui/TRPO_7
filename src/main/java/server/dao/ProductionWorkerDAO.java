package server.dao;

import server.employees.ProductionWorker;

import java.util.List;

public interface ProductionWorkerDAO {
    ProductionWorker findById(Long id);

    List<ProductionWorker> findAll();

    void save(ProductionWorker engineer);

    void update(ProductionWorker engineer);

    void delete(ProductionWorker engineer);
}
