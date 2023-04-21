<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 11/04/2023
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Contatos | Home</title>

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!-- Icones -->
    <script src="https://kit.fontawesome.com/611666c32e.js" crossorigin="anonymous"></script>
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.html">Início</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="novoContato.html">
            <button id="botao-adicionar-contato" type="button" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#cadastroCliente">
                Adicionar Contato
            </button>
        </a>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <form action="ContatoCreateAndFind" method="get" class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Pesquisar contato" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>
<div class="container mx-auto p-2">
    <h1 class="text-center">Lista de contatos</h1>
</div>

<!-- Lista de contatos -->
<div class="container container-formulario">
    <table class="table align-middle mb-0 bg-white">
        <thead class="bg-light">
        <tr>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contatos}" var="contato">
            <tr>
                <td>
                    <div class="d-flex align-items-center">
                        <img
                                src="./imagens/${contato.imageFileName}"
                                alt=""
                                style="width: 45px; height: 45px"
                                class="rounded-circle"
                        />
                        <div class="ms-3">
                            <p class="fw-bold mb-1">${contato.nome}</p>
                            <p class="text-muted mb-0">${contato.email}</p>
                        </div>
                    </div>
                </td>
                <td>
                    <p class="fw-normal mb-1">${contato.endereco}</p>
                    <p class="text-muted mb-0">${contato.cidade}</p>
                </td>
                <td>
                    <p class="fw-normal mb-1">${contato.telefone}</p>
                    <p class="text-muted mb-0">${contato.celular}</p>
                </td>
                <td>
                    <a href="ContatoUpdate?contatoId=${contato.id}">
                        <button type="button" class="btn btn-outline-warning">
                            Editar
                        </button>
                    </a>
                    <a href="ContatoDelete?contatoId=${contato.id}">
                        <button type="button" class="btn btn-outline-danger">
                            Apagar
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<!-- Scripts    -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>
