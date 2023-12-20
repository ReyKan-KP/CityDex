package coderunner;
import person.admin.AdminRunner;
import person.user.UserRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class startswitch {

    public static <bool> void main() throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sandeep369");

        Statement statement = connection.createStatement();


//        String query1 = "UPDATE people SET name = 'Lord' WHERE name='Alfred Schmidt';";
//        statement.executeUpdate(query1);

        ResultSet resultSet = statement.executeQuery("select * from adminprofiles");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        UserRunner q = new UserRunner();
        AdminRunner r=new AdminRunner();
        boolean istrue = true;

        do {
            System.out.println("Enter 1 if you are User (or) 2 if you are Admin ");
            int profile = Integer.parseInt(br.readLine());
            boolean real = true;

            switch (profile) {
                case 1:
                    do {
                        System.out.println("Enter 1 to Login (or) 2 to Sign Up 3.Exit");
                        int action = Integer.parseInt(br.readLine());
                        switch (action) {
                            case 1:
                                q.main();
                                q.login();
                                break;
                            case 2:
                                System.out.println("You are trying to signup");
                                q.main();
                                q.signup();
                                break;
                            case 3:
                                real = false;
                                break;

                        }
                    } while (real);


                    break;

                case 2: do{
                    System.out.println("Enter 1 to Login (or) 2.Exit");
                    int action = Integer.parseInt(br.readLine());
                    switch(action) {
                        case 1: {
                            System.out.println("You are Admin...");
                            r.main();

                            r.login();
                            System.out.println("Do you want to check requests?");
                            String ans = br.readLine();
                            if (ans.equalsIgnoreCase("yes")) {
                                r.requestManager();
                            }
                            break;
                        }
                        case 2:real=false;
                        break;
                    }
                }while(real);
                case 3: {
                    istrue = false;
                    break;
                }


            }


        } while (istrue);
    }
}


