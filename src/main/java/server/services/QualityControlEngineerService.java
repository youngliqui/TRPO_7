package server.services;

import server.dao.QualityControlEngineerDAO;
import server.dao.QualityControlEngineerDAOImpl;
import server.employees.QualityControlEngineer;

public class QualityControlEngineerService {
    private QualityControlEngineerDAO engineerDAO = new QualityControlEngineerDAOImpl();

    public QualityControlEngineerService() {

    }

    public QualityControlEngineer findQualityEngineer(Long id) {
        return engineerDAO.findById(id);
    }

    public void saveQualityEngineer(QualityControlEngineer engineer) {
        engineerDAO.save(engineer);
    }

    public void deleteQualityEngineer(QualityControlEngineer engineer) {
        engineerDAO.delete(engineer);
    }
}
