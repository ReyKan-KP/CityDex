package person.user;

import person.Person;

public class User extends Person {

    private String city;
    private String contact;

    public User(int id, String name, String username, String password, String mail, String city, String contact) {
        super(id,name, username, password, mail);
        this.city = city;
        this.contact = contact;
    }


    public User() {
        super();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
                " id= " + id +
                        " name= " + name +
                        " Username= "+username+
                        " mail= " + mail + ", city= "+city
                ;
    }
}
