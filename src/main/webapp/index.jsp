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
        
        <h1>Menu</h1>
        
        <a href="ClienteServlet">Listar Clientes</a>
        <br>
        <br>
        <a href="clientes/cadastrar.jsp">Cadastrar Cliente</a>
    </body>
</html>
