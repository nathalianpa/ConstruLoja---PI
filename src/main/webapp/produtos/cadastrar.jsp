<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar produto</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp" />
        
        <form action="CadastrarProdutoServlet" method="POST">
            <label class="form-label">Código</label><br>
            <input type="text" class="form-control" name="codigo" required="true"><br><br>
            <label class="form-label">Nome</label><br>
            <input type="text" class="form-control" name="nome" required="true"><br><br>
            <label class="form-label">Quantidade</label><br>
            <input type="text" class="form-control" name="quantidade" required="true"><br><br>
            <label class="form-label">Descrição</label><br>
            <input type="text" class="form-control" name="descricao" required="true"><br><br>
            <label class="form-label">Valor</label><br>
            <input type="text" class="form-control" name="valor" required="true"><br><br>
            
            <button type="submit" class="btn btn-primary">Cadastrar</button>
          </form>
        
        <c:import url="../footer.jsp" />
    </body>
</html>
