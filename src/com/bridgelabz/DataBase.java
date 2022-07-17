package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.sql.*;

public class DataBase {
    static Connection a = null;

    public static void main(String[] args) throws SQLException {
        a = connected();
        reteriveData(a);
    }


    public static Connection connected() {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/payrollService1?useSSL=false";
        String userName = "root";
        String password = "Krunali29!";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
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
        return connection;
    }

    public static String reteriveData(Connection connection) throws SQLException {
        String deptName = null;
        String query = "select * from employeePayroll where id=? or name =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 6);
        preparedStatement.setString(2, "Priya");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //      System.out.println(resultSet.getInt("id"));
            //      System.out.println(resultSet.getString("name"));
            deptName = (resultSet.getString("dept"));
            //      System.out.println(resultSet.getString("startDate"));
        }
        return deptName;
    }

    public static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}