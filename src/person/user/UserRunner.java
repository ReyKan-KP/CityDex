
package person.user;
import city.City;
import com.sun.net.httpserver.Request;
import requestr.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class UserRunner {

    static ArrayList<User> arr= new ArrayList<>();
    static void displayUsers(){
        for (User i: arr
        ) {

            System.out.println(i);

        }
    }

    static void updateprofile(User i) throws SQLException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","sandeep369");

        Statement statement=connection.createStatement();

        boolean isTrue=true;

        while (isTrue)
        {
            System.out.println("Select 1)Update username 2)Update password 3)Update Email 4)Update Name 5)Update City");
            int selection = Integer.parseInt(br.readLine());
            switch(selection){
                case 1: {
                    try {
                        System.out.println("Enter your new username:");
                        String k = i.getUsername();
                        i.setUsername(br.readLine());
                        String query1 = "UPDATE userprofiles SET Username =" + "\'" + i.getUsername() + "\'" + " WHERE Username=" + "\'" + k + "\'" + ";";
                        statement.executeUpdate(query1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 2: {
                    try {
                        System.out.println("Enter your old password");
                        String str = br.readLine();
                        if (str.equals(i.getPassword())) {
                            System.out.println("Enter your new password:");
                            i.setPassword(br.readLine());
                            System.out.println("Confirm your new password:");
                            String h = br.readLine();
                            if (h.equals(i.getPassword())) {
                                String query2 = "UPDATE userprofiles SET Password =" + "\'" + i.getPassword() + "\'" + " WHERE Username=" + "\'" + i.getUsername() + "\'" + ";";
                                statement.executeUpdate(query2);
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                }
                case 3: {
                    try {
                        System.out.println("Enter your new email:");
                        i.setMail(br.readLine());
                        String query3 = "UPDATE userprofiles SET Email =" + "\'" + i.getMail() + "\'" + " WHERE Username=" + "\'" + i.getUsername() + "\'" + ";";
                        statement.executeUpdate(query3);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                }
                case 4: {
                    try{  System.out.println("Enter a new name:");
                        i.setName(br.readLine());
                        String query4 = "UPDATE userprofiles SET Name =" + "\'" + i.getName() + "\'" + " WHERE Username=" + "\'" + i.getUsername() + "\'" + ";";
                        statement.executeUpdate(query4);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;}
                case 5: {
                    try{System.out.println("Enter your city:");
                        i.setCity(br.readLine());
                        String query5 = "UPDATE userprofiles SET City =" + "\'" + i.getCity() + "\'" + " WHERE Username=" + "\'" + i.getUsername() + "\'" + ";";
                        statement.executeUpdate(query5);}
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                }
                case 6: {
                    isTrue = false;
                    break;
                }

            }

        }

    }

   public static void signup() throws SQLException, IOException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","sandeep369");

        Statement statement=connection.createStatement();



        ResultSet resultSet= statement.executeQuery("select * from userprofiles");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter your name:");
            String name = br.readLine();
            System.out.println("Enter your username:");
            String unmae = br.readLine();
            System.out.println("Enter the password:");
            String pass = br.readLine();
            System.out.println("Enter your City:");
            String city = br.readLine();
            System.out.println("Enter your mail:");
            String mail = br.readLine();

            User u=new User();
            u.setName(name);
            u.setUsername(unmae);
            u.setPassword(pass);
            u.setCity(city);
            u.setMail(mail);
if(mail.contains("@") && mail.contains(".com")) {
    String query = "INSERT INTO userprofiles (Name, UserName, Email, Password, City) Values(" + "\'" + name + "\'," + "\'" + unmae + "\'," + "\'" + mail + "\'," + "\'" + pass + "\'," + "\'" + city + "\'" + ");";

    statement.executeUpdate(query);
    System.out.println("You have successfully signed up!!!");
    System.out.println("Enter 1 to Update your profile (or) 2 to search for a city: ");
    int crud = Integer.parseInt(br.readLine());

    switch (crud){

        case 1:{
            System.out.println("You are updating your profile!!");
            updateprofile(u);
            break;
        }
        case 2:{
            City.main();
            break;

        }
    }
}
else {
    System.out.println("Enter valid email!!!");
}
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
    public static void login() throws IOException, SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","sandeep369");

        Statement statement=connection.createStatement();



        ResultSet resultSet= statement.executeQuery("select * from userprofiles");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Requester r=new Requester();
        System.out.println("Enter the Username: ");

        String uname=br.readLine();
        boolean flag=false;
        for(User i:arr){
            if(i.getUsername().equals(uname)){
                flag=true;
            }
        }
        if(flag) {
            System.out.println("Enter the password : ");
            String admin_password = br.readLine();

            for (User i : arr) {
                if (i.getUsername().equals(uname)) {
                    if (i.getPassword().equals(admin_password)) {
                        System.out.println("You have logged in successfully!!");
                        boolean Istrue = true;

                        do {
                            System.out.println("Enter 1 to Update your profile (or) 2 to search for a city (or) 3.Request for hosting 4.Logout ");
                            int crud = Integer.parseInt(br.readLine());

                            switch (crud) {
                                case 1:
                                    System.out.println("You are updating your profile...");
                                    updateprofile(i);
                                    break;
                                case 2:
                                    City.main();
                                    break;
                                case 3:
                                   r.request(i);
                                    break;
                                case 4:
                                    Istrue = false;
                                    break;

                            }
                        } while (Istrue);
                    } else {
                        System.out.println("Incorrect password try again");
                        exit(0);
                    }
                }

            }
        }
        else{
            System.out.println("Enter valid Username");
        }


    }

    public static void main() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","sandeep369");

        Statement statement=connection.createStatement();


//        String query1 = "UPDATE people SET name = 'Lord' WHERE name='Alfred Schmidt';";
//        statement.executeUpdate(query1);

        ResultSet resultSet= statement.executeQuery("select * from userprofiles");
        int i=1;

        while (resultSet.next()) {
            User u =new User();

            String k = resultSet.getString("Name");
            u.setId(i);
            u.setName(resultSet.getString("Name"));
            u.setCity(resultSet.getString("City"));
            u.setPassword(resultSet.getString("Password"));
            u.setUsername(resultSet.getString("Username"));
            u.setMail(resultSet.getString("Email"));
            i++;
            arr.add(u);


        }


    }
}