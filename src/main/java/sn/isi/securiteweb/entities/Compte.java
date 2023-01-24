package sn.isi.securiteweb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "comptes_droits", joinColumns = {@JoinColumn(name = "compteId")},
            inverseJoinColumns = {@JoinColumn(name = "droitsId")})
    private List<Droits> droits = new ArrayList<Droits>();


    public Compte() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Droits> getDroits() {
        return droits;
    }

    public void setDroits(List<Droits> droits) {
        this.droits = droits;
    }
}
