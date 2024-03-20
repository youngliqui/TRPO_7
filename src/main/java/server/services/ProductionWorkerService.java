package server.services;

import server.dao.ProductionWorkerDAO;
import server.dao.ProductionWorkerDAOImpl;
import server.employees.ProductionWorker;

public class ProductionWorkerService {
    private ProductionWorkerDAO engineerDAO = new ProductionWorkerDAOImpl();

    public ProductionWorkerService() {

    }

    public ProductionWorker findProductionWorker(Long id) {
        return engineerDAO.findById(id);
    }

    public void saveProductionWorker(ProductionWorker engineer) {
        engineerDAO.save(engineer);
    }

    public void deleteProductionWorker(ProductionWorker engineer) {
        engineerDAO.delete(engineer);
    }
}
