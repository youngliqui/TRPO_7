package server.dao;


import server.product.Price;

import java.util.List;

public interface PriceDAO {
    Price findById(Long id);
    void save(Price price);
    void delete(Price price);
    List<Price> findAll();
}
