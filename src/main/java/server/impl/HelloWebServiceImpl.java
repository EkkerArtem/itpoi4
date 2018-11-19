package server.impl;

import server.HelloWebService;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "server.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public String getHelloString(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public Date getCurrentTime() {
        return new Date();
    }

    @Override
    public String getByeString(String name) {
        return "Bye, " + name + ":)";
    }

    @Override
    public String getCalories(String meal, int count) {
        double rez;
        if (meal.toLowerCase().equals("мясо")) {
            rez = count * 0.5;
        } else if (meal.toLowerCase().equals("рыба")) {
            rez = count * 1.5;
        } else if (meal.toLowerCase().equals("курица")) {
            rez = count * 1.0;
        } else rez = 0;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " калорий!";
    }

    @Override
    public String getFats(String meal, int count) {
        double rez;
        if (meal.toLowerCase().equals("мясо")) {
            rez = count * 0.3;
        } else if (meal.toLowerCase().equals("рыба")) {
            rez = count * 0.1;
        } else if (meal.toLowerCase().equals("курица")) {
            rez = count * 0.2;
        } else rez = 0;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " жиров!";
    }

    @Override
    public String getProteins(String meal, int count) {
        double rez;
        if (meal.toLowerCase().equals("мясо")) {
            rez = count * 0.5;
        } else if (meal.toLowerCase().equals("рыба")) {
            rez = count * 0.4;
        } else if (meal.toLowerCase().equals("курица")) {
            rez = count * 0.7;
        } else rez = 0;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " белка!";
    }

    @Override
    public String getHarbohydrates(String meal, int count) {
        double rez;
        if (meal.toLowerCase().equals("мясо")) {
            rez = count * 0.2;
        } else if (meal.toLowerCase().equals("рыба")) {
            rez = count * 0.05;
        } else if (meal.toLowerCase().equals("курица")) {
            rez = count * 0.1;
        } else rez = 0;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " углеводов!";
    }


}




