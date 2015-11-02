<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Pages</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <link href='https://fonts.googleapis.com/css?family=Orbitron:900' rel='stylesheet' type='text/css'>

        <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <link href="${pageContext.request.contextPath}/css/HeaderStyle.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <!--Add User Modal-->
        <jsp:include page="addUserModal.jsp"/>
        
        <!--Delete User Modal-->
        <jsp:include page="deleteUserModal.jsp"/>

        <div class="nav">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="pull-left">
                        <h1 id="br">THE TONER HOUSE</h1>
                    </div>
                </div>
            </nav>
        </div>

        <div class="container">

            <button id="add-user-modal" type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
                Create User
            </button>
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/admin/">
                Back
            </a>

            <table id="userTable" class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Street Address</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip Code</th>
                        <th>Email</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${users}" var="user">
                        <tr id="user-row-${user.userId}">
                            <td>${user.firstName} ${user.lastName}</td>
                            <td>${user.streetNumber} ${user.streetName}</td>
                            <td>${user.city}</td>
                            <td>${user.state}</td>
                            <td>${user.zip}</td>
                            <td>${user.email}</td>
                            <td>
                                
                                <div class="row">
                                    <div class="col-md-3">
                                        <a href="#" data-toggle="modal" 
                                           data-target="#editUserModal"
                                           data-user-id="${user.userId}">Edit</a>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" data-toggle="modal" 
                                           data-target="#deleteUserModal"
                                           data-user-id="${user.userId}">Delete</a>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="${pageContext.request.contextPath}/manageUsers/viewProfile/${user.userId}">View</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <hr class="featurette-divider">

        </div>

        <hr class="featurette-divider">

    </div>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce-custom.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>

