package server.services;

import server.dao.PriceDAO;
import server.dao.PriceDAOImpl;
import server.product.Price;

import java.util.List;

public class PriceService {
    private PriceDAO priceDAO = new PriceDAOImpl();

    public Price findPrice(Long id) {
        return priceDAO.findById(id);
    }

    public void savePrice(Price price) {
        priceDAO.save(price);
    }

    public List<Price> findAllPrices() {
        return priceDAO.findAll();
    }
}
