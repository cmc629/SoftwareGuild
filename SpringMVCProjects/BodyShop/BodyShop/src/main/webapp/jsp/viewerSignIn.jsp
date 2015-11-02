<%-- 
    Document   : ViewerSignIn
    Created on : Nov 2, 2015, 10:41:16 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <title>ViewerSignIn</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/transss.png">

        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <link href='https://fonts.googleapis.com/css?family=Orbitron:900' rel='stylesheet' type='text/css'>

        <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>
    </head>

    <body id="backgirl">

        <div class="nav">
            <jsp:include page="navbar.jsp"/>
        </div>



        <div class="col-md-6"></div>



        <div class="col-md-6" id="down5">
            <form id="back3">
                <div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="email">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div>
                        <button type="submit" class="btn btn-danger">Sign In</button>
                    </div>

                </div>
                <div>
                    <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/transss_zpscevwhl1i.png" id="trans1" alt="transformer">
                </div>
            </form>
        </div>




        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>

</html>
