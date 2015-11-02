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
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
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
                        <th>Movie Title</th>
                        <th>Release Date</th>
                        <th>MPAA Rating</th>
                        <th>Director</th>
                        <th>Studio</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${results}" var="dvd">
                        <tr>
                            <td>${dvd.title}</td>
                            <fmt:formatDate value="${dvd.releaseDate}" type="date" pattern="MMMM dd, yyyy" var="formattedDate" />
                            <td>${formattedDate}</td>
                            <td>${dvd.mpaaRating}</td>
                            <td>${dvd.director}</td>
                            <td>${dvd.studio}</td>
                            <td>

                                <a role="button" class="btn btn-xs btn-success"
                                   href="${pageContext.request.contextPath}/collection/view/${dvd.id}">View</a>

                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            
            <hr class="featurette-divider">
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/search/${path}">New Search</a>
            
            <jsp:include page="footer.jsp" />
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

