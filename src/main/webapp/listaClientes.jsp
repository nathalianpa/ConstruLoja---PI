<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cliente</title>
        
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, cpf){
                $("#nomeCliente").html(nome);
                $("#cpfCliente").val(cpf)
                
                var modalConfirmacao = $("#modalConfirmacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#modalConfirmacao").hide();
            }
            
            function deletarCliente(){
                var cpf = $("#cpfCliente").val();
                fecharTelaConfirmacao();
                $.ajax( "ExcluirClienteServlet?cpf=" + cpf).done(function() {
                    location.reload();
                })
                .fail(function() {
                    console.log( "error" );
                    $("#alerta").css("display", "block");
                    setTimeout(function(){
                        $("#alerta").css("display", "none");
                    }, 3000)
                })
            }
        </script>
        
    </head>
    <body class="container">
        <c:import url="header.jsp" />
        
        <h1>Clientes:</h1>
        
        <div class="alert alert-danger" role="alert" id="alerta" style="display: none">
            Erro ao excluir o cliente!
        </div>
        
        <table class="table table-hover">
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>CEP</th>
            <th>Telefone</th>
            <th>Sexo</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.cep}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.sexo}</td>
                    
                    <td><a href="AlterarClienteServlet?cpf=${cliente.cpf}" class="btn btn-primary">Alterar</a></td>
                    
                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao('${cliente.nome}', '${cliente.cpf}')">Excluir</button></td>
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
                  <p>Cliente: <label id="nomeCliente"></label> <br>Confirmar exclusão do cliente?</p>
                  <input type="hidden" id="cpfCliente" />
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="deletarCliente()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
        
        
        <br>
        <c:import url="footer.jsp" />
    </body>
</html>
