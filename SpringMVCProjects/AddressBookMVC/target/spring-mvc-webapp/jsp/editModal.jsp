<%-- 
    Document   : editModal
    Created on : Oct 16, 2015, 10:17:55 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="editModalLabel">Edit Address</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-first-name" class="col-md-4 control-label">First Name:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-first-name" placeholder="First Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-street-number" class="col-md-4 control-label">Street #:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-street-number" placeholder="Street #"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-street-name" class="col-md-4 control-label">Street Name:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-street-name" placeholder="Street Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-city" placeholder="City"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-state" class="col-md-4 control-label">State:</label>
                        <div class="col-md-2">
                            <select id="edit-state" class="form-control">
                                <jsp:include page="stateDropdown.jsp" />
                            </select>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-zip" class="col-md-4 control-label">Zip Code:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-zip" placeholder="Zip Code"/>
                        </div>
                    </div>

                    <input type="hidden" id="edit-address-id" />

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <div id="edit-validation-errors"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button id="edit-button" type="submit" class="btn btn-default">
                                Update Address
                            </button>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" href="${pageContext.request.contextPath}/addresses">Close</button>
            </div>
        </div>
    </div>
</div>