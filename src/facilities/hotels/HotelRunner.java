package facilities.hotels;
import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;

public class HotelRunner {
   static ArrayList<Hotel> hotelarray=new ArrayList<>();

   static double average;
    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();

        String query = "select * from hotels where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            Hotel h = new Hotel();
            h.setId(id);
            h.setName(resultSet.getString("HOTEL_NAME"));
            h.setCity(resultSet.getString("CITY"));
            h.setAddress(resultSet.getString("ADDRESS"));
            h.setContact(resultSet.getString("CONTACT_INFO"));
            h.setRating(Integer.parseInt(resultSet.getString("Rating")));
            h.setCost_per_day(Integer.parseInt(resultSet.getString("Cost_To_Stay")));
            h.setLocation(resultSet.getString("Location"));
            hotelarray.add(h);
            id++;
        }
        for (Hotel i : hotelarray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }
        String query2 = "select avg(cost_to_stay) as Average from hotels where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet2 = statement.executeQuery(query2);

        while(resultSet2.next()) {
            average= Double.parseDouble(resultSet2.getString(1));
            System.out.println("The average cost to stay in the hotel in this city per night is :" + average);
        }
        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the hotels 2.To go to Hotel's Webpage 3.To go to google maps 4.Exit Hotels");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1: {

                    System.out.println("The details of all the hotels in " + city.getCity() + " are:");
                    for (Hotel i : hotelarray) {
                        System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter the id of the hotel");
                    int idd=Integer.parseInt(br.readLine());
                    for (Hotel j:hotelarray){
                        if(j.getId()==idd){
                            try {

                                URI uri= new URI(j.getContact());
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
                    System.out.println("Enter the id of the hotel");
                    int idf=Integer.parseInt(br.readLine());
                    for (Hotel j:hotelarray){
                        if(j.getId()==idf){
                            try {

                                URI uri= new URI(j.getLocation());
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

