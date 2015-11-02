<%-- 
    Document   : factorizer
    Created on : Oct 3, 2015, 10:16:02 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/site-custom.css" rel="stylesheet">

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <li class="active"><a href="FactorizerServlet">Factorizer</a></li>
                        <li><a href="InterestCalcServlet">Interest Calculator</a></li>
                        <li><a href="RPSServlet">Rock Paper Scissors</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">

            <h1>Factorizer Result</h1>

            <p>The factors for ${number} are:<br>

                <c:forEach items="${factors}" var="factor">
                    ${factor} 
                </c:forEach>
                <br>

                ${number} is ${primeMessage}.<br>
                ${number} is ${perfectMessage}.</p>

            <a role="button" class="btn btn-primary" href="FactorizerServlet">Factorize Another Number</a>

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
