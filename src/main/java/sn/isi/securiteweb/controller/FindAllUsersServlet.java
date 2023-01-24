package sn.isi.securiteweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sn.isi.securiteweb.dao.impl.UserDaoImpl;
import sn.isi.securiteweb.entities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindAllUsersServlet", value = "/users")
public class FindAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User u = new User();
        List<User> users = userDaoImpl.findAll(u);
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/views/allusers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
    }
}
