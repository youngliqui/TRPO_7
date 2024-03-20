package server.services;

import server.catalog.Catalog;
import server.dao.CatalogDAO;
import server.dao.CatalogDAOImpl;

public class CatalogService {
    private CatalogDAO catalogDAO = new CatalogDAOImpl();

    public CatalogService() {

    }
    public Catalog findCatalog(Long id) {
        return catalogDAO.findById(id);
    }

    public void saveCatalog(Catalog catalog) {
        catalogDAO.save(catalog);
    }

    public void deleteCatalog(Catalog catalog) {
        catalogDAO.delete(catalog);
    }
}
