<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
        <title>Cadastrar cliente</title>
    </head>
    <body class="container" style="background-color: #F8F8FF">
        <c:import url="../header.jsp" />
        
        <c:if test="${empty cliente}">
            <form action="CadastrarClienteServlet" method="POST">
                <label class="form-label">Nome</label><br>
                <input type="text" class="form-control" name="nome" required="true"><br><br>
                <label class="form-label">Email</label><br>
                <input type="text" class="form-control" name="email" required="true"><br><br>
                <label class="form-label">CPF</label><br>
                <input type="text" class="form-control" name="cpf" required="true"><br><br>
                <label class="form-label">CEP</label><br>
                <input type="text" class="form-control" name="cep" required="true"><br><br>
                <label class="form-label">Telefone</label><br>
                <input type="text" class="form-control" name="telefone" required="true"><br><br>
                <label class="form-label">Sexo</label><br>
                <input type="text" class="form-control" name="sexo" required="true"><br><br>
                <label class="form-label">Data de Cadastro</label><br>
                <input type="date" name="data" required="true"/><br><br>
                
                <button type="submit" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty cliente}">
            <form action="AlterarClienteServlet" method="POST">
            <input type="text" class="form-control" name="idCliente" hidden="true" value="${cliente.idCliente}"><br><br>
            <label class="form-label">Nome</label><br>
            <input type="text" class="form-control" name="nome" required="true" value="${cliente.nome}"><br><br>
            <label class="form-label">Email</label><br>
            <input type="text" class="form-control" name="email" required="true" value="${cliente.email}"><br><br>
            <label class="form-label">CPF</label><br>
            <input type="text" class="form-control" name="cpf" required="true" value="${cliente.cpf}"><br><br>
            <label class="form-label">CEP</label><br>
            <input type="text" class="form-control" name="cep" required="true" value="${cliente.cep}"><br><br>
            <label class="form-label">Telefone</label><br>
            <input type="text" class="form-control" name="telefone" required="true" value="${cliente.telefone}"><br><br>
            <label class="form-label">Sexo</label><br>
            <input type="text" class="form-control" name="sexo" required="true" value="${cliente.sexo}"><br><br>
            <label class="form-label">Data de Cadastro</label><br>
            <input type="date" name="data" required="true" value="${cliente.dataCadastro}"/><br><br>
            
            <button type="submit"  class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Alterar</button>
        </form>
        </c:if>
        
        <c:import url="../footer.jsp" />
    </body>
</html>
