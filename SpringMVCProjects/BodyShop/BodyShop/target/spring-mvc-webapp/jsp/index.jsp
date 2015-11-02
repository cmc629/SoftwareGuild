<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Toner House</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/transss.png">

        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <link href='https://fonts.googleapis.com/css?family=Orbitron:900' rel='stylesheet' type='text/css'>

        <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>

    </head>
    <body id="fullBack">

        <div class="nav">
            <jsp:include page="navbar.jsp"/>
        </div>

<!--        <div>
            <h1 id="br"><b><u>THE TONER HOUSE</u></b></h1>
        </div>-->

        <div class="container">

            <div class="row">

                <div class="col-md-8">
                    <div id="back" class="text-block">
                        <div>
                            <p id="firstpar"> <b>THE TONER HOUSE IS DEDICATED TO MEETING YOUR FITNESS GOALS!</b></p>
                        </div>


                        <div>
                            <img src="http://www.dieselcrew.com/wp-content/uploads/2009/04/arnold-squat-franco-300x271.jpg" id="marginleft" alt="arnold" style="width:250px;height:250px;">

                            <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/SPRINTBW_zpsttsucfem.jpg" id="marginleft2" alt="globo" style="width:250px;height:250px;">
                        </div>

                        <p id="secondpar"> <b>The Toner House offers the highest quality in</b></p>

                        <div class="list-group">

                            <ul id="homeList">
                                <li> <b>Trainers</b> - Our trainers are all NSCA certified or have obtained a degree in exercise studies! </li>
                                <li> <b>Equipment</b> - Our equipment at The Toner House is top of the line free weights, machines, and cardio equipment! </li>
                                <li> <b>Classes</b> - Our classes will have you sweating and burning calories once the timer starts!</li>
                                <li> <b>Products</b> - Our partnership with Amazon will enable anyone to have access to the best supplements on the market!</li>
                                <li> <b>Blog</b> - Our blog gives users the the opportunity to be up to date with what is happening in the world of fitness and Toner House promotions</li>
                            </ul>

                        </div>
                    </div>

                    <div id="back">

                        <p id="secondpar"><b>MISSION STATEMENT</b></p>

                        <p id="firstpar">The Toner House's mission is to enhance the quality of life in the communities we serve through our fitness philosophy, facilities, classes, and products and to instill in the lives of people everywhere the value of health and fitness.</p>

                        <div>

                            <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/GIRLBW_zpsmlgstfhj.jpg" id="bord3" alt="barbell" style="width: 600px;height: 200px;">

                        </div>

                        <p id=""></p>

                    </div>

                </div>

                <div class="col-md-4">

                    <div id="backtwo">

                        <p id="firstpar"><b>CLASSES</b></p>
                        <ul id="li">
                            <li>Personal Training Sessions</li>
                            <li>Spinning</li>
                            <li>Zumba</li>
                            <li>Hot Yoga</li>
                            <li>Bootcamp</li>
                        </ul>


                        <div id="bord2">

                            <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/spin_zpsqvd83ahh.jpg" alt="spin" style="width:350px;height:300px;" >

                        </div>

                        <p>  </p>

                    </div>

                    <div id="back">

                        <div>

                            <p id="firstpar"><b> LOCATION </b></p>
                            <p id="location"> 526 South Main Street </p>
                            <p id="location"> Akron, OH 44311</p>
                            <p id="location"> Phone: (855)-599-9584 </p>
                            <p id="location"> TonerShopStacked@gmail.com </p>

                        </div>

                        <div id="bord2">

                            <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/AKRON1_zpspdlbdwdt.jpg" alt="gym" style="width:350px;height:320px;">

                        </div>

                    </div>

                    <div id="back">

                        <div>
                            <p id="firstpar"><b>Hours of Operation</b></p>
                            <ul>
                                <li id="li">Monday: 5am - 7pm</li>

                                <li id="li">Tuesday: 5am - 7pm</li>

                                <li id="li">Wednesday: 5am - 7pm</li>

                                <li id="li">Thursday: 5am - 7pm</li>

                                <li id="li">Friday: 5am - 7pm</li>

                                <li id="li">Saturday: 6am - 3pm</li>

                                <li id="li">Sunday: Closed</li>

                            </ul>

                        </div>

                    </div>

                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container">
                <p id="firstpar"><b>&copy;2015 Toner House, LLC. ALL RIGHTS RESERVED</b></p>
            </div>
        </footer>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>




</html>

