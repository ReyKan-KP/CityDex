package city;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class City {

    private String city;

    public City(String city) {
        this.city = city;
    }

    public City() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return
                "city='" + city ;
    }

    public static void main() throws IOException, SQLException {

        boolean istrue=true;
        do{
            City city = new City();
            CityRunner cityRunner = new CityRunner(city);
            System.out.println("Select a city");
        System.out.println("1.Kolkata");
        System.out.println("2.Mumbai");
        System.out.println("3.Delhi");
        System.out.println("4.Chennai");
            System.out.println("5.Exit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        switch (s) {

            case 1: {
                city.setCity("Kolkata");
                cityRunner.runner();
                break;
            }
            case 2: {
                city.setCity("Mumbai");
                cityRunner.runner();
                break;
            }

            case 3: {
                city.setCity("Delhi");
                cityRunner.runner();
                break;
            }
            case 4: {
                city.setCity("Chennai");
                cityRunner.runner();
                break;
            }

            case 5:{
                istrue=false;
                break;
            }

        }
    }while (istrue);
    }
}
