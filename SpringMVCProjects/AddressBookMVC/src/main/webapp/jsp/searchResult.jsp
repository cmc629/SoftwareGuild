<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Controller Page</title>
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

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 custom">
                    <h2>Search Results</h2>
                    <br>
                </div>
            </div>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Street Address</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip Code</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${addresses}" var="address">
                        <tr>
                            <td>${address.firstName} ${address.lastName}</td>
                            <td>${address.streetNumber} ${address.streetName}</td>
                            <td>${address.city}</td>
                            <td>${address.state}</td>
                            <td>${address.zip}</td>
                            <td>

                                <a role="button" class="btn btn-success"
                                   href="${pageContext.request.contextPath}/search/view/${address.id}">View</a>

                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            
            <hr class="featurette-divider">
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/search">New Search</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

