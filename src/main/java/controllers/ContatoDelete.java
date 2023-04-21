package controllers;

import dao.ContatoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "ContatoDelete", value = "/ContatoDelete")
public class ContatoDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int contatoId = Integer.parseInt(request.getParameter("contatoId"));
        ContatoDao.delete(contatoId);

        ContatoCreateAndFind contatoCreateAndFind = new ContatoCreateAndFind();
        contatoCreateAndFind.doGet(request, response);
    }

}
