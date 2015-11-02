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
            <!-- Add Modal -->
            <jsp:include page="addModal.jsp" />

            <!-- Edit Modal -->
            <jsp:include page="editModal.jsp" />

            <!-- Delete Modal-->
            <jsp:include page="deleteModal.jsp" />

            <!--View Modal-->
            <jsp:include page="viewModal.jsp" />
            
            <!--Start Page-->
            <h1>Address Book</h1>
            <hr/>

            <jsp:include page="navbar.jsp" />

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 custom">
                    <h2>Current Addresses</h2>
                    <br>
                </div>
            </div>
            
            <button id="open-add-modal" type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal">
                Add Address
            </button>


            <table id="addressTable" class="table table-striped">
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
                        <tr id="address-row-${address.id}">
                            <td>${address.firstName} ${address.lastName}</td>
                            <td>${address.streetNumber} ${address.streetName}</td>
                            <td>${address.city}</td>
                            <td>${address.state}</td>
                            <td>${address.zip}</td>
                            <td>
                                <a type="button" class="btn" data-toggle="modal"
                                   data-target="#editModal" 
                                   data-address-id="${address.id}">Edit</a>
                                <a type="button" class="btn" data-toggle="modal" 
                                   data-target="#deleteModal"
                                   data-address-id="${address.id}">Delete</a>
                                <a type="button" class="btn" data-toggle="modal"
                                   data-target="#viewModal"
                                   data-address-id="${address.id}">View</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <hr class="featurette-divider">

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

    </body>
</html>

