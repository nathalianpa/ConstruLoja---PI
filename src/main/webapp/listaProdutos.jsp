<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produto</title>

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
                $.ajax( "ExcluirProdutoServlet?idProduto=" + id).done(function() {
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
    <body class="container">
        
        <c:import url="header.jsp" />
        
        <h1>Produtos:</h1>

        <div class="alert alert-danger" role="alert" id="alerta" style="display: none">
            Erro ao excluir o produto!
        </div>
        
        <table class="table table-hover">
            <th>ID</th>
            <th>ID da Filial</th>
            <th>Nome da Filial</th>
            <th>Nome do Produto</th>
            <th>Quantidade</th>
            <th>Categoria</th>
            <th>Valor</th>
            <th>Data de Cadastro</th>
            
            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.idProduto}</td>
                    <td>${produto.idFilial}</td>
                    <td>${produto.nomeFilial}</td>
                    <td>${produto.nomeProduto}</td>
                    <td>${produto.quantidadeProduto}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.valor}</td>
                    <td>${produto.dataCadastro}</td>
                    
                    <td><a href="AlterarProdutoServlet?idProduto=${produto.idProduto}" class="btn btn-primary">Alterar</a></td>
                    
                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao('${produto.nomeProduto}', '${produto.idProduto}')">Excluir</button></td>
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
