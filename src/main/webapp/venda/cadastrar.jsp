<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:import url="../header.jsp" />
                </div>
            </div>
            
            <div class="row mt-5">
                <div class="col">
                    <input type="text" name="cliente" placeholder="Digite o nome do cliente">
                </div>
            </div>
            
            <div class="row mt-5">
                <div class="col">
                    <form action="CarregarProdutosServlet" method="POST">
                        <div>
                            <select name="filial" id="filial">
                                <option value="-">Selecione</option>
                                <option value="SP">SP</option>
                                <option value="RJ">RJ</option>
                                <option value="RS">RS</option>
                            </select>
                        </div>
                        <br>
                        <div>
                            <input type="submit" value="Listar Produtos da Filial">
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
