<%-- 
    Document   : index
    Created on : Oct 2, 2015, 2:50:28 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple Web Applications</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/site-custom.css" rel="stylesheet">
    </head>
    <body id="home">
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
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li><a href="LuckySevensServlet">Lucky Sevens</a></li>
                        <li><a href="FactorizerServlet">Factorizer</a></li>
                        <li><a href="InterestCalcServlet">Interest Calculator</a></li>
                        <li><a href="RPSServlet">Rock Paper Scissors</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active carousel-container">
                    <img class="carousel-img" src="img/home.jpg" alt="Home">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Software Guild Java Cohort</h3>
                            <p>JSP Site Lab</p>
                        </div>
                    </div>
                </div>
                <div class="item carousel-container">
                    <img class="carousel-img" src="img/luckysevens.jpg" alt="LuckySevens">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Lucky Sevens</h3>
                            <p class="custom-carousel-caption">
                                Place how much money you would like to bet. See how many rolls until failure.</p>
                            <p><a role="button" class="btn btn-primary" href="LuckySevensServlet">Click Here</a></p>
                        </div>
                    </div>
                </div>
                <div class="item carousel-container">
                    <img class="carousel-img" src="img/factorizer.jpg" alt="factorizer">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Factorizer</h3>
                            <p class="custom-carousel-caption">
                                Enter a number to see all the factors. Is it prime? Is it perfect?
                            </p>
                            <p><a role="button" class="btn btn-primary" href="FactorizerServlet">Click Here</a></p>
                        </div>
                    </div>
                </div>
                <div class="item carousel-container">
                    <img class="carousel-img" src="img/ic.jpg" alt="InterestCalc">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Interest Calculator</h3>
                            <p class="custom-carousel-caption">
                                Enter your initial principal, years, interest rate, and compound.
                            </p>
                            <p><a role="button" class="btn btn-primary" href="InterestCalcServlet">Click Here</a></p>
                        </div>
                    </div>
                </div>
                <div class="item carousel-container">
                    <img class="carousel-img" src="img/rps.jpg" alt="RPS">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Rock Paper Scissors</h3>
                            <p class="custom-carousel-caption">
                                Rock...Paper...Scissors...Shoot!
                            </p>
                            <p><a role="button" class="btn btn-primary" href="RPSServlet">Click Here</a></p>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="container">
            <div class="row featurette">
                <div class="col-md-1"></div>
                <div class="col-md-7">
                    <h2 class="featurette-heading">Welcome to Site Lab</h2>
                    <p class="lead">
                        Site Lab contains four very basic web applications. Play 
                        <span class="text-muted">Lucky Sevens</span> to see how 
                        many rolls it'll take for you to lose all your money. 
                        Need to factor a number? Do you need to know if it's 
                        a prime or perfect number? Use the <span class="text-muted">
                            Factorizer</span> application to get your answers. The 
                        <span class="text-muted">Interest Calculator</span> will 
                        show you the ending balance of each year based on your 
                        interest rate and compound value. Lastly, enjoy a quick 
                        game of <span class="text-muted">Rock Paper Scissors</span>!
                    </p>
                </div>
                <div class="col-md-4"></div>
            </div>

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
        </div>

        <script type="text/javascript" src="js/jquery-1.11.3.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js" ></script>
    </body>
</html>
