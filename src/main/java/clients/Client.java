package clients;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            Scanner scanner = new Scanner(System.in);

            while (true) {

                String message = ("""
                        1. Просмотр
                        2. Фильтр
                        3. Сортировка
                        4. Заказ
                        5. Выход
                        """);
                System.out.println(message);
                System.out.print("\nВыберите действие: ");
                String choice = scanner.nextLine();

                String request = "";

                switch (choice) {
                    case "1":
                        request = "GET";
                        break;

                    case "2":
                        System.out.println("""
                                1. По типу
                                2. По имени
                                3. По производителю
                                4. По назначению
                                """);
                        System.out.print("\nВыберите действие: ");
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "1":
                                System.out.print("Тип: ");
                                request = "FILTER_TYPE_" + scanner.nextLine().toUpperCase();
                                break;
                            case "2":
                                System.out.print("Имя: ");
                                request = "FILTER_NAME_" + scanner.nextLine().toUpperCase();
                                break;
                            case "3":
                                System.out.print("Производитель: ");
                                request = "FILTER_PRODUCER_" + scanner.nextLine().toUpperCase();
                                break;
                            case "4":
                                System.out.println("Назначение: ");
                                request = "FILTER_PURPOSE_" + scanner.nextLine().toUpperCase();
                                break;
                            default:
                                break;
                        }
                        break;

                    case "3":
                        System.out.println("""
                                1. По возрастанию цены
                                2. По убыванию цены
                                3. По имени
                                """);
                        System.out.print("\nВыберите действие: ");
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "1":
                                request = "SORT_INCREASE";
                                break;
                            case "2":
                                request = "SORT_DECREASE";
                                break;
                            case "3":
                                request = "SORT_NAME";
                                break;
                            default:
                                break;
                        }
                        break;

                    case "4":
                        System.out.println("""
                                1. Добавить в корзину
                                2. Просмотреть корзину
                                3. Сделать заказ
                                """);
                        System.out.print("\nВыберите действие: ");
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "1":
                                request = "ORDER_ADD";
                                break;
                            case "2":
                                request = "ORDER_SHOW";
                                break;
                            case "3":
                                request = "ORDER_MAKE";
                                break;
                            default:
                                break;
                        }
                        break;

                    case "5":
                        request = "EXIT";
                        break;
                    default:
                        continue;
                }

                out.write(request);
                out.newLine();
                out.flush();

                if (request.equals("EXIT")) {
                    return;
                }

                printFromServer(in);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFromServer(BufferedReader in) throws IOException {
        String response;
        while ((response = in.readLine()) != null) {
            if (response.equals("/END")) {
                break;
            }
            System.out.println(response);
        }
    }
}
