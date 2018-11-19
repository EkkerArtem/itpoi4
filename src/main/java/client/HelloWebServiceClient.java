package client;

// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса
import java.io.FileNotFoundException;
import java.net.URL;
// такой эксепшн возникнет при работе с объектом URL
import java.net.MalformedURLException;

// классы, чтобы пропарсить xml-ку c wsdl описанием
// и дотянуться до тега service в нем
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.ws.Service;

// интерфейс нашего веб-сервиса (нам больше и нужно)
import server.HelloWebService;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, XMLStreamException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://impl.server/", "HelloWebServiceImplService");


        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService hello = service.getPort(HelloWebService.class);

        // Ура! Теперь можно вызывать удаленный метод
        System.out.println(hello.getHelloString("Artem Ekker and Alex Konovalov"));
        System.out.print("Current time and date : -----> ");
        System.out.print(hello.getCurrentTime());
        System.out.println(" <-----");
        System.out.println(" ");
        System.out.println(hello.getCalories("мясо",150));
        System.out.println(hello.getProteins("мясо",150));
        System.out.println(hello.getFats("мясо",150));
        System.out.println(hello.getHarbohydrates("мясо",150));
        System.out.println(hello.getCalories("Рыба",250));
        System.out.println(hello.getProteins("Рыба",250));
        System.out.println(hello.getFats("Рыба",250));
        System.out.println(hello.getHarbohydrates("Рыба",250));
        System.out.println(" ");
        System.out.println(hello.getByeString("Artem Ekker and Alex Konovalov"));
    }
}
