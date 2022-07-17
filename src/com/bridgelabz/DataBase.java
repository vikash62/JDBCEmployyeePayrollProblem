package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DataBase {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/payrollService1?useSSL=false";
        String userName = "root";
        String password = "";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        listDrivers();
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is Successful" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}