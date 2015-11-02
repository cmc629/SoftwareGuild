<%-- 
    Document   : navbar
    Created on : Oct 28, 2015, 9:53:25 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="pull-left">
            <h1 id="br">THE TONER HOUSE</h1>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="pull-right collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <c:forEach items="${pages}" var="page">
                    <li><a href="${pageContext.request.contextPath}/pages/${page.staticPageId}">${page.title}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/blog/">Blog</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="${pageContext.request.contextPath}/signin/">Sign In</a></li>
                <li><a href="${pageContext.request.contextPath}/register/">Register</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
