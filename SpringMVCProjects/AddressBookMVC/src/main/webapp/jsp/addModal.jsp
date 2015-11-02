<%-- 
    Document   : addModal
    Created on : Oct 16, 2015, 10:17:44 AM
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
                <h4 class="modal-title" id="addModalLabel">Create Address</h4>
            </div>
            <div class="modal-body">
                <form:form id ="addForm" class="form-horizontal" commandName="address" method="POST" role="form">

                    <div class="form-group">
                        <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                        <div class="col-md-6">
                            <form:input path="firstName" class="form-control" id="add-first-name" placeholder="First Name" required="require"/>
                            <form:errors path="firstName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-6">
                            <form:input path="lastName" class="form-control" id="add-last-name" placeholder="Last Name" required="require"/>
                            <form:errors path="lastName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-street-number" class="col-md-4 control-label">Street #:</label>
                        <div class="col-md-6">
                            <form:input path="streetNumber" class="form-control" id="add-street-number" placeholder="Street #" required="require"/>
                            <form:errors path="streetNumber" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-street-name" class="col-md-4 control-label">Street Name:</label>
                        <div class="col-md-6">
                            <form:input path="streetName" class="form-control" id="add-street-name" placeholder="Street Name" required="require"/>
                            <form:errors path="streetName" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-6">
                            <form:input path="city" class="form-control" id="add-city" placeholder="City" required="require"/>
                            <form:errors path="city" />
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State:</label>
                        <div class="col-md-2">
                            <form:select id="add-state" path="state" class="form-control">
                                <jsp:include page="stateDropdown.jsp" />
                            </form:select>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip Code:</label>
                        <div class="col-md-6">
                            <form:input path="zip" class="form-control" id="add-zip" placeholder="Zip Code" required="require"/>
                            <form:errors path="zip" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <div id="validation-errors"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="create-button" class="btn btn-default">
                                Add Address
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
