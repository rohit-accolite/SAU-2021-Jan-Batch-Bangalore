package com.au.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class JavaAdvance {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        int min = 1, max = 100;
        int randomValue;

        Random random = new Random();

        FileOutputStream out = new FileOutputStream("text.txt");
        FileInputStream in = new FileInputStream("text.txt");

        while(true) {
            randomValue = min + random.nextInt(max);
//            System.out.println(randomValue);
            out.write(randomValue);

            if(randomValue % 5 == 0) break;
        }
        out.close();

        ArrayList<Integer> list = new ArrayList<>();
        int temp;
        while((temp = in.read()) != -1) {
            list.add(temp);
        }

        int id = list.stream().filter(e -> e%5 == 0).map(e -> e*2).reduce(0, (a, b)-> a+b);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
        String username = "sMkXvyYxZM";
        String password = "8h9tWhCKws";

        Connection connection = DriverManager.getConnection(url, username, password);

        String query = "insert into test values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        String name = "Rohit Verma";
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.execute();

        ResultSet result = preparedStatement.executeQuery("select * from test");
        while(result.next()) {
            String idResult = result.getString("id");
            String nameResult = result.getString("name");
            System.out.println("Name,id - " + nameResult + "," + idResult);
        }

        connection.close();

        return;
    }
}
