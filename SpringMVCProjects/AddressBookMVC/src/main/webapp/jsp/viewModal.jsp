<%-- 
    Document   : viewModal
    Created on : Oct 16, 2015, 10:18:06 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="viewModal" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>

                <h4 class="modal-title" id="viewModalLabel">Address Details</h4>

            </div>

            <div class="modal-body">

                <table class="table table-striped table-bordered table-condensed">
                    <tr>
                        <th>Name:</th>
                        <td id="view-name"></td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td id="view-address"></td>
                    </tr>
                    <tr>
                        <th>City:</th>
                        <td id="view-city"></td>
                    </tr>
                    <tr>
                        <th>State:</th>
                        <td id="view-state"></td>
                    </tr>
                    <tr>
                        <th>Zip Code:</th>
                        <td id="view-zip"></td>
                    </tr>
                </table>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>

</div>
