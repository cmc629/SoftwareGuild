/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $(document).on('focusin', function (e) {
        if ($(e.target).closest(".mce-window").length) {
            e.stopImmediatePropagation();
        }
    });

    $(document).on('click', '#create-page', function (e) {

        //console.log("Got to click button");

        e.preventDefault();

        var title = $('#page-title').val();
        var content = tinyMCE.activeEditor.getContent();

        $.ajax({
            type: 'POST',
            url: '../manageStaticPages/',
            data: JSON.stringify({
                title: title,
                content: content
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

//            var tableRow = buildAddressRow(data);
//
//            $('#addressTable').append($(tableRow));

        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });
    
    $(document).on('click', '#create-user', function (e) {

        e.preventDefault();

        $('#validation-errors').empty();

        $.ajax({
            type: 'POST',
            url: '../manageUsers/',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                age: $('#add-age').val(),
                gender: $('input[name=gender]:checked', '#addUserForm').val(),
                streetNumber: $('#add-street-number').val(),
                streetName: $('#add-street-name').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val(),
                email: $('#add-email').val(),
                phone: $('#add-phone').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            
            $('#addUserModal').modal('hide');
            
            var tableRow = buildUserRow(data);

            $('#userTable').append($(tableRow));

        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });

    $(document).on('click', '#edit-page', function (e) {

        //console.log("Got to click button");

        e.preventDefault();

        var id = $('#edit-page-id').val();
        var title = $('#edit-page-title').val();
        var content = tinyMCE.activeEditor.getContent();

        $.ajax({
            type: 'PUT',
            url: '../manageStaticPages/',
            data: JSON.stringify({
                staticPageId: id,
                title: title,
                content: content
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#editModal').modal('hide');
//            var tableRow = buildAddressRow(data);
//
//            $('#addressTable').append($(tableRow));

        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });

    $(document).on('click', '#delete-page', function (e) {

        e.preventDefault();
        
        var pageId = $('#delete-page-id').val();

        $.ajax({
            type: 'DELETE',
            url: '../manageStaticPages/' + pageId,
        }).success(function (data, status) {
            
            $('#deleteModal').modal('hide');
            
            $('#panel-page-' + pageId).remove(); //delete from the dom

        });

    });
    
    $(document).on('click', '#delete-user', function (e) {

        e.preventDefault();
        
        var userId = $('#delete-user-id').val();

        $.ajax({
            type: 'DELETE',
            url: '../manageUsers/' + userId,
        }).success(function (data, status) {
            
            $('#deleteUserModal').modal('hide');
            
            $('#user-row-' + userId).remove(); //delete from the dom

        });

    });

    $('#editModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var pageId = link.data('page-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: '../manageStaticPages/' + pageId

        }).success(function (sp) {

            modal.find('#edit-page-id').val(sp.staticPageId);
            modal.find('#edit-page-title').val(sp.title);
            tinyMCE.get('edit-page-content').setContent(sp.content);
            //modal.find('#edit-page-content').val(sp.content);

        });

    });
    
    $('#deleteModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var pageId = link.data('page-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: '../manageStaticPages/' + pageId

        }).success(function (sp) {

            modal.find("#delete-page-id").val(sp.staticPageId);
            
        });

    });
    
    $('#deleteUserModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var userId = link.data('user-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: '../manageUsers/' + userId

        }).success(function (user) {

            modal.find("#delete-user-id").val(user.userId);
            
        });

    });
    
    function buildUserRow(data) {
        return "<tr id='user-row-" + data.userId + "'>\n\
                            <td>" + data.firstName + " " + data.lastName + "</td>\n\
                            <td>" + data.streetNumber + " " + data.streetName + "</td>\n\
                            <td>" + data.city + "</td>\n\
                            <td>" + data.state + "</td>\n\
                            <td>" + data.zip + "</td>\n\
                            <td>" + data.email + "</td>\n\
                            <td>\n\
                                <div class='row'>\n\\n\
                                    <div class='col-md-3'>\n\
                                        <a href='#' data-toggle='modal' \n\
                                           data-target='#editUserModal'\n\
                                           data-user-id='" + data.userId + "'>Edit</a>\n\
                                    </div>\n\
                                    <div class='col-md-3'>\n\
                                        <a href='#' data-toggle='modal' \n\
                                           data-target='#deleteUserModal'\n\
                                           data-user-id='" + data.userId + "'>Delete</a>\n\
                                    </div>\n\
                                    <div class='col-md-3'>\n\
                                        <a href='${pageContext.request.contextPath}/manageUsers/viewProfile/" + data.userId + "'>View</a>\n\
                                    </div>\n\
                                </div>\n\
                            </td>\n\
                        </tr>";
    }
});

