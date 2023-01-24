package sn.isi.securiteweb.dto;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import sn.isi.securiteweb.entities.Droits;
import sn.isi.securiteweb.entities.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;

    private String lastname;

    private String firstname;

    private String phonenumber;

    private String email;

    private Set<DroitsDto> droits;

    public UserDto() {}

    public UserDto(User user) {
        try {
            BeanUtils.copyProperties(this, user);

            this.droits = user.getCompte().getDroits().stream()
                    .map(DroitsDto::new).collect(Collectors.toSet());
        } catch (Exception e) {
            // do anything
        }
    }

    public UserDto(HttpServletRequest request) {
        this.lastname = request.getParameter("lastname");
        this.firstname = request.getParameter("firstname");
        this.phonenumber = request.getParameter("phonenumber");
        this.email = request.getParameter("email");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Set<DroitsDto> getDroits() {
        return droits;
    }

    public void setDroits(Set<DroitsDto> permissions) {
        this.droits = droits;
    }
}

