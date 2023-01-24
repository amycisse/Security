package sn.isi.securiteweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sn.isi.securiteweb.dao.UserDao;
import sn.isi.securiteweb.dao.impl.UserDaoImpl;
import sn.isi.securiteweb.dto.UserDto;
import sn.isi.securiteweb.entities.Compte;
import sn.isi.securiteweb.entities.User;
import sn.isi.securiteweb.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private  UserService userService;
    private UserDao userDao;

    public void init() {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoImpl userDaoImpl = new UserDaoImpl();


        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");


        if (lastname.equals("") || firstname.equals("") || phonenumber.equals("") || email.equals("")){
            request.setAttribute("error", "veuillez renseigner tous les champs");
            String View_PATH = null;
            this.getServletContext().getRequestDispatcher(View_PATH + "register.jsp");
        }else{

            UserDaoImpl userDaoImp = new UserDaoImpl();

            User user = new User();
            user.setLastname(lastname);
            user.setFirstname(firstname);
            user.setPhoneNumber(phonenumber);
            user.setEmail(email);

            int result = userDaoImp.add(user);
            if (result == 1){
                request.setAttribute("success", "crée");
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register-success.jsp");
                dispatcher.forward(request, response);
            }else {
                request.setAttribute("error", "une erreur");
            }

        }
        response.sendRedirect("/register-success.jsp");

    }



    }




