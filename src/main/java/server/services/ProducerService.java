package server.services;


import server.catalog.Producer;
import server.dao.ProducerDAO;
import server.dao.ProducerDAOImpl;

import java.util.List;

public class ProducerService {
    private ProducerDAO producerDAO = new ProducerDAOImpl();

    public Producer findProducer(Long id) {
        return producerDAO.findById(id);
    }

    public void saveProducer(Producer producer) {
        producerDAO.save(producer);
    }

    public List<Producer> findAllProducers() {
        return  producerDAO.findAll();
    }

    public void updateProducer(Producer producer) {
        producerDAO.update(producer);
    }
}
