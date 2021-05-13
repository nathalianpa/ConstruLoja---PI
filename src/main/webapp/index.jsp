<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Construloja</title>
    </head>
    <body class="container" style="background-color: #F8F8FF">
        <c:import url="header.jsp" />
        
        <div class="row justify-content-center">
            <div class="col-5">
                <img src="Logotipo.png" alt="logotipo">
            </div>         
        </div>
        <div class="row justify-content-center">            
            <div class="col-7 mt-4 mb-4">
                <h1 style="font-family:Verdana">Gerenciamento de atividades</h1>
            </div>   
        </div>
        <div class="row justify-content-center">
            <div class="col-2 mt-3 mb-2 mx-5">
                <a href="ClienteServlet" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Listar Clientes</a>
            </div>
            <div class="col-2 mt-3 mb-2 mx-5 ">
                <a href="clientes/cadastrar.jsp" class="btn shadow-lg rounded" style=" width:210px;background-color:#F2C70F">Cadastrar Cliente</a>
            </div>
        </div>
        
        <div class="row justify-content-center">
            <div class="col-2 mt-3 mb-2 mx-5 ">
                <a href="EstoqueServlet" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Listar Estoque</a>
            </div>
            
            <div class="col-2 mt-3 mb-2 md-3 mx-5">
            <a href="estoque/cadastrar.jsp" class="btn shadow-lg rounded" style="width:210px;background-color:#F2C70F">Cadastrar Produto</a>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-2 mt-3 mb-2 mx-5">
                <a href="venda/cadastrar.jsp" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Tela de Venda</a>
            </div>
            <div class="col-2 mt-3 mb-2 mx-5">
                <a href="relatorio/vendas.jsp" class="btn shadow-lg rounded" style=" width:210px;background-color:#F2C70F">Relatório de Venda</a>
            </div>

        </div>
        

    </body>
</html>
