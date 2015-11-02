<%-- 
    Document   : adminBlog
    Created on : Oct 29, 2015, 12:53:49 PM
    Author     : Aaron Alahverde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Blog Entries</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

        <link href='https://fonts.googleapis.com/css?family=Orbitron:900' rel='stylesheet' type='text/css'>

        <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <link href="${pageContext.request.contextPath}/css/HeaderStyle.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <div class="nav">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="pull-left">
                        <h1 id="br">THE TONER HOUSE</h1>
                    </div>
                </div>
            </nav>
        </div>

        <div class="container">
            <div class="list-pages">
                <p>Current pages:</p>
                <c:forEach items="${list}" var="page">
                    <div class="panel">
                        <div class="panel-heading">
                            ${page.title}
                        </div>
                        <div class="panel-body">
                            ${page.content}
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div id="view">
                <p>Create a new page.</p>
                <div class="panel">
                    <form method="post" action="show.php">
                        <p>     
                            <textarea name="content" cols="50" rows="15">
                            This is some content that will be editable with TinyMCE.
                            </textarea>
                            <input type="submit" value="Save" />
                        </p>
                    </form>
                </div>
            </div>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">tinyMCE.init({theme: "advanced",
                mode: "textareas", plugins: "fullpage",
                theme_advanced_buttons3_add: "fullpage"});</script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>
