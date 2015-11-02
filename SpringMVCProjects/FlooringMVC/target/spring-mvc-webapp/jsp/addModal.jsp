<%-- 
    Document   : addModal
    Created on : Oct 19, 2015, 12:19:28 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="addModalLabel">Create Order</h4>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" commandName="orderForm" method="POST" role="form">

                    <div class="form-group">
                        <label for="add-customer-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-6">
                            <form:input path="customerName" class="form-control" id="add-customer-name" placeholder="Customer Name"/>
                            <form:errors path="customerName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-order-date" class="col-md-4 control-label">Date:</label>
                        <div class="col-md-6 input-group date">

                            <form:input path="date" class="form-control" id="add-date" placeholder="Date"/>
                            <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span> 
                                <form:errors path="date" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-product" class="col-md-4 control-label">Product:</label>
                        <div class="col-md-6">
                            <form:select path="productName" id="add-product-name" class="form-control">
                                <!--I'm using jstl's forEach to loop through the products list I created and added to the model
                                This way allows me to not hard-code all the product options-->
                                <c:forEach items="${products}" var="productOption">
                                    <option value="${productOption}">${productOption}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State:</label>
                        <div class="col-md-2">
                            <form:select path="stateName" id="add-state-name" class="form-control">
                                <c:forEach items="${states}" var="stateOption">
                                    <option value="${stateOption}">${stateOption}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-area" class="col-md-4 control-label">Area (sq ft):</label>
                        <div class="col-md-6">
                            <form:input path="area" class="form-control" id="add-area" placeholder="Area"/>
                            <form:errors path="area" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <div id="validation-errors"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button id="create-button" type="submit" class="btn btn-primary">
                                Add Order
                            </button>
                        </div>
                    </div>
                </form:form>
                
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
