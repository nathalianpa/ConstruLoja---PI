<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #F8F8FF">
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:import url="../header.jsp" />
                </div>
            </div>
                
            <form action="RelatorioServlet" method="POST">
                <div class="row mt-3">
                    <div class="col">
                        <h1 style="font-size: 28px; font-family: Verdana">Selecione uma Data Inicial</h1>
                    </div>
                    <div class="col">
                        <h1 style="font-size: 28px; font-family: Verdana">Selecione uma Data Final</h1>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col">
                        <input type="date" class="form-control" name="dataInicio" required="true">
                    </div>
                    <div class="col">
                        <input type="date" class="form-control" name="dataFim" required="true">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col">
                        <input type="text" class="form-control" name="nomeFilial" required="true" placeholder="Digite o nome da Filial">
                    </div>
                    <div class="col">
                        <button type="submit" class="btn shadow-lg rounded" style="width:420px; background-color:#F2C70F">Listar a quantidade de produto vendida por Filial</button>
                    </div>
                </div>
            </form>
            
            <form action="RelatorioCategoriaServlet" class="mt-5" method="POST">
                <div class="row mt-5">
                    <div class="col">
                        <h1 style="font-size: 28px; font-family: Verdana">Escreva uma categoria para listar</h1>
                    </div> 
                </div>

                <div class="row mt-3">
                    <div class="col">
                        <input type="text" class="form-control" name="categoria" placeholder="Digite uma categoria" required="true">
                    </div>
                    <div class="col">
                       <button type="submit" class="btn shadow-lg rounded" style="width:420px; background-color:#F2C70F">Listar a quantidade de produto vendido pela categoria</button>
                    </div>
                </div>
            </form>
            
                
            <form action="RelatorioClienteServlet" method="POST">
                <div class="row mt-5">
                    <div class="col-12">
                        <h1 style="font-size: 28px; font-family: Verdana">Escreva o ID do cliente para listar</h1>
                    </div> 
                </div>

                <div class="row mt-3">
                    <div class="col">
                        <input type="text" class="form-control" name="idCliente" required="true" placeholder="Digite o ID do cliente">
                    </div>
                    <div class="col">
                       <button type="submit" class="btn shadow-lg rounded" style="width:420px; background-color:#F2C70F">Listar a quantidade de produto comprado pelo cliente</button>
                    </div>
                </div>
            </form>
                
            <div class="row">
                <div class="col">
                    <c:import url="../footer.jsp" />
                </div>
            </div>
        </div>
        
    </body>
</html>
