package kz.kaznitu.lessons.mod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Club{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 3,max = 50, message = "Error")
    private String label;

    @NotNull
    @Size(min = 3,max = 50, message = "Error")
    private String description;

    @NotNull
    @Size(min = 3,max = 50, message = "Error")
//    @Email
    //@Pattern(regexp = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org)|(kz))",message = "Error email")
    private String email;

    public Club(){
        super();
    }

    public Club(int id, String label, String description, String email){
        this.id=id;
        this.label=label;
        this.description=description;
        this.email=email;
    }
    public Club(String label,String description, String email){
        this.label=label;
        this.description=description;
        this.email=email;
    }

    public int getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label){
        this.label=label;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}