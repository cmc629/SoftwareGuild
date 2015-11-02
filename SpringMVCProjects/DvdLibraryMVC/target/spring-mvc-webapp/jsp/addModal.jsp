<%-- 
    Document   : addModal
    Created on : Oct 16, 2015, 10:37:33 AM
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
                <h4 class="modal-title" id="addModalLabel">Create DVD</h4>
            </div>
            <div class="modal-body">
                <form:form id="addForm" class="form-horizontal" commandName="dvd" method="POST" role="form">

                    <div class="form-group">
                        <label for="add-title" class="col-md-4 control-label">Title:</label>
                        <div class="col-md-6">
                            <form:input path="title" class="form-control" id="add-title" placeholder="Title"/>
                            <form:errors path="title" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-date" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-3 input-group date">
                            <form:input path="releaseDate" class="form-control" id="add-date" placeholder="Release Date" />
                            <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span>
                                <form:errors path="releaseDate" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-rating" class="col-md-4 control-label">MPAA Rating:</label>
                        <div class="col-md-2">
                            <form:select id="add-rating" path="mpaaRating" class="form-control">
                                <option value="G">G</option>
                                <option value="PG">PG</option>
                                <option value="PG-13">PG-13</option>
                                <option value="R">R</option>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-director" class="col-md-4 control-label">Director:</label>
                        <div class="col-md-6">
                            <form:input path="director" class="form-control" id="add-director" placeholder="Director"/>
                            <form:errors path="director" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-6">
                            <form:input path="studio" class="form-control" id="add-studio" placeholder="Studio"/>
                            <form:errors path="studio" />
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <div id="validation-errors"></div>
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button id="create-button" type="submit" class="btn btn-default">
                                Create
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

