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
                <div class="col-md-5"></div>
                <div class="col-md-2 custom">
                    <h2>Search</h2>
                    <br>
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/search/lastName" method="POST" role="form">
                        <div class="form-group">
                            <label class="col-md-3 custom-label" for="lastNameSearch">Last Name:</label>
                            <div class="col-md-6 has-feedback">
                                <input name="lastName" type="text" class="form-control search-query" id="lastNameSearch" placeholder="Last Name">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                            <button type="submit" class="col-md-2 btn btn-default">Search</button>
                        </div>
                    </form>
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/search/city" method="POST" role="form">
                        <div class="form-group">
                            <label class="col-md-3 custom-label" for="citySearch">City:</label>
                            <div class="col-md-6 has-feedback">
                                <input name="city" type="text" class="form-control search-query" id="citySearch" placeholder="City">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                            <button type="submit" class="col-md-2 btn btn-default">Search</button>
                        </div>
                    </form>
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/search/state" method="POST" role="form">
                        <div class="form-group">
                            <label class="col-md-3 custom-label">State:</label>
                            <div class="col-md-3">
                                <jsp:include page="stateDropdownSearch.jsp"/>
                            </div>
                            <div class="col-md-3"></div>
                            <button type="submit" class="col-md-2 btn btn-default">Search</button>
                        </div>
                    </form>
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/search/zip" method="POST" role="form">
                        <div class="form-group">
                            <label class="col-md-3 custom-label" for="zipSearch">Zip Code:</label>
                            <div class="col-md-6 has-feedback">
                                <input name="zip" type="text" class="form-control" id="zipSearch" placeholder="Zip Code">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                            <button type="submit" class="col-md-2 btn btn-default">Search</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

