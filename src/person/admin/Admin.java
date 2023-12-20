
package person.admin;

import person.Person;

public class Admin extends Person {
    public Admin(int id, String name, String username, String password, String mail) {
        super(id, name, username, password, mail);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", username='" + username + '\'' +
                        ", mail='" + mail + '\''
                ;
    }
}
