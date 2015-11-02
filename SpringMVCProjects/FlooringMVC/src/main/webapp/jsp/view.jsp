<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Add Order</title>
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

        <div class="container">

            <h2><center>Flooring Orders</center></h2>

            <jsp:include page="header.jsp"/>

            <div class="inner cover">

                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="panel panel-default panel-background">
                        <div class="panel-heading">
                            <h1 class="panel-title panel-font"><h3>Order Details</h3></h1>
                        </div>

                        <div class="panel-body panel-font">

                            <div class="row">
                                <div class="col-md-6">
                                    Order #: ${order.orderNumber}
                                </div>
                            </div>
                            <br />
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-4">
                                    <p><strong>Name: ${order.customerName}</strong></p>
                                    <fmt:formatDate value="${order.date}" type="date" pattern="MMMM dd, yyyy" var="formattedDate" />
                                    <p>${formattedDate}</p>
                                </div>

                                <div class="col-md-6">

                                    <table class="table table-striped table-condensed">
                                        <thead>
                                            <tr>
                                                <th>Information</th>
                                                <th>Value</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Product</td>
                                                <td>${order.product.productName}</td>
                                            </tr>
                                            <tr>
                                                <td>Material Cost per Sq Ft</td>
                                                <td>$ ${order.product.costPer}/sq ft</td>
                                            </tr>
                                            <tr>
                                                <td>Labor Cost per Sq Ft</td>
                                                <td>$ ${order.product.laborCostPer}/sq ft</td>
                                            </tr>
                                            <tr>
                                                <td>Area</td>
                                                <td>${order.area} sq ft</td>
                                            </tr>
                                            <tr>
                                                <td>Total Material Cost</td>
                                                <td>${materialCost}</td>
                                            </tr>
                                            <tr>
                                                <td>Total Labor Cost</td>
                                                <td>${laborCost}</td>
                                            </tr>
                                            <tr>
                                                <td>State</td>
                                                <td>${order.state.stateName}</td>
                                            </tr>
                                            <tr>
                                                <td>Tax Rate</td>
                                                <td>${order.state.taxRate}%</td>
                                            </tr>
                                            <tr>
                                                <td>Subtotal</td>
                                                <td>${subtotal}</td>
                                            </tr>
                                            <tr>
                                                <td>Total</td>
                                                <td>${total}</td>
                                            </tr>
                                            
                                        </tbody>

                                    </table>

                                </div>

                            </div>

                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>
    </body>


</html>


