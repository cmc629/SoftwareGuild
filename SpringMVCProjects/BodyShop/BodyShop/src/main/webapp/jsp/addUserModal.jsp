<%-- 
    Document   : addModal
    Created on : Oct 16, 2015, 10:17:44 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="addModalLabel">Create User</h4>
            </div>
            <div class="modal-body">
                <form:form id ="addUserForm" class="form-horizontal" commandName="user" method="POST" role="form">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Name:</label>
                                <div class="col-md-8">
                                    <form:input path="firstName" class="form-control" id="add-first-name" placeholder="First Name" required="require"/>
                                    <form:errors path="firstName" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <div class="col-md-9">
                                    <form:input path="lastName" class="form-control" id="add-last-name" placeholder="Last Name" required="require"/>
                                    <form:errors path="lastName" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-5 control-label">Age:</label>
                                <div class="col-md-7">
                                    <form:input path="age" class="form-control" id="add-age" placeholder="Age" required="require"/>
                                    <form:errors path="age" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-md-2 control-label">Gender:</label>
                                <div class="col-md-10">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" value="M"/>Male
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" value="F"/>Female
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Address:</label>
                                <div class="col-md-8">
                                    <form:input path="streetNumber" class="form-control" id="add-street-number" placeholder="Street #" required="require"/>
                                    <form:errors path="streetNumber" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <div class="col-md-9">
                                    <form:input path="streetName" class="form-control" id="add-street-name" placeholder="Street Name" required="require"/>
                                    <form:errors path="streetName" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="add-city" class="col-md-5 control-label">City:</label>
                                <div class="col-md-7">
                                    <form:input path="city" class="form-control" id="add-city" placeholder="City" required="require"/>
                                    <form:errors path="city" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="add-state" class="col-md-4 control-label">State:</label>
                                <div class="col-md-8">
                                    <form:select id="add-state" path="state" class="form-control">
                                        <jsp:include page="stateDropdown.jsp" />
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="add-zip" class="col-md-3 control-label">Zip:</label>
                                <div class="col-md-8">
                                    <form:input path="zip" class="form-control" id="add-zip" placeholder="Zip Code" required="require"/>
                                    <form:errors path="zip" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Email:</label>
                                <div class="col-md-8">
                                    <form:input path="email" class="form-control" id="add-email" placeholder="Email" required="require"/>
                                    <form:errors path="email" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="col-md-3 control-label">Phone:</label>
                                <div class="col-md-6">
                                    <form:input path="phone" class="form-control" id="add-phone" placeholder="###-###-####" required="require"/>
                                    <form:errors path="phone" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <div id="validation-errors"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="create-user" class="btn btn-success">
                                        Submit
                                    </button>
                                </div>
                            </div>
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
