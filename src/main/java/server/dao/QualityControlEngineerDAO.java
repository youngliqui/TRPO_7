package server.dao;

import server.employees.QualityControlEngineer;

import java.util.List;

public interface QualityControlEngineerDAO {
    QualityControlEngineer findById(Long id);

    List<QualityControlEngineer> findAll();

    void save(QualityControlEngineer engineer);

    void update(QualityControlEngineer engineer);

    void delete(QualityControlEngineer engineer);
}
