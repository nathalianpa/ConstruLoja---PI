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
                    <form action="CarregarClientesServlet" method="POST">
                        <div class="row">
                            <div class="col-6">
                                <label class="form-label">Id do Cliente</label><br>
                                <input type="text" class="form-control" name="idCliente" required="true"><br>
                            </div>
                            <div class="col-6">
                                <label class="form-label">Nome do Produto</label><br>
                                <input type="text" class="form-control" name="nomeProduto" required="true"><br>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-4">
                                 <label class="form-label">Quantidade</label><br>
                                <input type="text" class="form-control" name="quantidadeProduto" required="true"><br>
                            </div>
                            <div class="col-4">
                                <label class="form-label">Valor Total</label><br>
                                <input type="text" class="form-control" name="valor" required="true"><br>
                            </div>
                            <div class="col-4">
                                <label class="form-label">Filial</label><br>
                                <select name="nomeFilial" class="form-control" id="filial" required="true">
                                    <option value="-">Selecione</option>
                                    <option value="SP">SP</option>
                                    <option value="RJ">RJ</option>
                                    <option value="RS">RS</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-6">
                                <label class="form-label">Categoria</label><br>
                                <input type="text" class="form-control" name="categoria" required="true"><br>
                            </div>
                            <div class="col-6">
                                <label class="form-label">Data de Cadastro</label><br>
                                <input type="date" class="form-control" name="dataCadastro" required="true"><br>
                            </div>
                        </div>
                        
                        <input type="submit" name="OPA" value="REALIZAR VENDA" class="btn btn-primary">
                    </form>
                </div>
            </div>
                
            <div class="row mt-5">
                <div class="col">
                    <c:import url="../footer.jsp" />
                </div>
            </div>
        </div>
    </body>
</html>