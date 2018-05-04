package kz.kaznitu.lessons.mod;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Football {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

   // @Pattern(regexp = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org)|(kz))",message = "Error email")
    private String email;

    @ManyToMany
    private List<Club> clubs;

    public Football(){
        super();
    }

    public Football(int id, String firstName,String lastName,String email, List<Club> clubs){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.clubs=clubs;
    }
    public Football(String firstName,String lastName,String email,List<Club>clubs){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.clubs=clubs;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public List<Club> getClubs() {
        return clubs;
    }
    public void setClubs(List<Club> clubs){
        this.clubs=clubs;
    }


    public boolean hasClub(Club club){
        for(Club containedClub: getClubs()) {
            if (containedClub.getId() == club.getId() ){
                return true;
            }
        }
        return false;
    }
}
