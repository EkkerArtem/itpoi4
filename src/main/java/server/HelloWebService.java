package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String getHelloString(String name);

    @WebMethod
    public double radnomizer();

    @WebMethod
    public String getRandomProgrammingLanguage();

    @WebMethod
    public Date getCurrentTime();

    @WebMethod
    public String getByeString(String name);
}
