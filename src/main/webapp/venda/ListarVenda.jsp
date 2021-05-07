<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="header.jsp" />
    
        <table class="table table-hover">

            <th>Quantidade</th>

            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.quantidadeProduto}</td>
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="footer.jsp" />
    </body>
</html>
