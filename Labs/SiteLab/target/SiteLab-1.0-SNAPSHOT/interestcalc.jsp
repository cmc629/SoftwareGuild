<%-- 
    Document   : interestcalc
    Created on : Oct 4, 2015, 7:33:21 PM
    Author     : Christian Choi
--%>

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

            <h1>Interest Calculator</h1>

            <form action="InterestCalcServlet" method="POST">
                <p>
                    Please enter the initial principal.<br />
                    <input type="text" name="initial" required focus>
                </p>

                <p>
                    Please enter the interest rate.<br />
                    <input type="text" name="rate" required>
                </p>

                <p>
                    Please enter the number of years.<br />
                    <input type="text" name="years" required>
                </p>

<!--                <p>
                    Compound 'quarterly', 'monthly', or 'daily'?<br />
                    <input type="text" name="compound">
                </p>-->
                <p>
                    Compound:
                    <select name="compound" class="custom-form-control">
                        <option value="quarterly">Quarterly</option>
                        <option value="monthly">Monthly</option>
                        <option value="daily">Daily</option>
                    </select>
                </p>
                <input type="submit" value="Factorize" />
            </form>

        </div><!-- /.container -->  

        <script type="text/javascript" src="js/jquery-1.11.3.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js" ></script>

    </body>
</html>
