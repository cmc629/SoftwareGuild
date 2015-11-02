<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>

            <jsp:include page='navbar.jsp' />

            <!--Edit modal-->
            <jsp:include page='editModal.jsp' />
            
            <!--Edit Note modal-->
            <jsp:include page='editNoteModal.jsp' />
            
            <!--Delete Note Modal-->
            <jsp:include page='deleteNoteModal.jsp' />

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="settings">
                            <li>
                                <a role="button" data-toggle="modal" data-target="#editModal" data-dvd-id="${dvd.id}">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit
                                </a>
                            </li>
                            <li>
                                <a href="#deleteDvd_${dvd.id}" role="button" data-toggle="modal">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
                                </a>
                            </li>
                        </ul>
                    </div>

                    <h3 id="dvd-view-title-${dvd.id}" class="panel-title">${dvd.title}</h3>

                </div>

                <div class="panel-body">
                    <div class="col-md-6">
                        <table class="table table-striped table-condensed">
                            <thead>
                                <tr>
                                    <th>Information</th>
                                    <th>Details</th>
                                </tr>
                            </thead>
                            <tbody id="dvd-table-${dvd.id}">
                                <tr>
                                    <td>Title</th>
                                    <td>${dvd.title}</th>
                                </tr>
                                <tr>
                                    <td>Release Date</td>
                                    <fmt:formatDate value="${dvd.releaseDate}" type="date" pattern="MMMM dd, yyyy" var="formattedDate" />
                                    <td>${formattedDate}</td>
                                </tr>
                                <tr>
                                    <td>MPAA Rating</td>
                                    <td>${dvd.mpaaRating}</td>
                                </tr>
                                <tr>
                                    <td>Director</td>
                                    <td>${dvd.director}</td>
                                </tr>
                                <tr>
                                    <td>Studio</td>
                                    <td>${dvd.studio}</td>
                                </tr>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>

            <h4>Comments:</h4>
            <div id="comment-box">
                <c:forEach items="${dvd.notes}" var="note" varStatus="noteIndex">
                    <div id="note-id-${note.id}" class="well well-sm">
                        <div class="row">
                            <div class="col-md-10">
                                ${note.content}
                            </div>
                            <div class="col-md-1">
                                <a href="#" data-note-id="${note.id}" data-target="#editNoteModal" data-toggle="modal">Edit</a>
                            </div>
                            <div class="col-md-1">
                                <a href="#" data-note-id="${note.id}" data-target="#deleteNoteModal" data-toggle="modal">Delete</a>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
            <hr class="featurette-divider">

            <h4>Add Comment:</h4>

            <form class="form-horizontal" action="${pageContext.request.contextPath}/collection/view/${dvd.id}/addNote" method="POST" role="form">
                <div class="form-group">
                    <div class="col-md-6">
                        <input id="add-comment" name="comment" type="text" class="form-control" placeholder="Comment..." required="required">
                    </div>
                    <button id="add-comment-button" data-dvd-id="${dvd.id}" type="submit" class="col-md-1 btn btn-default">Add</button>
                </div>
            </form>

            <!--Delete DVD modal-->
            <div class="modal fade bs-example-modal-lg" id="deleteDvd_${dvd.id}" tabindex="-1" role="dialog" aria-labelledby="deleteLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="deleteLabel">Delete DVD</h4>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete this DVD?</p>
                            <table class="table table-striped table-condensed">
                                <thead>
                                    <tr>
                                        <th>Information</th>
                                        <th>Details</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Title</th>
                                        <td>${dvd.title}</th>
                                    </tr>
                                    <tr>
                                        <td>Release Date</td>
                                        <fmt:formatDate value="${dvd.releaseDate}" type="date" pattern="MMMM dd, yyyy" var="formattedDate" />
                                        <td>${formattedDate}</td>
                                    </tr>
                                    <tr>
                                        <td>MPAA Rating</td>
                                        <td>${dvd.mpaaRating}</td>
                                    </tr>
                                    <tr>
                                        <td>Director</td>
                                        <td>${dvd.director}</td>
                                    </tr>
                                    <tr>
                                        <td>Studio</td>
                                        <td>${dvd.studio}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <a href="${pageContext.request.contextPath}/collection/view/delete/${dvd.id}"
                               role="button" class="btn btn-danger">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--End of modal-->

            <jsp:include page="footer.jsp" />

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/datepicker-custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

    </body>
</html>

