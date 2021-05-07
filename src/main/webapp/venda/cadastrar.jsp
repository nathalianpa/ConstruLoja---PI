<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:import url="../header.jsp" />
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col">
                    <form action="CarregarClientesServlet" method="POST">
                        <div class="row">
                            <div class="col-5">
                                <input type="text" class="form-control" name="idCliente" id="idCliente" placeholder="Digite o id do cliente" required="true">
                            </div>
                            <div class="col-5">
                                <input type="text" class="form-control" name="idFilial" id="idFilial" placeholder="Digite o id da filial" required="true">
                            </div>
                            <div class="col-2">
                                <input type="submit" value="Carregar Dados" class="btn btn-primary form-control">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col">
                    <table class="table table-hover">
                        <th>Id do Cliente</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>CPF</th>
                        <th>CEP</th>
                        <th>Telefone</th>
                        <th>Sexo</th>
                        <th>Data de Cadastro</th>

                        <c:forEach items="${cliente}" var="cliente">
                            <tr>
                                <td>${cliente.idCliente}</td>
                                <td>${cliente.nome}</td>
                                <td>${cliente.email}</td>
                                <td>${cliente.cpf}</td>
                                <td>${cliente.cep}</td>
                                <td>${cliente.telefone}</td>
                                <td>${cliente.sexo}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataCadastro}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
                
            <div class="row mt-3">
                <div class="col">
                    <table class="table table-hover">
                        <th>Id do Produto</th>
                        <th>Id da Filial</th>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th>Categoria</th>
                        <th>Valor</th>
                        <th>Data de Cadastro</th>
            
                        <c:forEach items="${listaProdutos}" var="produto">
                            <tr>
                                <td>${produto.idProduto}</td>
                                <td>${produto.idFilial}</td>
                                <td>${produto.nomeProduto}</td>
                                <td>${produto.quantidadeProduto}</td>
                                <td>${produto.categoria}</td>
                                <td>${produto.valor}</td>
                                <td>${produto.dataCadastro}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col">
                    <form action="CadastrarProdutoServlet" method="POST">
                        <div class="row">
                            <div class="col-6">
                                <label class="form-label">Nome do Cliente</label><br>
                                <input type="text" class="form-control" name="cliente" required="true"><br>
                            </div>
                            <div class="col-6">
                                <label class="form-label">Nome do Produto</label><br>
                                <input type="text" class="form-control" name="nomeProduto" required="true"><br>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-4">
                                 <label class="form-label">Quantidade</label><br>
                                <input type="text" class="form-control" name="quantidade" required="true"><br>
                            </div>
                            <div class="col-4">
                                <label class="form-label">Valor Total</label><br>
                                <input type="text" class="form-control" name="valorTotal" required="true"><br>
                            </div>
                            <div class="col-4">
                                <label class="form-label">Filial</label><br>
                                <select name="filial" class="form-control" id="filial" required="true">
                                    <option value="-">Selecione</option>
                                    <option value="SP">SP</option>
                                    <option value="RJ">RJ</option>
                                    <option value="RS">RS</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                
            <h1>Cliente: ${param.id}</h1>

            <div class="row mt-5">
                <div class="col">
                    <c:import url="../footer.jsp" />
                </div>
            </div>
        </div>
    </body>
</html>