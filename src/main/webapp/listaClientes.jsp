<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <c:import url="header.jsp" />
        
        <h1>Clientes:</h1>
        
        <table class="table table-hover">
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>CEP</th>
            <th>Telefone</th>
            <th>Sexo</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.cep}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.sexo}</td>
                    
                    <td><a href="AlterarClienteServlet?cpf=${cliente.cpf}" class="btn btn-primary"> Alterar</a></td>
                    <td><a href="ExcluirClienteServlet?cpf=${cliente.cpf}" class="fas fa-trash">    Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <br>
        <c:import url="footer.jsp" />
    </body>
</html>
