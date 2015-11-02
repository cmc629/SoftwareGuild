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
            
            <jsp:include page='addModal.jsp' />
            
            <h1>DVD Library</h1>
            <hr/>

            <jsp:include page='navbar.jsp' />

            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-2 custom">
                    <h2>Collection</h2>
                    <br>
                </div>
            </div>

            <a role="button" id="open-add-modal" class="btn btn-default" data-toggle="modal" data-target="#addModal" >Add DVD</a>
            
            <h3>Current DVDs:</h3>
            
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                <c:forEach items="${dvds}" var="dvd">
                    <div id="dvd-panel-${dvd.id}" class="panel panel-default">
                        <div class="custom panel-heading" role="button" id="heading${dvd.id}" data-toggle="collapse" data-parent="#accordion" href="#collapse${dvd.id}" aria-expanded="true" aria-controls="collapse${dvd.id}">
                            <h4 class="panel-title">
                                ${dvd.title}
                            </h4>
                        </div>
                        <div id="collapse${dvd.id}" class="panel-collapse collapse "role="tabpanel" aria-labelledby="heading${dvd.id}">
                            <div class="panel-body">
                                Title: ${dvd.title} <br>
                                <fmt:formatDate value="${dvd.releaseDate}" type="date" pattern="MMMM dd, yyyy" var="formattedDate" />
                                Release Date: ${formattedDate} <br>
                                MPAA Rating: ${dvd.mpaaRating} <br>
                                Director: ${dvd.director} <br>
                                Studio: ${dvd.studio} <br>
                                <a role="button" class="btn btn-xs btn-success" href="collection/view/${dvd.id}">View</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            
            <jsp:include page="footer.jsp" />

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>
        <script scr="${pageContext.request.contextPath}/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

    </body>
</html>

