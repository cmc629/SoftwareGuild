<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Flooring Order</title>
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
                                    <h4 class="panel-title panel-font">
                                         <fmt:formatDate value="${date}" var="formattedDate" pattern="MMMM dd, yyyy"/>
                                         ${formattedDate}
                                    </h4>
                                </div>
                                <div id="collapse${entry.key}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${entry.key}">
                                    

                                    <div class="panel-body panel-font">
                                        <div>
                                            <table id="contactTable" class="table">
                                                <c:forEach items="${results}" var="value">
                                                    <tr>        
                                                <address>
                                                    <td>
                                                        <p><strong>Name: ${value.customerName}</strong></p>
                                                        <p>Product: ${value.product.productName}</p>
                                                        <p>State: ${value.state.stateName}</p>
                                                        <p>Area: ${value.area}</p>
                                                    </td>   
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><a href="${pageContext.request.contextPath}/orders/edit/${value.orderNumber}" role ="button">Edit</td>
                                                    <td><a href="${pageContext.request.contextPath}/orders/delete/${value.orderNumber}" role ="button">Delete</a></td>
                                                    <td><a href="${pageContext.request.contextPath}/orders/view/${order.orderNumber}" role ="button">Details</a></td>
                                                </address>
                                                </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                    

                    </div> 


                    
                </div>
                <div class="col-md-2"></div> 
            </div>

        </div>

            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
            <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>



    </body>

</html>


