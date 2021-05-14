<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
        <title>Relatórios</title>
    </head>
    <body class="container" style="background-color: #F8F8FF">
        <c:import url="header.jsp" />
    
        <table class="table table-hover">
            <th>Quantidade</th>
            <th>Valor Total</th>
                <tr>
                    <td>${quantidade}</td>
                    <td>${valor}</td>
                </tr>
        </table>
        
        <c:import url="footer.jsp" />
    </body>
</html>
