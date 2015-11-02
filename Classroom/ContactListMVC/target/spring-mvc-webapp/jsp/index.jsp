<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
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

                <div class="col-md-6">

                    <h2>My Contacts</h2>

                    <table id="contactTable" class="table tab-hover">
                        <tr>
                            <th width="40%">Name</th>
                            <th witdh="30%">Company</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>

                        <c:forEach items="${contacts}" var="contact">
                            <tr id="contact-row-${contact.id}">
                                <td><a data-contact-id="${contact.id}" data-toggle="modal" data-target="#detailsModal">${contact.firstName} ${contact.lastName}</a></td>
                                <td>${contact.company}</td>
                                <td><a data-contact-id="${contact.id}" data-toggle="modal" data-target="#editModal">Edit</a></td>
                                <td><a data-contact-id="${contact.id}" class="delete-link"">Remove</a></td>

                            </tr>

                        </c:forEach>

                    </table>

                </div>


                <div class="col-md-6">

                    <h2>Add New Contact</h2>

                    <form:form class="form-horizontal" commandName="contact" action="${pageContext.request.contextPath}/contact/add" method="POST" role="form">

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
                                <form:errors path="email" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <form:input path="phone" class="form-control" id="add-phone" placeholder="Phone" />
                                <form:errors path="phone" />
                            </div>
                        </div>

                        <div id="validation-errors">

                        </div>    

                        <div class="form-group">

                            <div class="col-md-offset-4 col-md-8">
                                <button id="create-button" type="submit"
                                        class="btn btn-default">
                                    Create Contact
                                </button>
                            </div>

                        </div>

                    </form:form>

                </div>

            </div>


            <div class="modal fade" id="detailsModal" role="dialog">
                <div class="modal-dialog">

                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                Close
                            </button>

                            <h4 class="modal-title" id="detailsModalLabel">Contact Details</h4>

                        </div>



                        <div class="modal-body">

                            <table class="table table-bordered">
                                <tr>
                                    <th>First Name:</th>
                                    <td id="contact-firstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td id="contact-lastName"></td>
                                </tr>
                                <tr>
                                    <th>Company:</th>
                                    <td id="contact-company"></td>
                                </tr>
                                <tr>
                                    <th>Phone:</th>
                                    <td id="contact-phone"></td>
                                </tr>
                                <tr>
                                    <th>Email:</th>
                                    <td id="contact-email"></td>
                                </tr>
                            </table>

                        </div>
                    </div>
                </div>

            </div>

            <div class="modal fade" id="editModal" role="dialog">
                <div class="modal-dialog">

                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                Close
                            </button>

                            <h4 class="modal-title" id="editModalLabel">Edit Contact</h4>

                        </div>

                        <div class="modal-body">
                            <!--this is client side validation. spring is server side validation-->
                            <form class="form-horizontal" role="form">

                                <div class="form-group">
                                    <label for="edit-first-name" class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-first-name" placeholder="First Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-company" class="col-md-4 control-label">Company:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-company" placeholder="Company" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-email" class="col-md-4 control-label">Email:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-email" placeholder="Email" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-phone" class="col-md-4 control-label">Phone:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-phone" placeholder="Phone" />
                                    </div>
                                </div>
                                <div id="edit-validation-errors"></div>
                                <div class="form-group">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-8">

                                        <button id="edit-button" class="btn btn-info">Edit Contact</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">
                                            Cancel
                                        </button>
                                        <input type="hidden" id="edit-contact-id" />
                                    </div>

                                </div>



                            </form>


                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

    </body>
</html>

