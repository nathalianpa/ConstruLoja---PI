<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/88ea60f3ab.js" crossorigin="anonymous"></script>
        <title>ERRO</title>
    </head>
    <body class="container">
        <h1 style="color: red">Ops, algo deu errado!</h1>
        
        <a href="<c:url value="/index.jsp"/>"class="btn btn-primary">Voltar</a>
    </body>
</html>
