<%-- 
    Document   : viewerRegister
    Created on : Nov 1, 2015, 4:05:03 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <title>ViewerRegister</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/transss.png">

        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <link href='https://fonts.googleapis.com/css?family=Orbitron:900' rel='stylesheet' type='text/css'>

        <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>
    </head>

    <body id="fullBack3">

        <div class="nav">
            <jsp:include page="navbar.jsp"/>
        </div>

        <div class="col-md-5"></div>

        <div class="col-md-7">
            <form id="back3">
                <div class="row" id="down">

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" class="form-control" id="firstName" placeholder="FirstName">
                        </div>
                        <div class="form-group">
                            <label for="age">Age</label>
                            <input type="integer" class="form-control" id="age" placeholder="Age">
                        </div>
                        <div class="form-group">
                            <label for="age">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label for="age">Street Number</label>
                            <input type="integer" class="form-control" id="streetNumber" placeholder="StreetNumber">
                        </div>
                        <div class="form-group">
                            <label for="age">City</label>
                            <input type="text" class="form-control" id="city" placeholder="City">
                        </div>
                        <div class="form-group">
                            <label for="age">Zip</label>
                            <input type="integer" class="form-control" id="zip" placeholder="Zip">
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" class="form-control" id="lastName" placeholder="LastName">
                        </div>
                        <div class="checkbox" id="down2">
                            <label>
                                <input type="checkbox"> Male
                            </label>
                            <label id="boxR">
                                <input type="checkbox"> Female
                            </label>
                        </div>
                        <div class="form-group" id="down3">
                            <label for="age">Phone</label>
                            <input type="integer" class="form-control" id="phone" placeholder="Phone">
                        </div>
                        <div class="form-group">
                            <label for="age">Street Name</label>
                            <input type="text" class="form-control" id="streetName" placeholder="StreetName">
                        </div>
                        <div class="form-group">
                            <label for="age">State</label>
                            <input type="text" class="form-control" id="state" placeholder="State">
                        </div>
                        <div>

                            <button type="submit" class="btn btn-danger" id="down4">Register</button>
                        </div>
                    </div>

                    <div>
                        <img src="http://i1166.photobucket.com/albums/q619/lawofsuccess1/transss_zpscevwhl1i.png" id="trans" alt="transformer">
                    </div>
                </div>

            </form>
        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>


</html>
