<%-- 
    Document   : navbar
    Created on : Oct 6, 2015, 10:00:59 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="navbar">
    <ul class="nav nav-tabs">
        <li role="presentation" class="${requestScope['javax.servlet.forward.request_uri'] eq '/AddressBookMVC/' ? 'active' : ''}"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li role="presentation" class="${requestScope['javax.servlet.forward.request_uri'].contains('addresses') ? 'active' : ''}"><a href="${pageContext.request.contextPath}/addresses">Addresses</a><li>
        <li role="presentation" class="${pageContext.request.servletPath.contains('search') ? 'active' : ''}"><a href="${pageContext.request.contextPath}/search">Search</a></li>
    </ul>    
</div>