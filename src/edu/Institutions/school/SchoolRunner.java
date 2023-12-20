package edu.Institutions.school;
import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;

public class SchoolRunner {
    static ArrayList<school> schoolarray=new ArrayList<>();

    static double average;
    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();

        String query = "select * from schools where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            school h = new school();
            h.setId(id);
            h.setName(resultSet.getString("NAME"));
            h.setCity(resultSet.getString("CITY"));
            h.setAddress(resultSet.getString("ADDRESS"));
            h.setWebsite(resultSet.getString("Website"));
            h.setRating(Integer.parseInt(resultSet.getString("Rating")));
            h.setFee(Integer.parseInt(resultSet.getString("Monthly_Fee"))*12);
            schoolarray.add(h);
            id++;
        }
        for (school i : schoolarray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }
        String query2 = "select avg(Monthly_Fee) as Average from schools where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet2 = statement.executeQuery(query2);

        while(resultSet2.next()) {
            average= Double.parseDouble(resultSet2.getString(1));
            System.out.println("The average fee per month for a school in this city is :" + average*12);
        }
        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the schools 2.To go to school's Webpage 3.To go to google maps 4.Exit schools");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1: {

                    System.out.println("The details of all the schools in " + city.getCity() + " are:");
                    for (school i : schoolarray) {
                        System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter the id of the school");
                    int idd=Integer.parseInt(br.readLine());
                    for (school j:schoolarray){
                        if(j.getId()==idd){
                            try {

                                URI uri= new URI(j.getWebsite());
                                System.out.println(uri);

                                java.awt.Desktop.getDesktop().browse(uri);
                                System.out.println("Web page opened in browser");

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        }

                    }
                    break;
                }
                case 3:{
                    System.out.println("Enter the id of the school");
                    int idf=Integer.parseInt(br.readLine());
                    for (school j:schoolarray){
                        if(j.getId()==idf){
                            try {

                                URI uri= new URI(j.getAddress());
                                System.out.println(uri);

                                java.awt.Desktop.getDesktop().browse(uri);
                                System.out.println("Web page opened in browser");

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        }

                    }
                    break;
                }
                case 4:{
                    isTrue=false;
                    break;
                }
            }

        }
        while (isTrue);

    }
}

