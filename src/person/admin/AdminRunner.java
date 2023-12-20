
package person.admin;
import city.City;
import person.user.User;
import requestr.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.exit;

public class AdminRunner {

    static ArrayList<Admin> arr = new ArrayList<>();
   public static ArrayList<Requester> req=new ArrayList<>();
    public static ArrayList<Requester> requn = new ArrayList<>();
    public static ArrayList<Requester> req_ap = new ArrayList<>();
    static BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));


    static void displayAdmins() {
        for (Admin i : arr
        ) {

            System.out.println(i);

        }
    }

    static void requestAcceptor() throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();


        ResultSet resultSet1 = statement.executeQuery("select * from requests");

        int ii = 1;
        int jj = req_ap.size()+1;
        int idd=1;
        req.clear();
        requn.clear();
        req_ap.clear();
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("address"));
            Requester r = new Requester();
            r.setId(idd);
            r.setUsername(resultSet1.getString("username"));
            r.setField(resultSet1.getString("Field"));
            r.setStatus(resultSet1.getString("status"));
            r.setFieldname(resultSet1.getString("name"));
            r.setFieldAddress(resultSet1.getString("address"));
            r.setFieldContact(resultSet1.getString("contact"));
            r.setFieldCity(resultSet1.getString("city"));
            r.setFieldRating(resultSet1.getByte("rating"));
            r.setFieldLocation(resultSet1.getString("location"));
            r.setFiledCost(resultSet1.getInt("cost"));
            r.setFieldFee(resultSet1.getInt("fee"));
            r.setFieldPrincipal(resultSet1.getString("principal"));
            idd++;
            req.add(r);



        }
        ii = 1;
         jj = req_ap.size()+1;
         idd=1;


        for(Requester i:req){
            if (i.getStatus().equals("Approved")){
                req_ap.add(i);
            }
        }




    }

    static void showRequests() throws IOException {

        boolean ku = true;
      do{

          System.out.println("Press 1 to show requests 2.Exit");
          int choices = Integer.parseInt(brr.readLine());
          switch (choices) {
            case 1: {
                for(Requester i:req){
                  {
                        System.out.println(i);
                    }
                }
            }

          case 2: {
              ku = false;
              break;
          }
        }
    }while (ku);

    }

    static void acceptRequests() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();

        boolean ko=true;

        do {
            System.out.println("Press the id of the request you want to accept or press 0 to exit this..");
            int kl = Integer.parseInt(brr.readLine());
            if (kl == 0) {
                ko = false;
                break;
            }
            String uname = "";
            String addr = "";

            for (Requester i : req) {
                if (i.getId() == kl) {
                    if (i.getStatus().equalsIgnoreCase("not approved")) {
                        i.setStatus("Approved");

                        req_ap.add(i);
                        uname = i.getUsername();
                        addr = i.getFieldAddress();
                        System.out.println(i.getField());
                        if (i.getField().equalsIgnoreCase("hotel")) {
                          String  city = i.getFieldCity();
                          String  name = i.getFieldname();
                          int  rating = i.getFieldRating();
                           String address = i.getFieldAddress();
                           String contact = i.getFieldContact();
                          int  cost = i.getFiledCost();
                           String location = i.getFieldLocation();
                            String queryx = "insert into hotels(city,hotel_name,rating,address,contact_info,cost_to_stay,location) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating + ",'" + address + "'" + ",'" + contact + "'" + "," + cost + ",'" + location + "'"+");";
                            System.out.println(queryx);
                            statement.executeUpdate(queryx);

                        }
                        else if(i.getField().equalsIgnoreCase("school")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String contact = i.getFieldContact();
                            int  cost = i.getFieldFee();
                            String location = i.getFieldLocation();
                            String princ=i.getFieldPrincipal();
                            String queryx = "insert into schools(city,name,Rating,website,Monthly_fee,Address,Name_of_Principle) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + contact + "'" + "," + cost + ",'" + location + "'"+",'"+ princ+"'" +");";
                            System.out.println(queryx);
                            statement.executeUpdate(queryx);
                        }
                        break;
                    }
                }
            }
            Iterator it = req.iterator();
//            while (it.hasNext()) {
//                Requester ss = (Requester) it.next();
//                System.out.println(ss);
//                if (ss.getId() == kl) {
//                    it.remove();
//                    break;
//                }
//            }
            String queryy = "update requests set status='Approved' where username = " + "'" + uname + "'" + "and address = " + "'" + addr + "'" + ";";
            statement.executeUpdate(queryy);
        }while (ko);
    }

    public static void login() throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();


        ResultSet resultSet = statement.executeQuery("select * from adminprofiles");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the Username: ");

        String uname = br.readLine();
        boolean flag = false;
        for (Admin i : arr) {
            if (i.getUsername().equals(uname)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Enter the password : ");
            String admin_password = br.readLine();

            for (Admin i : arr) {
                if (i.getUsername().equals(uname)) {
                    if (i.getPassword().equals(admin_password)) {
                        System.out.println("You have logged in successfully!!");
                        boolean Istrue = true;

                        do {

                            break;

                        } while (Istrue);
                    } else {
                        System.out.println("Incorrect password try again");
                        exit(0);
                    }
                }

            }
        } else {
            System.out.println("Enter valid Username");
        }


    }



   public static void requestManager() throws IOException, SQLException {
       req.clear();
       requn.clear();
       req_ap.clear();
       requestAcceptor();
       showRequests();

       boolean ki=true;
       do{
           System.out.println("Press 1.To re-display requests 2.To accept requests 3.Exit");
           int kkk = Integer.parseInt(brr.readLine());

           switch (kkk) {
               case 1: {

                   showRequests();
                   break;
               }
               case 2: {
                   acceptRequests();
                   break;
               }
               case 3:{ki=false;
               req.clear();
               }

           }
   }while (ki);

    }

    public static void main() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","sandeep369");

        Statement statement=connection.createStatement();


//        String query1 = "UPDATE people SET name = 'Lord' WHERE name='Alfred Schmidt';";
//        statement.executeUpdate(query1);

        ResultSet resultSet= statement.executeQuery("select * from adminprofiles");
        int i=1;

        while (resultSet.next()) {
            Admin u =new Admin();

            String k = resultSet.getString("Name");
            u.setId(i);
            u.setName(resultSet.getString("Name"));
            u.setPassword(resultSet.getString("Password"));
            u.setUsername(resultSet.getString("Username"));
            u.setMail(resultSet.getString("Email"));
            i++;
            arr.add(u);


        }


    }

}
