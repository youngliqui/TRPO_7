package server.dao;

import server.catalog.Catalog;

public interface CatalogDAO {
    Catalog findById(Long id);
    void save(Catalog catalog);
    void update(Catalog catalog);
    void delete(Catalog catalog);
}
