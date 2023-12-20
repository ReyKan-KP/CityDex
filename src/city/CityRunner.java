package city;
import edu.Institutions.school.SchoolRunner;
import facilities.hotels.HotelRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class CityRunner {
    City city;

    public CityRunner(City city) {
        this.city = city;
    }


    public void runner() throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();

        String query = "select * from hotels where city =" + "'" + this.city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
boolean isTrue=true;
        do{
            System.out.println("Enter 1.Hotels 2.Hospitals 3.Educational institutions 4.Transport facilities 5.Exit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());


        switch (c) {
            case 1: {
                HotelRunner.main(city);
                break;
            }
            case 3: {
               boolean sst=true;
                do{
                    System.out.println("Enter 1.Schools 2.Colleges 3.Exit Educational Institutions");
                   int cc=Integer.parseInt(br.readLine());
                    switch(cc){
                        case 1:{
                            SchoolRunner.main(city);
                            break;
                        }
                        case 2:{
                            break;
                        }

                        case 3:{
                            sst=false;
                            break;
                        }


                    }

                }while (sst);
                break;
            }

            default:{
                isTrue=false;
                break;
            }
        }
    }while (isTrue);
    }

}
