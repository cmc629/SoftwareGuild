<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Orders</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">

            <h2><center>Flooring Orders</center></h2>

            <jsp:include page="header.jsp"/>

            <!--Add Modal-->
            <div class="modal fade bs-example-modal-lg" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h4 class="modal-title" id="addModalLabel">Create Order</h4>
                        </div>
                        <div class="modal-body">
                            <form:form class="form-horizontal" commandName="orderForm" method="POST" role="form">

                                <div class="form-group">
                                    <label for="add-customer-name" class="col-md-4 control-label">Name:</label>
                                    <div class="col-md-6">
                                        <form:input path="customerName" class="form-control" id="add-customer-name" placeholder="Customer Name"/>
                                        <form:errors path="customerName" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-date" class="col-md-4 control-label">Date:</label>
                                    <div class="col-md-6 input-group date">

                                        <form:input path="date" class="form-control" id="add-date" placeholder="Date"/>
                                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span> 
                                            <form:errors path="date" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-product-name" class="col-md-4 control-label">Product:</label>
                                    <div class="col-md-6">
                                        <form:select path="productName" id="add-product-name" class="form-control">
                                            <!--I'm using jstl's forEach to loop through the products list I created and added to the model
                                            This way allows me to not hard-code all the product options-->
                                            <c:forEach items="${products}" var="productOption">
                                                <option value="${productOption}">${productOption}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-state-name" class="col-md-4 control-label">State:</label>
                                    <div class="col-md-2">
                                        <form:select path="stateName" id="add-state-name" class="form-control">
                                            <c:forEach items="${states}" var="stateOption">
                                                <option value="${stateOption}">${stateOption}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-area" class="col-md-4 control-label">Area (sq ft):</label>
                                    <div class="col-md-6">
                                        <form:input path="area" class="form-control" id="add-area" placeholder="Area"/>
                                        <form:errors path="area" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <div id="validation-errors"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button id="create-button" type="submit" class="btn btn-primary">
                                            Add Order
                                        </button>
                                    </div>
                                </div>
                            </form:form>

                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>


            <!--Edit Modal-->
            <div class="modal fade bs-example-modal-lg" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h4 class="modal-title" id="editModalLabel">Edit Order</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-customer-name" class="col-md-4 control-label">Name:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-customer-name" placeholder="Customer Name"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-date" class="col-md-4 control-label">Date:</label>
                                    <div class="col-md-3 input-group date">
                                        <input type="text" class="form-control" id="edit-date" placeholder="Date" />
                                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-product-name" class="col-md-4 control-label">Product:</label>
                                    <div class="col-md-6">
                                        <select class="form-control" id="edit-product-name">
                                            <c:forEach items="${products}" var="productOption">
                                                <option value="${productOption}">${productOption}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="edit-state-name" class="col-md-4 control-label">State:</label>
                                    <div class="col-md-6">
                                        <select class="form-control" id="edit-state-name">
                                            <c:forEach items="${states}" var="stateOption">
                                                <option value="${stateOption}">${stateOption}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="edit-area" class="col-md-4 control-label">Area:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" id="edit-area" placeholder="Area"/>
                                    </div>
                                </div>

                                <input type="hidden" id="edit-order-id" />

                                <div id="edit-validation-errors"></div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button id="edit-button" type="submit" class="btn btn-default">
                                            Update Order
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

            <!--Delete Modal-->

            <!--List orders-->
            <div class="inner cover">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                        <c:forEach items="${orderMap}" var="entry">
                            <div class="panel panel-default">
                                <div class="custom panel-heading" role="button" id="heading${entry.key.time}" data-toggle="collapse" data-parent="#accordion" href="#collapse${entry.key.time}" aria-expanded="true" aria-controls="collapse${entry.key.time}">
                                    <h4 class="panel-title">
                                        <fmt:formatDate value="${entry.key}" var="formattedDate" type="date" pattern="MMMM dd, yyyy" />
                                        ${formattedDate}
                                    </h4>
                                </div>
                                <div id="collapse${entry.key.time}" class="panel-collapse collapse in"role="tabpanel" aria-labelledby="heading${entry.key.time}">
                                    <div class="panel-body">

                                        <c:forEach items="${entry.value}" var="order">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    Order #: ${order.orderNumber}
                                                </div>
                                                <div class="col-md-2">
                                                    <a href="" data-toggle="modal" data-target="#editModal" data-order-id="${order.orderNumber}" role ="button">Edit</a>
                                                </div>

                                                <div class="col-md-2">
                                                    <a href="${pageContext.request.contextPath}/orders/delete/${order.orderNumber}" role ="button">Delete</a>
                                                </div>
                                                <div class="col-md-2">
                                                    <a href="${pageContext.request.contextPath}/orders/view/${order.orderNumber}" role ="button">Details</a>
                                                </div>
                                            </div>
                                            <br />
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-11">
                                                    <p>Name: ${order.customerName}</p>
                                                    <p>Product: ${order.product.productName}</p>
                                                    <p>State: ${order.state.stateName}</p>
                                                    <p>Area: ${order.area} sq ft</p>
                                                </div>
                                            </div>

                                            <hr class="featurette-divider">
                                        </c:forEach>

                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                </div>

            </div>

            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
            <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>
            <script src="${pageContext.request.contextPath}/js/app.js"></script>



    </body>
</html>

