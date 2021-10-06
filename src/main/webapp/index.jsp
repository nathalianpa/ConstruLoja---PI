<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">


        <title>Construloja</title>
    </head>
    <body class="container" style="background-color: #F8F8FF">
        <c:import url="header.jsp" />

        <div class="row">
            <div class="col text-center">
                <img src="Logotipo.png" alt="logotipo">
            </div>         
        </div>
        <div class="row">
            <div class="col text-center">
                <div class="wrapper fadeInDown">
                    <div id="formContent">

                        <div class="fadeIn first">
                            <h1>Gerenciamento de Login</h1>
                        </div>
                        <form  method="post" action="${pageContext.request.contextPath}/menu.jsp">
                            <div class="form-group">
                                <input type="text" id="login" class="btn shadow-lg rounded" style="width:210px" name="login" placeholder="username">
                            </div>
                            <div class="form-group">
                                <input type="password" id="senha" class="btn shadow-lg rounded" style="width:210px" name="senha" placeholder="password">
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="submit" class="btn shadow-lg rounded" value="Log In">
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>