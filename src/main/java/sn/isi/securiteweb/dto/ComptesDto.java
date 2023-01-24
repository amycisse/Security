package sn.isi.securiteweb.dto;

public class ComptesDto {


    protected String username;

    protected String password;

    public ComptesDto() {}

    public String getUsername() {
        return username.toLowerCase();
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
}
