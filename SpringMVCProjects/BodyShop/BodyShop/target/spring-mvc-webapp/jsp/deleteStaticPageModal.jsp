<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        
        <div class="modal-content">
            
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="deleteModalLabel">Delete Page</h4>
            </div>
            
            <div class="modal-body">
                <p>Are you sure you want to delete this page?</p>
                <input type="hidden" id="delete-page-id"></input>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <a id="delete-page" role="button" class="btn btn-danger">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
                </a>
            </div>
        </div>
    </div>
</div>

