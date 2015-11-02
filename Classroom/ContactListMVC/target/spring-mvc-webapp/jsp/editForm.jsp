<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>${contact.firstName} ${contact.lastName}</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Contact List</h1>
            <hr/>

            <jsp:include page="navbar.jsp"/>

            <div class="row">

                <form:form class="form-horizontal" commandName="contact" action="${pageContext.request.contextPath}/contact/edit" method="POST" role="form">
                    
                    <form:hidden path="id" />
                    
                    <div class="form-group">
                        <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                        <div class="col-md-8">
                            <form:input path="firstName" class="form-control" id="add-first-name" placeholder="First Name"/>
                            <!--<input type="text" name="firstName" class="form-control" id="add-first-name" placeholder="First Name" />-->
                            <form:errors path="firstName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-8">
                            <form:input path="lastName" class="form-control" id="add-last-name" placeholder="Last Name" />
                            <form:errors path="lastName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-company" class="col-md-4 control-label">Company:</label>
                        <div class="col-md-8">
                            <form:input path="company" class="form-control" id="add-company" placeholder="Company" />
                            <form:errors path="company" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-email" class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8">
                            <form:input path="email" class="form-control" id="add-email" placeholder="Email" />
                            <form:errors path="email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8">
                            <form:input path="phone" class="form-control" id="add-phone" placeholder="Phone" />
                            <form:errors path="phone" />
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit"
                                    class="btn btn-default">
                                Update Contact
                            </button>
                        </div>

                    </div>

                </form:form>

            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

