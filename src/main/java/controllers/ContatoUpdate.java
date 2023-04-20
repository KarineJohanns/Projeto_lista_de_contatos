package controllers;

import dao.ContatoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Contato;

import java.io.IOException;

@WebServlet(name = "ContatoUpdate", value = "/ContatoUpdate")
public class ContatoUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int contatoId = Integer.parseInt(request.getParameter("contatoId"));

        Contato contato = ContatoDao.findByPk((contatoId));
        request.setAttribute("contato", contato);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato();

        contato.setId(Integer.parseInt(request.getParameter("id")));

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

        ContatoDao.update((contato));

        ContatoCreateAndFind contatoCreateAndFind = new ContatoCreateAndFind();
        contatoCreateAndFind.doGet(request, response);
    }
}
