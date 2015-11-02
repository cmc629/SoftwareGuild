<%-- 
    Document   : deleteModal
    Created on : Oct 16, 2015, 10:18:16 AM
    Author     : Christian Choi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade bs-example-modal-lg" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLab">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="deleteModalLabel">Delete Address</h4>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete this address?</p>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Street Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip Code</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="address-name"></td>
                            <td id="address-address"></td>
                            <td id="address-city"></td>
                            <td id="address-state"></td>
                            <td id="address-zip"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="delete-address-id" />
                <button id="delete-button" type="submit" class="btn btn-danger">Yes</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>