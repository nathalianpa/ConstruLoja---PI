<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produto</title>

    </head>
    <body class="container">
        
        <c:import url="header.jsp" />
        
        <h1>Produtos:</h1>

        <table class="table table-hover">
            <th>Código</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Descrição</th>
            <th>Valor</th>
            
            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.codigo}</td>
                    <td>${produto.nomeProduto}</td>
                    <td>${produto.quantidadeProduto}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.valor}</td>
                    
                    <td><a href="AlterarProdutoServlet?codigo=${produto.codigo}">Alterar</a></td>
                    <td><a href="ExcluirProdutoServlet?codigo=${produto.codigo}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <c:import url="footer.jsp" />
        
    </body>
</html>
