package client;


import server.HelloWebService;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.ws.Service;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, XMLStreamException {

        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        QName qname = new QName("http://impl.server/", "HelloWebServiceImplService");

        Service service = Service.create(url, qname);

        HelloWebService hello = service.getPort(HelloWebService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println(hello.getHelloString("Artem Ekker and Alex Konovalov"));
        System.out.print("Current time and date : -----> ");
        System.out.print(hello.getCurrentTime());
        System.out.println(" <-----");
        System.out.println(" ");

        System.out.println("Хотите выбрать еду (1) или добавить еду (2)");
        int temp = scanner.nextInt();
        if (temp == 1) {
            showFood(hello);
        } else if (temp == 2) {
            addFood(hello);
        }

        System.out.println(" ");
        System.out.println(hello.getByeString("Artem Ekker and Alex Konovalov"));
    }

    public static void showFood(HelloWebService hello) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Желаете получить информацию о калориях?" + "\n" + "Да/Нет");
        String yesno = scanner.next().toLowerCase();

        while (yesno.equals("да")) {
            System.out.println("Что вы съели?");
            String meal = scanner.next();
            System.out.println("Сколько вы съели в граммах?");
            Integer count = scanner.nextInt();
            System.out.println(hello.getCalories(meal.toLowerCase(), count));
            System.out.println(hello.getProteins(meal.toLowerCase(), count));
            System.out.println(hello.getFats(meal.toLowerCase(), count));
            System.out.println(hello.getCarbohydrates(meal.toLowerCase(), count));
            System.out.println("Желаете продолжить работу?" + "\n" + "Да/Нет");
            yesno = scanner.next().toLowerCase();
            if (yesno.toLowerCase().equals("нет")) System.exit(0);

            System.out.println("Хотите выбрать еду (1) или добавить еду (2)");
            int temp = scanner.nextInt();
            if (temp == 1) {
                showFood(hello);
            } else if (temp == 2) {
                addFood(hello);
            } else break;
        }
    }

    public static void addFood(HelloWebService hello) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Желаете добавить еду?" + "\n" + "Да/Нет");
        String addFoodyesno = scanner.next().toLowerCase();

        while (addFoodyesno.equals("да")) {
            System.out.println("dobavit' jra4ky");
            String addedMeal = scanner.next();
            System.out.println("dobavit' kaloriynost");
            double cal = scanner.nextDouble();
            System.out.println("dobavit' yglevodi");
            double carb = scanner.nextDouble();
            System.out.println("dobavit' belo4eGG");
            double bel = scanner.nextDouble();
            System.out.println("dobavit' jirnost");
            double fat = scanner.nextDouble();
            hello.addFood(addedMeal, cal, fat, bel, carb);
            System.out.println("Желаете продолжить работу?" + "\n" + "Да/Нет");
            addFoodyesno= scanner.next().toLowerCase();
            if (addFoodyesno.toLowerCase().equals("нет")) System.exit(0);

            System.out.println("Хотите выбрать еду (1) или добавить еду (2)");
            int temp = scanner.nextInt();
            if (temp == 1) {
                showFood(hello);
            } else if (temp == 2) {
                addFood(hello);
            } else break;
        }
    }

}
