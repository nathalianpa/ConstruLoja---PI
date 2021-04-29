<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar cliente</title>
    </head>
    <body class="container">
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
            
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty cliente}">
            <form action="AlterarClienteServlet" method="POST">
            <label class="form-label">Nome</label><br>
            <input type="text" class="form-control" name="nome" required="true" value="${cliente.nome}"><br><br>
            <label class="form-label">Email</label><br>
            <input type="text" class="form-control" name="email" required="true" value="${cliente.email}"><br><br>
            <label class="form-label">CPF</label><br>
            <input type="text" class="form-control" name="cpf" required="true" value="${cliente.cpf}" readonly="true"><br><br>
            <label class="form-label">CEP</label><br>
            <input type="text" class="form-control" name="cep" required="true" value="${cliente.cep}"><br><br>
            <label class="form-label">Telefone</label><br>
            <input type="text" class="form-control" name="telefone" required="true" value="${cliente.telefone}"><br><br>
            <label class="form-label">Sexo</label><br>
            <input type="text" class="form-control" name="sexo" required="true" value="${cliente.sexo}"><br><br>
            
            <button type="submit"  class="btn btn-primary">Alterar</button>
        </form>
        </c:if>
        
        <c:import url="../footer.jsp" />
    </body>
</html>
