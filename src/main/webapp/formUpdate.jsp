<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 16/04/2023
  Time: 16:42
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
        <form action="ClienteCreateAndfind" method="GET">
            <a href="ContatoCreateAndFind">
                <button id="botao-adicionar-contato" type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#cadastroCliente">
                    Lista de contatos
                </button>
            </a>
        </form>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <form action="ContatoCreateAndFind" method="get" class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Pesquisar contato" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>

<h1 class="titulo">Alterar Contato</h1>
<!-- Formulario cadastro -->

<div class="container container-formulario">
    <form action="ContatoUpdate" method="POST" class="row g-3">
        <input name="id" value="${contato.id}" type="hidden">
        <div class="col-md-6">
            <label class="form-label">Nome Completo</label>
            <input value="${contato.nome}" name="nome" maxlength="40" type="text" class="form-control" id="inputNome"
                   placeholder="Escreva seu nome completo" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">CPF</label>
            <input value="${contato.cpf}" name="cpf" maxlength="11" type="phone" class="form-control" id="inputCpf" placeholder="Digite seu CPF"oninput="mascara(this)">
        </div>
        <div class="col-md-6">
            <label class="form-label">Telefone</label>
            <input value="${contato.telefone}" name="telefone" maxlength="10" type="tel" class="form-control" id="inputTelefone" placeholder="(11) 3441-6728" onkeydown="return mascaraTelefone(event)">
        </div>
        <div class="col-md-6">
            <label class="form-label">Celular</label>
            <input value="${contato.celular}" name="celular" maxlength="11" type="tel" class="form-control" id="inputCelular" placeholder="(11) 9 9999-1111" onkeydown="return mascaraTelefone(event)">
        </div>
        <div class="col-md-6">
            <label class="form-label">Email</label>
            <input value="${contato.email}" name="email" maxlength="100" type="phone" class="form-control" id="inputEmail" placeholder="email@email.com">
        </div>
        <div class="col-md-4">
            <label class="form-label">CEP</label>
            <input value="${contato.cep}" name="cep" maxlength="9" type="text" class="form-control" id="Cep" value="" size="10" onblur="pesquisacep(this.value);" placeholder="897015-375">
        </div>
        <div class="col-8">
            <label class="form-label">Endereço</label>
            <input value="${contato.endereco}" name="endereco" maxlength="100" type="text" class="form-control" id="inputEndereco" placeholder="Digite a rua">
        </div>
        <div class="col-4">
            <label class="form-label">Numero</label>
            <input value="${contato.numero}" name="numero" maxlength="10" type="text" class="form-control" id="inputNumero" placeholder="Digite o número"
            >
        </div>
        <div class="col-md-6">
            <label for="inputCity" class="form-label">Cidade</label>
            <input value="${contato.cidade}" name="cidade" maxlength="100" type="text" class="form-control" id="inputCity" placeholder="São Paulo">
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Estado</label>
            <select value="${contato.estado}" name="estado" maxlength="50" id="inputState" class="form-select">
                <option value="">Selecione</option>
                <option value="AC">AC</option>
                <option value="AL">AL</option>
                <option value="AP">AP</option>
                <option value="AM">AM</option>
                <option value="BA">BA</option>
                <option value="CE">CE</option>
                <option value="DF">DF</option>
                <option value="ES">ES</option>
                <option value="GO">GO</option>
                <option value="MA">MA</option>
                <option value="MS">MS</option>
                <option value="MT">MT</option>
                <option value="MG">MG</option>
                <option value="PA">PA</option>
                <option value="PB">PB</option>
                <option value="PR">PR</option>
                <option value="PE">PE</option>
                <option value="PI">PI</option>
                <option value="RJ">RJ</option>
                <option value="RN">RN</option>
                <option value="RS">RS</option>
                <option value="RO">RO</option>
                <option value="RR">RR</option>
                <option value="SC">SC</option>
                <option value="SP">SP</option>
                <option value="SE">SE</option>
                <option value="TO">TO</option>
            </select>
        </div>
        <div class="modal-footer">
            <button class="btn btn-secondary" type="reset">Limpar
                Formulário
            </button>
            <button type="submit" class="btn btn-primary">Alterar Contato</button>
        </div>
    </form>
</div>


<!-- Scripts    -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>

</html>

