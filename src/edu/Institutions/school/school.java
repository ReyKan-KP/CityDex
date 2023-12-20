package edu.Institutions.school;
import edu.EducationalInstitutions;


public class school extends EducationalInstitutions {

    private String principal;

    public school(int id,String name, String city, String website, int fee, String address,int rating,String principal) {
        super(id,name, city, website, fee, address,rating);
        this.principal=principal;
    }

    public school(String name, String city, String website, int fee, String address,int rating,String principal) {
        super(name, city, website, fee, address,rating);
        this.principal=principal;
    }

    public school() {
        super();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return
               super.toString()+ "principal='" + principal;

    }
}
