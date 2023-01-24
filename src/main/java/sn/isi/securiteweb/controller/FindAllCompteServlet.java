package sn.isi.securiteweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sn.isi.securiteweb.dao.impl.ComptesDaoImpl;

import sn.isi.securiteweb.entities.Compte;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllCompteServlet", value = "/comptes")
public class FindAllCompteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ComptesDaoImpl comptesDaoImpl = new ComptesDaoImpl();
        Compte c = new Compte();
        List<Compte> comptes = comptesDaoImpl.findAll(c);
        request.setAttribute("comptes", comptes);

        request.getRequestDispatcher("/WEB-INF/views/allcomptes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
