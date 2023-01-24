package sn.isi.securiteweb.entities;

import jakarta.persistence.*;
import org.apache.commons.beanutils.BeanUtils;
import sn.isi.securiteweb.dto.UserDto;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastname;

    private  String firstname;

    private int phonenumber;

    private String email;



    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Compte compte;

    public User() {}

    public User(UserDto userDto) {
        try {
            BeanUtils.copyProperties(this, userDto);
        } catch (Exception e) {
            // do anything
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phonenumber;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


