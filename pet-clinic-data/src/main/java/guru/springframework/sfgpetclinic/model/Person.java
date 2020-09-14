package guru.springframework.sfgpetclinic.model;

public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

    public Person(){}
    public Person(Long id, String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        super.setId(id);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
