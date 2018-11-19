package server.impl;

// таже аннотация, что и при описании интерфейса,
import server.HelloWebService;

import javax.jws.WebService;
import java.util.Date;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "server.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {
    @Override
    public String getHelloString(String name) {
        // просто возвращаем приветствие
        return "Hello, " + name + "!";
    }

    @Override
    public double radnomizer() {
        double rez = Math.random()*100;
        return rez;
    }

    @Override
    public String getRandomProgrammingLanguage() {
        double rez = Math.random()*100;
        String rezString = null;
        if (rez>=0 && rez <20)
            rezString = "Java";
        else if (rez>=20 && rez <40)
            rezString = "C++";
        else if (rez>=40 && rez <60)
            rezString = "C#";
        else if (rez>=60 && rez <80)
            rezString = "Objective C";
        else if (rez>=80 && rez <=100)
            rezString = "JavaScript";
        return rezString;
    }

    @Override
    public Date getCurrentTime() {
        return new Date();
    }

    @Override
    public String getByeString(String name) {
        return "Bye, " + name + ":)";
    }

}


