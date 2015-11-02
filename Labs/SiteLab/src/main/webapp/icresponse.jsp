<%-- 
    Document   : interestcalc
    Created on : Oct 4, 2015, 7:33:21 PM
    Author     : Christian Choi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/site-custom.css" rel="stylesheet">
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">JSP Site Lab</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="LuckySevensServlet">Lucky Sevens</a></li>
                        <li><a href="FactorizerServlet">Factorizer</a></li>
                        <li class="active"><a href="InterestCalcServlet">Interest Calculator</a></li>
                        <li><a href="RPSServlet">Rock Paper Scissors</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">

            <h1>Interest Calculations</h1>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Year</th>
                        <th>Initial Balance</th>
                        <th>Total Interest</th>
                        <th>Ending Balance</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${result}" var="result">
                        <tr>
                            <th scope="row">${result.key}</th>
                            <c:forEach items="${result.value}" var="value">
                                <td>${value}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        
            <a role="button" class="btn btn-primary" href="InterestCalcServlet">Another Calculation</a>
            
            <hr class="featurette-divider">

            <footer class="footer">
                <div class="footer-container">
                    <p class="pull-right"><a href="#">Back to top</a></p>
                    <p class="text-muted home-footer">
                        Created By: Christian Choi 2015<br>
                        Powered by Java and Bootstrap
                    </p>
                </div>
            </footer>
            
        </div><!-- /.container -->  

        <script type="text/javascript" src="js/jquery-1.11.3.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js" ></script>

    </body>
</html>
