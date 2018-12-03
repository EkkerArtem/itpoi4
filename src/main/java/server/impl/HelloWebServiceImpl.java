package server.impl;

import server.HelloWebService;

import javax.jws.WebService;
import java.sql.*;
import java.util.*;
import java.util.Date;

@WebService(endpointInterface = "server.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    java.sql.Connection dbConnection = null;
    String DB_DRIVER = "com.mysql.jdbc.Driver";
    String DB_CONNECTION = "jdbc:mysql://localhost:3306/FoodDB";
    String DB_USER = "root";
    String DB_PASSWORD = "";
    Statement statement = null;


    private Connection getDBConnection() {

        try {
            Class.forName(DB_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    @Override
    public String getHelloString(String name) throws SQLException {
        dbConnection = getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement( "SELECT FoodName FROM Food");
        StringBuilder rezString = new StringBuilder();
        statement = dbConnection.createStatement();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String rez = rs.getString("FoodName");
            rezString.append(rez).append(" , ");
        }
        rezString.setLength(rezString.length()-3);
        dbConnection.close();

        return "Hello, " + name + "!" + "\n" + "На данный момент выбор продуктов : " + rezString.toString();
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
    public String getCalories(String meal, int count) throws SQLException {
        dbConnection = getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement( "SELECT Calories FROM Food WHERE FoodName=?");
        ps.setString(1,meal);
        String rezString = "";
        statement = dbConnection.createStatement();
        ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double calories = rs.getDouble("Calories");
                double rez = calories * count;
                rezString = "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " калорий!";
            }
            dbConnection.close();
        return rezString;

    }

    @Override
    public String getFats(String meal, int count) throws SQLException {
        dbConnection = getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement( "SELECT Fats FROM Food WHERE FoodName=?");
        ps.setString(1,meal);
        String rezString = "";
        statement = dbConnection.createStatement();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            double calories = rs.getDouble("Fats");
            double rez = calories * count;
            rezString = "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " жиров!";
        }
        dbConnection.close();
        return rezString;
    }

    @Override
    public String getProteins(String meal, int count) throws SQLException {
        dbConnection = getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement( "SELECT Proteins FROM Food WHERE FoodName=?");
        ps.setString(1,meal);
        String rezString = "";
        statement = dbConnection.createStatement();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            double calories = rs.getDouble("Proteins");
            double rez = calories * count;
            rezString = "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " белка!";
        }
        dbConnection.close();
        return rezString;
    }

    @Override
    public String getCarbohydrates(String meal, int count) throws SQLException {
            dbConnection = getDBConnection();
            PreparedStatement ps = dbConnection.prepareStatement( "SELECT Carbohydrates FROM Food WHERE FoodName=?");
            ps.setString(1,meal);
            String rezString = "";
            statement = dbConnection.createStatement();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double calories = rs.getDouble("Carbohydrates");
                double rez = calories * count;
                rezString = "Вы съели :" + meal + " (" + count + " грамм)" + " и получили " + rez + " углеводов!";
            }
            dbConnection.close();
            return rezString;
    }

    @Override
    public void addFood(String name, double calories, double fat, double proteins, double carbohydrates) throws SQLException {
        dbConnection = getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement( "INSERT INTO Food (FoodName, Proteins, Fats, Carbohydrates, Calories) VALUES (?,?,?,?,?);");
        ps.setString(1,name);
        ps.setDouble(2,proteins);
        ps.setDouble(3,fat);
        ps.setDouble(4,carbohydrates);
        ps.setDouble(5,calories);
        statement = dbConnection.createStatement();
        ps.executeUpdate();

        dbConnection.close();

    }


}




