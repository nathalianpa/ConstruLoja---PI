<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            #h1{
                font-size: 30px;
            }
        </style>
        
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:import url="../header.jsp" />
                </div>
            </div>
                
            <form action="RelatorioServlet" method="POST">
                <div class="row mt-3">
                    <div class="col">
                        <h1>Selecione uma data início e data fim para realizar a pesquisa</h1>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col">
                        <input type="date" class="form-control" name="dataInicio">
                    </div>
                    <div class="col">
                        <input type="date" class="form-control" name="dataFim">
                    </div>
                </div>
                
                <div class="row mt-3">
                    <div class="col-9">
                        <h1 id="h1">Listar a quantidade de produto vendido por filial:</h1>
                    </div>
                    <div class="col">
                       <button type="submit" class="btn btn-primary">Listar</button>
                    </div>
                </div>
            </form>
            
            <form action="RelatorioCategoriaServlet" method="POST">
                <div class="row mt-5">
                    <div class="col-12">
                        <h1 id="h1">Escreva uma categoria para listar a quantidade de produto vendida</h1>
                    </div> 
                    <div class="col">
                        <input type="text" class="form-control" name="categoria">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-9">
                        <h1 id="h1">Listar a quantidade de produto vendido pela categoria:</h1>
                    </div>
                    <div class="col">
                       <button type="submit" class="btn btn-primary">Listar</button>
                    </div>
                </div>
            </form>
                
            <form action="RelatorioClienteServlet" method="POST">
                <div class="row mt-5">
                    <div class="col-12">
                        <h1 id="h1">Escreva o id do cliente para listar a quantidade de produto comprado</h1>
                    </div> 
                    <div class="col">
                        <input type="text" class="form-control" name="idCliente">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-9">
                        <h1 id="h1">Listar a quantidade de produto vendido pela categoria:</h1>
                    </div>
                    <div class="col">
                       <button type="submit" class="btn btn-primary">Listar</button>
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
