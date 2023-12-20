package facilities.hotels;
import facilities.*;
public class Hotel extends facilities{
    private int cost_per_day;
    private int id;
    public Hotel(String name, String address, String city, String contact, int rating,int cost,String location) {
        super(name, address, city, contact, rating,location);
        this.cost_per_day=cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel() {
        super();
    }

    public int getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(int cost_per_day) {
        this.cost_per_day = cost_per_day;
    }

    @Override
    public String toString() {
        return super.toString()+
                "cost_per_day=" + cost_per_day;
    }
}
