package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static final int PORT = 9000;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public Server() {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Сервер запустился");
        Socket clientSocket = null;

        try {
            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);

                Thread clientHandlerThread = new Thread(client);
                clientHandlerThread.setDaemon(true);
                clientHandlerThread.start();

                clients.add(client);
                System.out.println("Клиент подключился");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendMessageToAllClients(String message) {
        try {
            for (ClientHandler entry : clients) {

                entry.sendMessage(message);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
