<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Addresses</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>

            <jsp:include page="navbar.jsp" />

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${address.lastName}, ${address.firstName}</h3>
                </div>
                <div class="panel-body">
                    <p>Address: ${address.streetNumber} ${address.streetName}</p>
                    <p>City: ${address.city}</p>
                    <p>State: ${address.state}</p>
                    <p>Zip Code: ${address.zip}</p>
                </div>
            </div>

            <hr class="featurette-divider">
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/addresses">Back</a>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom.js"></script>

    </body>
</html>

