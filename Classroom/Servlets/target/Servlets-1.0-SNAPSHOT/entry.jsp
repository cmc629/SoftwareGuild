<%-- 
    Document   : entry
    Created on : Oct 1, 2015, 3:11:20 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">

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
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">

            <h1>I'm having a party and you're invited</h1>
            
            <p>Can you attend?</p>
            
            <form action="RSVPServlet" method="POST">
                
                <p>Yes <input type="radio" name="myAnswer" value="yes" checked></p>
                <p>No <input type="radio" name="myAnswer" value="no"></p>
                
                <p>
                    
                    Reason (if not attending): <br />
                    <select name="myReason">
                        <option value="Out of town">Out of town</option>
                        <option value="Scheduling conflict">Scheduling Conflict</option>
                        <option value="How did you get this link? I thought I blocked you on facebook">You suck</option>
                    </select>
                    
                </p>
                
                <p>
                    
                    Notes<br />
                    <input type="text" name="myNotes"/>
                    
                </p>
                
                <input type="submit" value="RSVP"/>
                
            </form>

        </div><!-- /.container -->


        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>

    </body>
</html>
