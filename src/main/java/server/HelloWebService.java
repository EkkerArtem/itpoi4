package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

@WebService

@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {

    @WebMethod
    public String getHelloString(String name);

    @WebMethod
    public Date getCurrentTime();

    @WebMethod
    public String getByeString(String name);

    public String getCalories(String meal, int count);

    public String getFats(String meal, int count);

    public String getProteins(String meal, int count);

    public String getHarbohydrates(String meal, int count);





}
