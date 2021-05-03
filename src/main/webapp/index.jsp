<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Construloja</title>
    </head>
    <body class="container">
        <c:import url="header.jsp" />
        
        <h1 id="titulo">Menu</h1>
        
        <a href="ClienteServlet" class="btn btn-primary">Listar Clientes</a>
        <br>
        <br>
        <a href="clientes/cadastrar.jsp" class="btn btn-primary">Cadastrar Cliente</a>
        <br>
        <br>
        <a href="ProdutoServlet" class="btn btn-primary">Listar Produtos</a>
        <br>
        <br>
        <a href="produtos/cadastrar.jsp" class="btn btn-primary">Cadastrar Produto</a>
        <br>
        <br>
        <a href="venda/cadastrar.jsp" class="btn btn-primary">Tela de Venda</a>
    </body>
</html>
