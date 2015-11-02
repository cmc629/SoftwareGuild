<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>

            <jsp:include page='navbar.jsp' />

            <div class="row">
                <div class="col-md-12 custom">
                    <h2>Search for DVDs by MPAA Rating</h2>
                    <br>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/search/rating/results" method="POST" role="form">
                        <div class="form-group">
                            <div class="col-md-5"></div>
                            <div class="col-md-1">
                                <select name="rating" class="form-control">
                                    <option value="G" selected>G</option>
                                    <option value="PG">PG</option>
                                    <option value="PG-13">PG-13</option>
                                    <option value="R">R</option>
                                </select>
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-default">Search</button>
                            </div>

                        </div>
                    </form>

                </div>
            </div>

            <jsp:include page="footer.jsp" />
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>
        <script scr="${pageContext.request.contextPath}/js/custom.js"></script>

    </body>
</html>

