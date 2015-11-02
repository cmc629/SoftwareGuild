<%-- 
    Document   : header
    Created on : Oct 15, 2015, 1:22:24 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

    <!--I made a rows within your container. The first row contains the home button-->
    <div class="row">

        <div class="col-md-1"></div>
        <div class="col-md-2">
            <a href="${pageContext.request.contextPath}/"><h4>Home</h4></a>
        </div>
    </div>
    <!--end of first row-->

    <!--This is the second row. This has your add order, search, and list by date functions-->
    <div class="row">
        <div class="col-md-1"></div>


        <div class="col-md-2">
            <button id="open-add-modal" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">Add Order</button>
        </div>

        <div class="col-md-4">

            <form class="form-search form-inline" action="${pageContext.request.contextPath}/search/orderNumber" method="POST" role="form">
                <div class="input-group">
                    <input name = "orderNumber" type="text" class="form-control search-query" id="orderNumber" placeholder="Search by Order #..." /> 
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-primary">Search</button>
                    </span>

                </div>
            </form>
        </div>

        <div class="col-md-5">
            <div class="form-group">

                <form class="form-search form-inline" action="${pageContext.request.contextPath}/search/orderByDate" method="POST" role="form">

                    <div class="col-md-6 input-group date">
                        <input name="date" class="form-control" id="search-date" placeholder="Search by Date..." />
                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Search
                    </button>
                </form>
            </div> 

        </div>
    </div>
    <!--end of second row-->

</div>
