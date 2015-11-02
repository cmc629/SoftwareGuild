<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<div class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li role="presentation" class="${requestScope['javax.servlet.forward.request_uri'] eq '/DvdLibraryMVC/' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li role="presentation" class="${requestScope['javax.servlet.forward.request_uri'].contains('collection') ? 'active' : ''}"><a href="${pageContext.request.contextPath}/collection">Collection</a></li>
                <li role="presentation" class="dropdown ${requestScope['javax.servlet.forward.request_uri'].contains('search') ? 'active' : ''}">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        Search By <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/search/title">
                                Title
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/search/year">
                                Year Later Than
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/search/rating">
                                MPAA Rating
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/search/director">
                                Director
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/search/studio">
                                Studio
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>    
        </div>
    </div>

</div>


