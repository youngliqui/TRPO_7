package server.services;

import server.dao.MaintenanceEngineerDAO;
import server.dao.MaintenanceEngineerDAOImpl;
import server.employees.MaintenanceEngineer;

public class MaintenanceEngineerService {
    private MaintenanceEngineerDAO engineerDAO = new MaintenanceEngineerDAOImpl();

    public MaintenanceEngineerService() {

    }

    public MaintenanceEngineer findMaintenanceEngineer(Long id) {
        return engineerDAO.findById(id);
    }

    public void saveMaintenanceEngineer(MaintenanceEngineer engineer) {
        engineerDAO.save(engineer);
    }

    public void deleteMaintenanceEngineer(MaintenanceEngineer engineer) {
        engineerDAO.delete(engineer);
    }
}
