<%-- 
    Document   : deleteNoteModal
    Created on : Oct 22, 2015, 3:46:31 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="deleteNoteModal" tabindex="-1" role="dialog" aria-labelledby="deleteNoteLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="deleteNoteLabel">Delete Comment</h4>
            </div>
            <div class="modal-body">
                <p class="custom">
                    Are you sure you want to delete this comment?<br>
                    Comment: <span id="show-note-content" class="custom"></span>
                </p>
                <input type="hidden" id="delete-note-id" />
                <input type="hidden" id="delete-note-dvdId" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <a id="delete-note-button" role="button" class="btn btn-danger">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
                </a>
            </div>
        </div>
    </div>
</div>
