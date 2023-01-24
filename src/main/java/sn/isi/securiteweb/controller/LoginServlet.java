package sn.isi.securiteweb.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.isi.securiteweb.dao.ComptesDao;
import sn.isi.securiteweb.dao.UserDao;
import sn.isi.securiteweb.dao.impl.ComptesDaoImpl;
import sn.isi.securiteweb.dao.impl.UserDaoImpl;
import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private ComptesDao comptesDao;

    private UserDao userDao;

    public LoginServlet (){
        super();
        this.comptesDao = new ComptesDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    String username = request.getParameter("username");
    String password = request.getParameter("password");



    Compte compte = comptesDao.findByUsernameAndPassword(username, password);


    if (compte != null){
        User user = userDao.findByCompte(compte);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect(request.getContextPath() +"/home");

    }
    else{

        String errorMsg = "Une erreur c'est produit lors de l'inscription" + " | " ;

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
    }

    }
}
