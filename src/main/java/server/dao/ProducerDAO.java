package server.dao;


import server.catalog.Producer;

import java.util.List;

public interface ProducerDAO {
    Producer findById(Long id);
    List<Producer> findAll();
    void save(Producer producer);
    void update(Producer producer);
    void delete(Producer producer);
}
