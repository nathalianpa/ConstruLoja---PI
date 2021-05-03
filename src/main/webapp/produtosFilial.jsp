<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:import url="header.jsp"/>
                </div>
            </div>
                
            <div class="row">
                <div class="col">
                    <h1>Filial: ${param.filial}</h1>
                </div>
            </div>
                
            <div class="row">
                <div class="col">
                    <table class="table table-hover">
                        <th>Id</th>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th>Descrição</th>
                        <th>Valor</th>
                        <th>Data de Cadastro</th>
                        <th>Filial</th>
            
                        <c:forEach items="${listaProdutos}" var="produto">
                            <tr>
                                <td>${produto.idProduto}</td>
                                <td>${produto.codigo}</td>
                                <td>${produto.nomeProduto}</td>
                                <td>${produto.quantidadeProduto}</td>
                                <td>${produto.descricao}</td>
                                <td>${produto.valor}</td>
                                <td>${produto.dataProduto}</td>
                                <td>${produto.filial}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            
            <div class="row">
                <div class="col">
                    <c:import url="footer.jsp"/>
                </div>
            </div>
        </div>
    </body>
</html>
