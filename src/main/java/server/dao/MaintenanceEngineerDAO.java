package server.dao;

import server.employees.MaintenanceEngineer;

import java.util.List;

public interface MaintenanceEngineerDAO {
    MaintenanceEngineer findById(Long id);

    List<MaintenanceEngineer> findAll();

    void save(MaintenanceEngineer engineer);

    void update(MaintenanceEngineer engineer);

    void delete(MaintenanceEngineer engineer);
}
