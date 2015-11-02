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
            <h1>Address Book</h1>
            <hr/>

            <jsp:include page="navbar.jsp" />

            <div id="view-${address.id}" class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${address.lastName}, ${address.firstName}</h3>
                </div>
                <div class="panel-body">
                    <p>Address: ${address.streetNumber} ${address.streetName}</p>
                    <p>City: ${address.city}</p>
                    <p>State: ${address.state}</p>
                    <p>Zip Code: ${address.zip}</p>
                </div>
            </div>

            <hr class="featurette-divider">
            <button type="button" class="btn btn-primary"
                    data-address-id="${address.id}" data-toggle="modal" 
                    data-target="#editSearchModal">Edit</button>

            <button type="button" class="btn btn-danger"
                    data-toggle="modal" 
                    data-target="#deleteSearchModal">Delete</button>

            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/search">New Search</a>

            <!-- Edit Modal -->
            <div class="modal fade bs-example-modal-lg" id="editSearchModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h4 class="modal-title" id="editModalLabel">Edit Address</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-first-name" class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-first-name" placeholder="First Name"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-street-number" class="col-md-4 control-label">Street #:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-street-number" placeholder="Street #"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-street-name" class="col-md-4 control-label">Street Name:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-street-name" placeholder="Street Name"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-city" class="col-md-4 control-label">City:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-city" placeholder="City"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-state" class="col-md-4 control-label">State:</label>
                                    <div class="col-md-2">
                                        <select id="edit-state" class="form-control">
                                            <jsp:include page="stateDropdown.jsp" />
                                        </select>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-zip" class="col-md-4 control-label">Zip Code:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-zip" placeholder="Zip Code"/>
                                    </div>
                                </div>

                                <input type="hidden" id="edit-address-id" />

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <div id="edit-validation-errors"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button id="edit-button-search" type="submit" class="btn btn-default">
                                            Update Address
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" href="${pageContext.request.contextPath}/addresses">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--End of edit modal-->

            <!-- Delete Modal-->
            <div class="modal fade bs-example-modal-lg" id="deleteSearchModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLab">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="deleteModalLabel">Delete Address</h4>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete this address?</p>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Street Address</th>
                                        <th>City</th>
                                        <th>State</th>
                                        <th>Zip Code</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${address.firstName} ${address.lastName}</td>
                                        <td>${address.streetNumber} ${address.streetName}</td>
                                        <td>${address.city}</td>
                                        <td>${address.state}</td>
                                        <td>${address.zip}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <form action="${pageContext.request.contextPath}/addresses/deleteFinal/${address.id}" method="GET">
                                <button type="submit" class="btn btn-primary">Yes</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--End of delete modal-->

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

    </body>
</html>

