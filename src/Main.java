import coderunner.startswitch;
import person.admin.AdminRunner;
import requestr.Requester;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Welcome to CityDex:");

        startswitch s= new startswitch();
        s.main();
//        System.out.println(AdminRunner.requn);


    }


//        System.out.println("Admins:");
//         AdminRunner a= new AdminRunner();
//         a.main();
//         a.displayAdmins();
//        System.out.println("Users:");
//         UserRunner u=new UserRunner();
//         u.main();
//         u.displayUsers();




}

