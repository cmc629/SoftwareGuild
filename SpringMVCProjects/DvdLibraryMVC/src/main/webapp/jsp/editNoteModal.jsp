<%-- 
    Document   : noteEditModal
    Created on : Oct 22, 2015, 1:37:05 PM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="editNoteModal" tabindex="-1" role="dialog" aria-labelledby="editNoteLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editNoteLabel">Edit Comment</h4>
            </div>
            <form class="form-horizontal" role="form">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="edit-content" class="col-md-4 control-label">Comment:</label>
                        <div class="col-md-6">
                            <input name="content" class="form-control" id="edit-content" required="require"/>
                        </div>
                    </div>
                    <input type="hidden" id="edit-note-id" />
                    <input type="hidden" id="edit-note-dvdId" />
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button id="edit-note-button" role="submit" class="btn btn-info">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit

                </div>

            </form>
        </div>
    </div>
</div>
