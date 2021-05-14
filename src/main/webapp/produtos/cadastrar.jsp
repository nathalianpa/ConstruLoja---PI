<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
        <title>Cadastrar produto</title>
    </head>
    <body class="container" style="background-color: #F8F8FF">
        <c:import url="../header.jsp" />
        
        <c:if test="${empty produto}">
            <form action="CadastrarProdutoServlet" method="POST">
                <input type="text" name="idProduto" hidden="true"><br><br>
                <label class="form-label">Nome da Filial</label><br>
                <div>
                    <select name="nomeFilial" id="nomeFilial" class="form-control" required="true">
                        <option value="-">Selecione</option>
                        <option value="SP">SP</option>
                        <option value="RJ">RJ</option>
                        <option value="BH">BH</option>
                    </select>
                </div>
                <br>
                <label class="form-label">Nome</label><br>
                <input type="text" class="form-control" name="nomeProduto" required="true"><br>
                <label class="form-label">Quantidade</label><br>
                <input type="text" class="form-control" name="quantidadeProduto" required="true"><br>
                <label class="form-label">Categoria</label><br>
                <input type="text" class="form-control" name="categoria" required="true"><br>
                <label class="form-label">Valor</label><br>
                <input type="text" class="form-control" name="valor" required="true"><br><br>
                <label class="form-label">Data de Cadastro</label><br>
                <input type="date" name="dataCadastro" required="true"><br><br>
                
                <button type="submit" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty produto}">
            <form action="CadastrarProdutoServlet" method="POST">
                <input type="text" name="idProduto" hidden="true" value="${produto.idProduto}"><br><br>
                <label class="form-label">ID do Cliente</label><br>
                <input type="text" class="form-control" name="idCliente" required="true" value="${cliente}" readonly="true"><br>
                
                <label class="form-label">Nome da Filial</label><br>
                <input type="text" class="form-control" name="nomeFilial" required="true" value="${produto.nomeFilial}" readonly="true">
                <br>
                <label class="form-label">Nome</label><br>
                <input type="text" class="form-control" name="nomeProduto" required="true" value="${produto.nomeProduto}"><br>
                <label class="form-label">Quantidade</label><br>
                <input type="text" class="form-control" name="quantidadeProduto" required="true" value="${produto.quantidadeProduto}"><br>
                <label class="form-label">Categoria</label><br>
                <input type="text" class="form-control" name="categoria" required="true" value="${produto.categoria}"><br>
                <label class="form-label">Valor</label><br>
                <input type="text" class="form-control" name="valor" required="true" value="${produto.valor}"><br>
                <label class="form-label">Data de Cadastro</label><br>
                <input type="date" name="dataCadastro" required="true" value="${produto.dataCadastro}"><br><br>

                <button type="submit" class="btn shadow-lg rounded" style="width:210px; background-color:#F2C70F">Cadastrar</button>
            </form>
        </c:if>

        <c:import url="../footer.jsp" />
    </body>
</html>
