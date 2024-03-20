package server;

import server.catalog.Catalog;
import server.catalog.Producer;
import server.employees.MaintenanceEngineer;
import server.employees.ProductionWorker;
import server.employees.QualityControlEngineer;
import server.product.Price;
import server.product.Product;
import server.product.ProductType;
import server.product.Purpose;
import server.services.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------------");

        CatalogService catalogService = new CatalogService();
        ProducerService producerService = new ProducerService();
        ProductService productService = new ProductService();
        PriceService priceService = new PriceService();
        ProductionWorkerService productionWorkerService = new ProductionWorkerService();
        QualityControlEngineerService qualityControlEngineerService = new QualityControlEngineerService();
        MaintenanceEngineerService maintenanceEngineerService = new MaintenanceEngineerService();


        //Добавление каталога товаров
        Catalog catalog = new Catalog("furniture");
        catalogService.saveCatalog(catalog);

        // Добавление производителя "topmebel"
        Producer producer1 = new Producer();
        producer1.setName("topmebel");
        producer1.setCatalog(catalog);
        producer1.setContactInfo("https://topmebel.com");
        producerService.saveProducer(producer1);

        MaintenanceEngineer me1 = new MaintenanceEngineer("Ivan", 2, 400.0, producer1);
        maintenanceEngineerService.saveMaintenanceEngineer(me1);
        ProductionWorker pw1 = new ProductionWorker("Maxim", 4, 500.0, 1.0f, producer1);
        productionWorkerService.saveProductionWorker(pw1);
        QualityControlEngineer qe1 = new QualityControlEngineer("Katy", 1, 300.0, producer1);
        qualityControlEngineerService.saveQualityEngineer(qe1);

        producer1.addMaintenanceEngineer(me1);
        producer1.addProductionWorker(pw1);
        producer1.addQualityControlEngineer(qe1);
        producerService.updateProducer(producer1);


        //Добавление производителя "mebel.pro"
        Producer producer2 = new Producer();
        producer2.setName("mebel.pro");
        producer2.setCatalog(catalog);
        producer2.setContactInfo("https://mebel-pro.com");
        producerService.saveProducer(producer2);

        MaintenanceEngineer me2 = new MaintenanceEngineer("Pavel", 4, 800.0, producer2);
        maintenanceEngineerService.saveMaintenanceEngineer(me2);
        ProductionWorker pw2 = new ProductionWorker("Alex", 2, 600.0, 0.5f, producer2);
        productionWorkerService.saveProductionWorker(pw2);
        ProductionWorker pw3 = new ProductionWorker("Sasha", 2, 500.0, 1.0f, producer2);
        productionWorkerService.saveProductionWorker(pw3);
        QualityControlEngineer qe2 = new QualityControlEngineer("Dasha", 2, 500.0, producer2);
        qualityControlEngineerService.saveQualityEngineer(qe2);

        producer2.addMaintenanceEngineer(me2);
        producer2.addProductionWorker(pw2);
        producer2.addProductionWorker(pw3);
        producer2.addQualityControlEngineer(qe2);
        producerService.updateProducer(producer2);

        //Добавление производителя "mastermebel"
        Producer producer3 = new Producer();
        producer3.setName("mastermebel");
        producer3.setCatalog(catalog);
        producer3.setContactInfo("https://mastermebel.com");
        producerService.saveProducer(producer3);

        MaintenanceEngineer me3 = new MaintenanceEngineer("Artem", 2, 600.0, producer3);
        maintenanceEngineerService.saveMaintenanceEngineer(me3);
        ProductionWorker pw4 = new ProductionWorker("Andrey", 2, 600.0, 0.5f, producer3);
        productionWorkerService.saveProductionWorker(pw4);
        ProductionWorker pw5 = new ProductionWorker("Oleg", 2, 500.0, 1.0f, producer3);
        productionWorkerService.saveProductionWorker(pw5);
        QualityControlEngineer qe3 = new QualityControlEngineer("Anna", 2, 500.0, producer3);
        qualityControlEngineerService.saveQualityEngineer(qe3);

        producer3.addMaintenanceEngineer(me3);
        producer3.addProductionWorker(pw4);
        producer3.addProductionWorker(pw5);
        producer3.addQualityControlEngineer(qe3);
        producerService.updateProducer(producer3);

        //Добавление товаров:

        // продукт 1
        Product product1 = new Product();
        productService.saveProduct(product1);

        Price price1 = new Price(200.0, 0, product1);
        priceService.savePrice(price1);

        product1.setName("office table");
        product1.setPrice(price1);
        product1.setType(ProductType.TABLE);
        product1.setProducer(producer3);
        product1.setPurpose(Purpose.OFFICE);
        product1.setCatalog(catalog);
        productService.updateProduct(product1);

        // продукт 2
        Product product2 = new Product();
        productService.saveProduct(product2);

        Price price2 = new Price(780.0, 5, product2);
        priceService.savePrice(price2);

        product2.setName("bed for kids");
        product2.setPrice(price2);
        product2.setType(ProductType.SOFA);
        product2.setProducer(producer1);
        product2.setPurpose(Purpose.KIDS_ROOM);
        product2.setCatalog(catalog);
        productService.updateProduct(product2);


        // продукт 3
        Product product3 = new Product();
        productService.saveProduct(product3);

        Price price3 = new Price(450.0, 15, product3);
        priceService.savePrice(price3);

        product3.setName("table for coffee");
        product3.setPrice(price3);
        product3.setType(ProductType.COFFEE_TABLE);
        product3.setProducer(producer2);
        product3.setPurpose(Purpose.OFFICE);
        product3.setCatalog(catalog);
        productService.updateProduct(product3);


        // Продукт 4
        Product product4 = new Product();
        productService.saveProduct(product4);

        Price price4 = new Price(700.0, 20, product4);
        priceService.savePrice(price4);

        product4.setName("work chair");
        product4.setPrice(price4);
        product4.setType(ProductType.CHAIR);
        product4.setProducer(producer3);
        product4.setPurpose(Purpose.OFFICE);
        product4.setCatalog(catalog);
        productService.updateProduct(product4);


        // продукт 5
        Product product5 = new Product();
        productService.saveProduct(product5);

        Price price5 = new Price(550.0, 0, product5);
        priceService.savePrice(price5);

        product5.setName("book locker");
        product5.setPrice(price5);
        product5.setType(ProductType.BOOKSHELF);
        product5.setProducer(producer1);
        product5.setPurpose(Purpose.LIBRARY);
        product5.setCatalog(catalog);
        productService.updateProduct(product5);


        // продукт 6
        Product product6 = new Product();
        productService.saveProduct(product6);

        Price price6 = new Price(700.0, 10, product6);
        priceService.savePrice(price6);

        product6.setName("lounge chair for relaxation");
        product6.setPrice(price6);
        product6.setType(ProductType.LOUNGE_CHAIR);
        product6.setProducer(producer3);
        product6.setPurpose(Purpose.OUTDOOR);
        product6.setCatalog(catalog);
        productService.updateProduct(product6);


        // продукт 7
        Product product7 = new Product();
        productService.saveProduct(product7);

        Price price7 = new Price(650.0, 0, product7);
        priceService.savePrice(price7);

        product7.setName("locker for things");
        product7.setPrice(price7);
        product7.setType(ProductType.CABINET);
        product7.setProducer(producer2);
        product7.setPurpose(Purpose.OFFICE);
        product7.setCatalog(catalog);
        productService.updateProduct(product7);


        // продукт 8
        Product product8 = new Product();
        productService.saveProduct(product8);

        Price price8 = new Price(250.0, 0, product8);
        priceService.savePrice(price8);

        product8.setName("medium chest of drawers");
        product8.setPrice(price8);
        product8.setType(ProductType.DRESSER);
        product8.setProducer(producer2);
        product8.setPurpose(Purpose.HALLWAY);
        product8.setCatalog(catalog);
        productService.updateProduct(product8);


        // продукт 9
        Product product9 = new Product();
        productService.saveProduct(product9);

        Price price9 = new Price(600.0, 15, product9);
        priceService.savePrice(price9);

        product9.setName("bench for the veranda");
        product9.setPrice(price9);
        product9.setType(ProductType.BENCH);
        product9.setProducer(producer2);
        product9.setPurpose(Purpose.OUTDOOR);
        product9.setCatalog(catalog);
        productService.updateProduct(product9);


        // продукт 10
        Product product10 = new Product();
        productService.saveProduct(product10);

        Price price10 = new Price(150.0, 0, product10);
        priceService.savePrice(price10);

        product10.setName("illuminated mirror");
        product10.setPrice(price10);
        product10.setType(ProductType.OTHER);
        product10.setProducer(producer3);
        product10.setPurpose(Purpose.BATHROOM);
        product10.setCatalog(catalog);
        productService.updateProduct(product10);


        // продукт 11
        Product product11 = new Product();
        productService.saveProduct(product11);

        Price price11 = new Price(450.0, 15, product11);
        priceService.savePrice(price11);

        product11.setName("dining table");
        product11.setPrice(price11);
        product11.setType(ProductType.DINING_TABLE);
        product11.setProducer(producer1);
        product11.setPurpose(Purpose.DINING_ROOM);
        product11.setCatalog(catalog);
        productService.updateProduct(product11);


        System.out.println("Saved all!");
    }
}
