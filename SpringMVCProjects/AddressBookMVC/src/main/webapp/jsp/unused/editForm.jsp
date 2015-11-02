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

        <!-- Edit Modal Static-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editModalLabel">Edit Address</h4>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" commandName="address" action="${pageContext.request.contextPath}/addresses/edit" method="POST" role="form">
                    <div class="form-group">
                        <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                        <div class="col-md-6">
                            <form:input path="firstName" class="form-control" id="add-first-name" placeholder="First Name"/>
                            <form:errors path="firstName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-6">
                            <form:input path="lastName" class="form-control" id="add-last-name" placeholder="Last Name"/>
                            <form:errors path="lastName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-street-num" class="col-md-4 control-label">Street #:</label>
                        <div class="col-md-6">
                            <form:input path="streetNumber" class="form-control" id="add-street-number" placeholder="Street #"/>
                            <form:errors path="streetNumber" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-street-name" class="col-md-4 control-label">Street Name:</label>
                        <div class="col-md-6">
                            <form:input path="streetName" class="form-control" id="add-street-name" placeholder="Street Name"/>
                            <form:errors path="streetName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-6">
                            <form:input path="city" class="form-control" id="add-city" placeholder="City"/>
                            <form:errors path="city" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State:</label>
                        <div class="col-md-2">
                            <jsp:include page="stateDropdownEdit.jsp" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip Code:</label>
                        <div class="col-md-6">
                            <form:input path="zip" class="form-control" id="add-zip" placeholder="Zip Code"/>
                            <form:errors path="zip" />
                        </div>
                    </div>

                    <form:hidden path="id" />

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" class="btn btn-default">
                                Update Address
                            </button>
                        </div>
                    </div>

                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" href="${pageContext.request.contextPath}/addresses">Close</button>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

