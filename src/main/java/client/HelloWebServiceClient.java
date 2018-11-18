package client;

// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса
import java.net.URL;
// такой эксепшн возникнет при работе с объектом URL
import java.net.MalformedURLException;

// классы, чтобы пропарсить xml-ку c wsdl описанием
// и дотянуться до тега service в нем
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

// интерфейс нашего веб-сервиса (нам больше и нужно)
import server.ByeWebService;
import server.HelloWebService;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");
        URL url2 = new URL("http://localhost:1987/wss/hello?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://impl.server/", "HelloWebServiceImplService");
        QName qname2 = new QName("http://impl.server/", "ByeWebServiceImplService");


        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        Service service2 = Service.create(url2, qname2);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService hello = service.getPort(HelloWebService.class);
        ByeWebService bye = service2.getPort(ByeWebService.class);

        // Ура! Теперь можно вызывать удаленный метод
        System.out.println(hello.getHelloString("Artem Ekker and Alex Konovalov"));
        System.out.println(hello.radnomizer());
        System.out.println(hello.getRandomProgrammingLanguage());
        System.out.println(hello.getCurrentTime());
        System.out.println(bye.getByeString("Artem Ekker and Alex Konovalov"));
    }
}
