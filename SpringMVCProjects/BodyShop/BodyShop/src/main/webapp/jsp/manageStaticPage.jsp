<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Pages</title>
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

        <!--Edit Page Modal-->
        <jsp:include page="editStaticPageModal.jsp" />

        <!--Delete Page Modal-->
        <jsp:include page="deleteStaticPageModal.jsp" />

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
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/admin/">
                Back
            </a>

            <p>Current pages:</p>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                <c:forEach items="${list}" var="page">
                    <div id="panel-page-${page.staticPageId}" class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-11" role="button" id="heading${page.staticPageId}" data-toggle="collapse" data-parent="#accordion" href="#collapse${page.staticPageId}" aria-expanded="true" aria-controls="collapse${page.staticPageId}">
                                    <h4 class="panel-title">
                                        Page Title: ${page.title}
                                    </h4>
                                </div>
                                <div class="col-md-1">
                                    <div class="dropdown pull-right">
                                        <a href="#" class="dropdown-toggle color-adjust" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="settings">
                                            <li>
                                                <a role="button" data-toggle="modal" data-target="#editModal" data-page-id="${page.staticPageId}">
                                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit Page
                                                </a>
                                            </li>
                                            <li>
                                                <a role="button" data-toggle="modal" data-target="#deleteModal" data-page-id="${page.staticPageId}">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Page
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>


                        </div>

                        <div id="collapse${page.staticPageId}" class="panel-collapse collapse "role="tabpanel" aria-labelledby="heading${page.staticPageId}">
                            <div class="panel-body">
                                ${page.content}
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <hr class="featurette-divider">

            <div id="view">
                <p>Create a new page.</p>
                <div class="panel">
                    <form method="POST">
                        <fieldset>
                            <span><p>Enter page title:</p></span>
                            <input type="text" placeholder="Page Title" id="page-title"></input>
                            <div><br /><p>Enter page content:</p></div>
                            <textarea name="content" style="width:100%"></textarea>
                            <div><a class="btn submitbtn" id="create-page" href="#"><span>Submit</span></a></div>

                        </fieldset>
                    </form>
                </div>
            </div>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/tinymce/tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce-custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>

