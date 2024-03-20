package server;

import server.controllers.Controller;
import server.product.Product;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {

    private Server server;
    private BufferedWriter outMessage;
    private BufferedReader inMessage;
    private Socket clientSocket = null;
    private static int clientCount = 0;

    private List<Product> products;

    private List<Product> orderProducts;

    private final Controller controller = new Controller();

    public ClientHandler(Socket socket, Server server) {
        try {

            clientCount++;
            this.server = server;
            this.clientSocket = socket;
            this.inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outMessage = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            products = controller.getAllProducts();
            orderProducts = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws IOException {
        outMessage.write(message);
        outMessage.newLine();
        outMessage.flush();
    }

    public void closeConnection() {
        server.removeClient(this);
        clientCount--;
        System.out.println("Клиент " + this + "отключился");
    }

    @Override
    public void run() {
        try {
            while (true) {

                System.out.println("WAIT!");
                String clientMessage = inMessage.readLine();
                System.out.println("Client write: " + clientMessage);

                if (clientMessage.equals("EXIT")) {
                    closeConnection();
                    break;
                }

                if (clientMessage.equals("GET")) {
                    sendMessage("Товары: ");
                    for (Product product : products) {
                        sendMessage("Название - " + product.getName() + ";  Назначение - " + product.getPurpose() +
                                ";  Тип - " + product.getType() + ";  Цена - " + product.getPrice().getTotalPrice() +
                                "; Производитель - " + product.getProducer().getName());
                    }
                    sendMessage("");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.equals("ORDER_SHOW")) {
                    sendMessage("Корзина: ");
                    double sum = 0.0;
                    for (Product product : orderProducts) {
                        sendMessage("Название - " + product.getName() + ";  Назначение - " + product.getPurpose() +
                                ";  Тип - " + product.getType() + ";  Цена - " + product.getPrice().getTotalPrice() +
                                "; Производитель - " + product.getProducer().getName());
                        sum += product.getPrice().getTotalPrice();
                    }
                    sendMessage("Сумма = " + sum);
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.equals("ORDER_ADD")) {
                    orderProducts.addAll(products);
                    products = controller.getAllProducts();

                    sendMessage("Товары были добавлены в корзину");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.equals("ORDER_MAKE")) {
                    sendMessage("Товары были заказаны: ");
                    double sum = 0.0;
                    for (Product product : orderProducts) {
                        sendMessage("Название - " + product.getName() + ";  Назначение - " + product.getPurpose() +
                                ";  Тип - " + product.getType() + ";  Цена - " + product.getPrice().getTotalPrice() +
                                "; Производитель - " + product.getProducer().getName());
                        sum += product.getPrice().getTotalPrice();
                    }
                    sendMessage("Сумма = " + sum);
                    sendMessage("/END");

                    orderProducts.clear();
                    products = controller.getAllProducts();
                    continue;
                }

                if (clientMessage.equals("SORT_INCREASE")) {
                    products = controller.sortByIncreasePrice(products);
                    sendMessage("Успешно отсортировано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.equals("SORT_DECREASE")) {
                    products = controller.sortByDecreasePrice(products);
                    sendMessage("Успешно отсортировано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.equals("SORT_NAME")) {
                    products = controller.sortByName(products);
                    sendMessage("Успешно отсортировано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.startsWith("FILTER_TYPE_")) {
                    products = controller.filterByType(products, clientMessage.substring(12));
                    sendMessage("Успешно отфильтровано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.startsWith("FILTER_PRODUCER_")) {
                    products = controller.filterByProducer(products, clientMessage.substring(16));
                    sendMessage("Успешно отфильтровано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.startsWith("FILTER_NAME_")) {
                    products = controller.filterByName(products, clientMessage.substring(12));
                    sendMessage("Успешно отфильтровано!");
                    sendMessage("/END");
                    continue;
                }

                if (clientMessage.startsWith("FILTER_PURPOSE_")) {
                    products = controller.filterByPurpose(products, clientMessage.substring(15));
                    sendMessage("Успешно отфильтровано!");
                    sendMessage("/END");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
        }
    }
}
