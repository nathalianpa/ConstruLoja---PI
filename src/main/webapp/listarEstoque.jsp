<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Estoque</title>
        
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id){
                $("#nomeProduto").html(nome);
                $("#idProduto").val(id);
                
                var modalConfirmacao = $("#modalConfirmacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#modalConfirmacao").hide();
            }
            
            function deletarProduto(){
                var id = $("#idProduto").val();
                fecharTelaConfirmacao();
                $.ajax( "ExcluirEstoqueServlet?idProduto=" + id).done(function() {
                    location.reload();
                })
                .fail(function() {
                    console.log( "error" );
                    $("#alerta").css("display", "block");
                    setTimeout(function(){
                        $("#alerta").css("display", "none");
                    }, 2000)
                })
            }
        </script>
        
    </head>
    <body class="container" style="background-color: #F8F8FF">
        
        <c:import url="header.jsp" />
        
        <h1>Produtos:</h1>

        <div class="alert alert-danger" role="alert" id="alerta" style="display: none">
            Erro ao excluir o produto!
        </div>
        
        <table class="table table-hover">
            <th>ID</th>
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
                    
                    <td><a href="AlterarEstoqueServlet?idProduto=${produto.idProduto}" class="btn shadow-lg rounded" style="width:110px; background-color:#F2C70F">Alterar</a></td>
                    
                    <td><button type="button" class="btn shadow-lg rounded" style="width:110px; background-color:#F2C70F" onclick="mostrarTelaConfirmacao('${produto.nomeProduto}', '${produto.idProduto}')">Excluir</button></td>
                </tr>
            </c:forEach>
        </table>

         <!-- Modal -->
        <div class="modal" id="modalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <p>Produto: <label id="nomeProduto"></label> <br>Confirmar exclusão do produto?</p>
                  <input type="hidden" id="idProduto" />
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="deletarProduto()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
        
        <br>
        <c:import url="footer.jsp" />
        
    </body>
</html>
