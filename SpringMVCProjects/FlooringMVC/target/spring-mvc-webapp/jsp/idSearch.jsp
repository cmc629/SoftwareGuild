<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Order</title>
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

                    <div  id="accordion" class = "panel-group" role="tablist" aria-multiselectable="true">                

                        <div class="panel panel-default panel-background">
                            <div class="panel-heading">
                                <h4 class="panel-title panel-font">Order #${order.orderNumber}</h4>
                            </div>

                            <div class="panel-body panel-font">

                                <table id="contactTable" class="table">
                                    <tr>        
                                    <address>
                                        <td>
                                            <p><strong>Name: ${order.customerName}</strong></p>
                                            <p>Product: ${order.product.productName}</p>
                                            <p>State: ${order.state.stateName}</p>
                                            <p>Area: ${order.area}</p>
                                        </td>   
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td><a href="${pageContext.request.contextPath}/orders/edit/${order.orderNumber}" role ="button">Edit</a></td>
                                        <td><a href="${pageContext.request.contextPath}/orders/delete/${order.orderNumber}" role ="button">Delete</a></td>
                                        <td><a href="${pageContext.request.contextPath}/orders/view/${order.orderNumber}" role ="button">Details</a></td>
                                    </address>
                                    </tr>


                                </table>
                            </div>
                        </div>
                    </div>
                                    
                </div>

            
            </div>
            
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>

        <script src="../../dist/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
