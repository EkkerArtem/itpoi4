package server.impl;

import server.HelloWebService;

import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface = "server.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {
    private HashMap<String, Double> caloriesMap = new HashMap<>();
    private HashMap<String, Double> proteinMap = new HashMap<>();
    private HashMap<String, Double> fatMap = new HashMap<>();
    private HashMap<String, Double> carbohydratesMap = new HashMap<>();

    {
        caloriesMap.put("мясо",1.43);
        caloriesMap.put("рыба",2.06);
        caloriesMap.put("курица",2.14);

        proteinMap.put("мясо",.26);
        proteinMap.put("рыба",.22);
        proteinMap.put("курица",.24);

        fatMap.put("мясо",.16);
        fatMap.put("рыба",.21);
        fatMap.put("курица",0.13);

        carbohydratesMap.put("мясо",.0);
        carbohydratesMap.put("рыба",.0);
        carbohydratesMap.put("курица",.0);
    }



    @Override
    public String getHelloString(String name) {
        return "Hello, " + name + "!" + "\n" + "На данный момент выбор продуктов : " + caloriesMap.keySet().toString();
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
        double rez = caloriesMap.get(meal) * count;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " калорий!";
    }

    @Override
    public String getFats(String meal, int count) {
        double rez = fatMap.get(meal) * count;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " жиров!";
    }

    @Override
    public String getProteins(String meal, int count) {
        double rez = proteinMap.get(meal) * count;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " белка!";
    }

    @Override
    public String getCarbohydrates(String meal, int count) {
        double rez = carbohydratesMap.get(meal) * count;
        return "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " углеводов!";
    }

    @Override
    public HashMap getInfo() {
        return caloriesMap;
    }

    @Override
    public void addFood(String name, double calories, double fat, double proteins, double carbohydrates) {
        caloriesMap.put(name,calories);
        fatMap.put(name,fat);
        proteinMap.put(name,proteins);
        carbohydratesMap.put(name,carbohydrates);
    }


}




