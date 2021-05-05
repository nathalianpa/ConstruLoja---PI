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
        
        <c:if test="${empty produto}">
            <form action="CadastrarProdutoServlet" method="POST">
                <label class="form-label">Código</label><br>
                <input type="text" class="form-control" name="codigo" required="true"><br>
                <label class="form-label">Nome</label><br>
                <input type="text" class="form-control" name="nome" required="true"><br>
                <label class="form-label">Quantidade</label><br>
                <input type="text" class="form-control" name="quantidade" required="true"><br>
                <label class="form-label">Categoria</label><br>
                <input type="text" class="form-control" name="categoria" required="true"><br>
                <label class="form-label">Valor</label><br>
                <input type="text" class="form-control" name="valor" required="true"><br>
                <label class="form-label">Data de Cadastro</label><br>
                <input type="date" name="data" required="true"><br><br>
                <label class="form-label">Filial</label><br>
                <div>
                    <select name="filial" id="filial">
                        <option value="-">Selecione</option>
                        <option value="SP">SP</option>
                        <option value="RJ">RJ</option>
                        <option value="RS">RS</option>
                    </select>
                </div>
                <br>
                
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty produto}">
            <form action="AlterarProdutoServlet" method="POST">
                <input type="text" name="idProduto" hidden="true" value="${produto.idProduto}"><br><br>
                <label class="form-label">Código</label><br>
                <input type="text" class="form-control" name="codigo" required="true" value="${produto.codigo}"><br><br>
                <label class="form-label">Nome</label><br>
                <input type="text" class="form-control" name="nome" required="true" value="${produto.nomeProduto}"><br><br>
                <label class="form-label">Quantidade</label><br>
                <input type="text" class="form-control" name="quantidade" required="true" value="${produto.quantidadeProduto}"><br><br>
                <label class="form-label">Categoria</label><br>
                <input type="text" class="form-control" name="categoria" required="true" value="${produto.categoria}"><br><br>
                <label class="form-label">Valor</label><br>
                <input type="text" class="form-control" name="valor" required="true" value="${produto.valor}"><br><br>
                <label class="form-label">Data de Cadastro</label><br>
                <input type="date" name="dataCadastro" required="true" value="${produto.dataCadastro}"><br><br>
                <label class="form-label">Filial</label><br>
                <div>
                    <select name="filial" id="filial" value="${produto.filial}>
                        <option value="-">Selecione</option>
                        <option value="SP">SP</option>
                        <option value="RJ">RJ</option>
                        <option value="PR">PR</option>
                        <option value="RS">RS</option>
                    </select>
                </div>
                <br>
                
                <button type="submit" class="btn btn-primary">Alterar</button>
            </form>
        </c:if>

        <c:import url="../footer.jsp" />
    </body>
</html>
