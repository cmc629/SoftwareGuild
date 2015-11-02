<%-- 
    Document   : addModal
    Created on : Oct 16, 2015, 10:37:33 AM
    Author     : Christian Choi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="editModalLabel">Edit DVD</h4>
            </div>
            <div class="modal-body">
                <form id="editForm" class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="edit-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="edit-title" placeholder="Title"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-date" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-3 input-group date">
                        <input type="text" class="form-control" id="edit-date" placeholder="Release Date" />
                        <span class="input-group-addon btn"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-rating" class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-2">
                        <select id="edit-rating" class="form-control">
                            <option value="G" <c:if test="${dvd.mpaaRating eq 'G'}">selected</c:if>>G</option>
                            <option value="PG" <c:if test="${dvd.mpaaRating eq 'PG'}">selected</c:if>>PG</option>
                            <option value="PG-13" <c:if test="${dvd.mpaaRating eq 'PG-13'}">selected</c:if>>PG-13</option>
                            <option value="R" <c:if test="${dvd.mpaaRating eq 'R'}">selected</c:if>>R</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-director" class="col-md-4 control-label">Director:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="edit-director" placeholder="Director"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="edit-studio" class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="edit-studio" placeholder="Studio"/>
                    </div>
                </div>

                <input type="hidden" id="edit-dvd-id" />

                <div id="edit-validation-errors"></div>
                
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button id="edit-button" type="submit" class="btn btn-default">
                            Update DVD
                        </button>
                        <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/collection/view/${dvd.id}">Back</a>
                    </div>
                    
                </div>

            </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

