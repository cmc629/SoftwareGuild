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
                <div class="col-md-4"></div>
                <div class="col-md-4 custom">
                    <h2>Editing DVD</h2>
                    <br>
                </div>
            </div>

            <form:form id="loginForm" class="form-horizontal" commandName="dvd" action="${pageContext.request.contextPath}/collection/view/edit" method="POST" role="form">

                <div class="form-group">
                    <label for="edit-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-6">
                        <form:input path="title" class="form-control" id="edit-title" placeholder="Title"/>
                        <form:errors path="title" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-date" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-3 input-group date">
                        <form:input path="releaseDate" class="form-control" id="edit-date" placeholder="Release Date" />
                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span>
                            <form:errors path="releaseDate" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-rating" class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-2">
                        <form:select path="mpaaRating" class="form-control">
                            <option value="G" <c:if test="${dvd.mpaaRating eq 'G'}">selected</c:if>>G</option>
                            <option value="PG" <c:if test="${dvd.mpaaRating eq 'PG'}">selected</c:if>>PG</option>
                            <option value="PG-13" <c:if test="${dvd.mpaaRating eq 'PG-13'}">selected</c:if>>PG-13</option>
                            <option value="R" <c:if test="${dvd.mpaaRating eq 'R'}">selected</c:if>>R</option>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-director" class="col-md-4 control-label">Director:</label>
                    <div class="col-md-6">
                        <form:input path="director" class="form-control" id="edit-director" placeholder="Director"/>
                        <form:errors path="director" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-studio" class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-6">
                        <form:input path="studio" class="form-control" id="edit-studio" placeholder="Studio"/>
                        <form:errors path="studio" />
                    </div>
                </div>

                <form:hidden path="id" />

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" class="btn btn-default">
                            Edit DVD
                        </button>
                        <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/collection/view/${dvd.id}">Back</a>
                    </div>
                    
                </div>

            </form:form>
            
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

