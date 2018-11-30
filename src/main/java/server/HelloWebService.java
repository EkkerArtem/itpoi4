package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.HashMap;

@WebService

@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {

    @WebMethod
    public String getHelloString(String name);

    @WebMethod
    public Date getCurrentTime();

    @WebMethod
    public String getByeString(String name);

    @WebMethod
    public String getCalories(String meal, int count);

    @WebMethod
    public String getFats(String meal, int count);

    @WebMethod
    public String getProteins(String meal, int count);

    @WebMethod
    public String getCarbohydrates(String meal, int count);

    @WebMethod
    public HashMap getInfo();

    @WebMethod
    public void addFood(String name, double calories, double fat, double proteins, double carbohydrates);

}
