package controllers;

import dao.ContatoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Contato;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContatoCreateAndFind", value = "/ContatoCreateAndFind")
public class ContatoCreateAndFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pesquisa = request.getParameter("pesquisa");

        if (pesquisa == null) {
            pesquisa = "";
        }

        List<Contato> contatos = ContatoDao.find(pesquisa);

        request.setAttribute("contatos", contatos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contato contato = new Contato();

        contato.setNome(request.getParameter("nome"));
        contato.setTelefone(request.getParameter("telefone"));
        contato.setCelular(request.getParameter("celular"));
        contato.setEmail(request.getParameter("email"));
        contato.setCpf(request.getParameter("cpf"));
        contato.setCep(request.getParameter("cep"));
        contato.setEndereco(request.getParameter("endereco"));
        contato.setNumero(request.getParameter("numero"));
        contato.setCidade(request.getParameter("cidade"));
        contato.setEstado(request.getParameter("estado"));


        ContatoDao.create(contato);

        doGet(request, response);

    }
}
