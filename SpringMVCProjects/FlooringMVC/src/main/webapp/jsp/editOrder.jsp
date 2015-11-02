<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Order Page</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/cover.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/flooring.png">

    </head>
    <body>

        <div class="site-wrapper">

            <h2><center>Flooring Orders</center></h2>

            <div class="container">

                <!--I made a rows within your container. The first row contains the home button-->
                <div class="row">

                    <div class="col-md-1"></div>
                    <div class="col-md-2">
                        <a href="${pageContext.request.contextPath}/"><h4>Home</h4></a>
                    </div>
                </div>
                <!--end of first row-->

            </div>



            <div class="inner cover">


                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="panel panel-default panel-background">
                        <div class="panel-heading">
                            <h1 class="panel-title panel-font"><h3>Edit Order</h3></h1>
                            <br>



                            <form:form class="form-horizontal" commandName="orderForm" action="${pageContext.request.contextPath}/orders/edit" method="POST" role="form">

                                <div class="form-group">
                                    <label for="edit-customer-name" class="col-md-4 control-label ">Name:</label>
                                    <div class="col-md-6">
                                        <form:input path="customerName" class="form-control" id="edit-customer-name" placeholder="${order.customerName}"/>
                                        <form:errors path="customerName" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-order-date" class="col-md-4 control-label">Date:</label>
                                    <div class="col-md-6 input-group date">

                                        <form:input path="date" class="form-control" id="edit-order-date" placeholder="Date"/>
                                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span> 
                                            <form:errors path="date" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-product" class="col-md-4 control-label">Product:</label>
                                    <div class="col-md-6">
                                        <form:select path="productName" id="edit-product" class="form-control">
                                            <c:forEach items="${products}" var="productOption">
                                                <option value="${productOption}"<c:if test="${orderForm.productName eq productOption}">selected</c:if>>${productOption}</option>
                                            </c:forEach>
                                        </form:select>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-state" class="col-md-4 control-label">State:</label>
                                    <div class="col-md-2">
                                        <form:select path="stateName" class="form-control">
                                            <c:forEach items="${states}" var="stateOption">
                                                <option value="${stateOption}"<c:if test="${orderForm.stateName eq stateOption}">selected</c:if>>${stateOption}</option>
                                            </c:forEach>
                                        </form:select>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-area" class="col-md-4 control-label">Area (sq ft):</label>
                                    <div class="col-md-6">
                                        <form:input path="area" class="form-control" id="add-area" placeholder="Area"/>
                                        <form:errors path="area"/>
                                    </div>
                                </div>

                                <form:hidden path="orderNumber"/>

                                <div class="form-group">
                                    <div class="col-md-7"></div>
                                    <div class="col-md-2">
                                        <button type="submit" class="btn btn-primary">
                                            Edit Order
                                        </button>
                                    </div>
                                    <div class="col-md-2">
                                        <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/">Back</a>                                        

                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>



    </body>

</html>


