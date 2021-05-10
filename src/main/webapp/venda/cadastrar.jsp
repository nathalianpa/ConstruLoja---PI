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
                    <form action="CarregarDadosServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-hover">
                                            <th>ID do Cliente</th>
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
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-hover">
                                            <th>ID do Produto</th>
                                            <th>Nome da Filial</th>
                                            <th>Nome do Produto</th>
                                            <th>Quantidade</th>
                                            <th>Categoria</th>
                                            <th>Valor</th>
                                            <th>Data de Cadastro</th>

                                            <c:forEach items="${listaProdutos}" var="produto">
                                                <tr>
                                                    <td>${produto.idProduto}</td>
                                                    <td>${produto.nomeFilial}</td>
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
                            </div>
                            
                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Carregar Dados" class="btn btn-primary form-control">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            
            <div class="row mt-4">
                <div class="col">
                    <form action="CadastrarVendaServlet" >
                        <div class="row">
                            <div class="col mt-1">
                                <h4>Digite o ID do Cliente que deseja realizar uma compra:<h1/>
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="idCliente" id="idCliente" required="true"><br>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col mt-1">
                                <h4>Digite o ID do Produto que deseja realizar uma compra:<h1/>
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="idProduto" id="idProduto" required="true"><br>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <input type="submit" name="OPA" value="Realizar compra" class="btn btn-primary form-control">
                            </div> 
                        </div>
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