<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        
        <div class="container">
        <c:import url="../header.jsp" />
            
        <form action="CadastrarClienteServlet" method="POST">
            <label class="mt-5">Nome</label><br/>
            <input type="text" class="form-control" name="nome" required="true"><br/><br/>
            <label>Email</label><br/>
            <input type="text" class="form-control" name="email" required="true"><br/><br/>
            <label>CPF</label><br/>
            <input type="text" class="form-control" name="cpf" required="true"><br/><br/>
            <label>CEP</label><br/>
            <input type="text" class="form-control" name="cep" required="true"><br/><br/>
            <label>Telefone</label><br/>
            <input type="text" class="form-control" name="telefone" required="true"><br/><br/>
            <label>Sexo</label><br/>
            <input type="text" class="form-control" name="sexo" required="true"><br/><br/>
            
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
            
            <c:import url="../footer.jsp" />
        </div>
        
    </body>
</html>
