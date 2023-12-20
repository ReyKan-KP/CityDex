
package person;
public class Person {

    protected int id;
    protected String name;
    protected String username;
    protected String password;
    protected String mail;

    public Person(int id, String name, String username, String password, String mail) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                        ", name= " + name  +
                        ", username= " + username +
                        ", password= " + password +
                        ", mail= " + mail ;
    }
}
