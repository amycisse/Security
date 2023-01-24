package sn.isi.securiteweb.dto;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDto {

    protected String username;

    protected String password;

    public LoginDto() {}

    public LoginDto(HttpServletRequest request) {
        this.username = request.getParameter("username");
        this.password = request.getParameter("password");
    }

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
