package controllers;

import dao.ContatoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Contato;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@MultipartConfig
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

        Part file = request.getPart("image");
        String imageFileName = file.getSubmittedFileName();
        System.out.println("arquivo " + imageFileName);

        String uploadPath="F:/Java/contato/src/main/webapp/imagens/"+imageFileName;
        System.out.println("pasta imagens "+ uploadPath);

        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        contato.setimageFileName(imageFileName);


        ContatoDao.create(contato);

        doGet(request, response);

    }
}
