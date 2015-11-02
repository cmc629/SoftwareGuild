<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        
        <div class="modal-content">
            
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="editModalLabel">Edit Page</h4>
            </div>
            
            <div class="modal-body">
                
                <div class="panel">
                    <form method="PUT">
                        <fieldset>
                            <span><p>Edit Page Title:</p></span>
                            <input type="hidden" id="edit-page-id"></input>
                            <input type="text" id="edit-page-title"></input>
                            <div><br /><p>Enter page content:</p></div>
                            <textarea id="edit-page-content" name="content" style="width:100%"></textarea>
                            <div><a class="btn btn-info" id="edit-page" href="#"><span>Submit</span></a></div>

                        </fieldset>
                    </form>
                </div>

                <div id="edit-validation-errors"></div>
                
                
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

