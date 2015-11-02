/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $(document).on('click', '#create-button', function (e) {

        e.preventDefault();

        $('#validation-errors').empty();

        $.ajax({
            type: 'POST',
            url: 'addresses/',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                streetNumber: $('#add-street-number').val(),
                streetName: $('#add-street-name').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#addModal').modal('hide');

            $('#add-first-name').val("");
            $('#add-last-name').val("");
            $('#add-street-number').val("");
            $('#add-street-name').val("");
            $('#add-city').val("");
            $('#add-state').val("AL");
            $('#add-zip').val("");

            var tableRow = buildAddressRow(data);

            $('#addressTable').append($(tableRow));

        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });

    $(document).on('click', '#edit-button', function (e) {

        e.preventDefault();

        $('#edit-validation-errors').empty();

        var addressId = $('#edit-address-id').val();

        $.ajax({
            type: "PUT",
            url: "addresses/" + addressId,
            data: JSON.stringify({
                id: addressId,
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                streetNumber: $('#edit-street-number').val(),
                streetName: $('#edit-street-name').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zip: $('#edit-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#editModal').modal('hide');

            //rebuild table row containing the id reference

            var tableRow = buildAddressRow(data);

            $('#address-row-' + data.id).replaceWith($(tableRow)); //the $(tableRow) takes string html into jquery element


        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#edit-validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });

    $(document).on('click', '#edit-button-search', function (e) {

        e.preventDefault();

        $('#edit-validation-errors').empty();

        var addressId = $('#edit-address-id').val();

        $.ajax({
            type: "PUT",
            url: "../../addresses/" + addressId,
            data: JSON.stringify({
                id: addressId,
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                streetNumber: $('#edit-street-number').val(),
                streetName: $('#edit-street-name').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zip: $('#edit-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#editSearchModal').modal('hide');

            //rebuild table row containing the id reference
            var viewPanel = buildViewPanel(data);
            $('#view-' + addressId).replaceWith($(viewPanel));


        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#edit-validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });

    $(document).on('click', '#open-add-modal', function (e) {

        $('#validation-errors').empty();

    });

    $(document).on('click', '#delete-button', function (e) {
        
        e.preventDefault();

        var addressId = $('#delete-address-id').val();

        $.ajax({
            type: 'DELETE',
            url: 'addresses/' + addressId
        }).success(function (data, status) {

            $('#deleteModal').modal('hide');

            $('#address-row-' + addressId).remove(); //delete from the dom

        });

    });

    $('#viewModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'addresses/' + addressId

        }).success(function (address) {

            modal.find("#view-name").text(address.firstName + " " + address.lastName);
            modal.find("#view-address").text(address.streetNumber + " " + address.streetName);
            modal.find("#view-city").text(address.city);
            modal.find("#view-state").text(address.state);
            modal.find("#view-zip").text(address.zip);
        });

    });

    $('#editModal').on('show.bs.modal', function (e) {
        
        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'addresses/' + addressId

        }).success(function (address) { //event handler for success

            modal.find('#edit-address-id').val(address.id);
            modal.find('#edit-first-name').val(address.firstName);
            modal.find('#edit-last-name').val(address.lastName);
            modal.find('#edit-street-number').val(address.streetNumber);
            modal.find('#edit-street-name').val(address.streetName);
            modal.find('#edit-city').val(address.city);
            modal.find('#edit-state').val(address.state);
            modal.find('#edit-zip').val(address.zip);

        });

    });

    $('#editSearchModal').on('show.bs.modal', function (e) {
        
        $('#edit-validation-errors').empty();
        
        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');
        console.log("I'm getting to editSearchModal. The dvd Id is " + addressId);
        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: '../../addresses/' + addressId

        }).success(function (address) { //event handler for success

            modal.find('#edit-address-id').val(address.id);
            modal.find('#edit-first-name').val(address.firstName);
            modal.find('#edit-last-name').val(address.lastName);
            modal.find('#edit-street-number').val(address.streetNumber);
            modal.find('#edit-street-name').val(address.streetName);
            modal.find('#edit-city').val(address.city);
            modal.find('#edit-state').val(address.state);
            modal.find('#edit-zip').val(address.zip);

        });

    });

    $('#deleteModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var pageId = link.data('page-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'addresses/' + addressId

        }).success(function (address) {

            modal.find("#address-name").text(address.firstName + " " + address.lastName);
            modal.find("#address-address").text(address.streetNumber + " " + address.streetName);
            modal.find("#address-city").text(address.city);
            modal.find("#address-state").text(address.state);
            modal.find("#address-zip").text(address.zip);

            modal.find('#delete-address-id').val(address.id);
        });

    });

    function buildViewPanel(data) {
        return "<div id='view-" + data.id + "' class='panel panel-default'>\n\
                <div class='panel-heading'>\n\
                    <h3 class='panel-title'>" + data.lastName + ", " + data.firstName + "</h3>\n\
                </div>\n\
                <div class='panel-body'>\n\
                    <p>Address: " + data.streetNumber + " " + data.streetName + "</p>\n\
                    <p>City: " + data.city + "</p>\n\
                    <p>State: " + data.state + "</p>\n\
                    <p>Zip Code: " + data.zip + "</p>\n\
                </div>\n\
            </div>";
    }

    function buildAddressRow(data) {
        return "<tr id='address-row-" + data.id + "'>\n\
                <td>" + data.firstName + " " + data.lastName + "</td>\n\
                <td>" + data.streetNumber + " " + data.streetName + "</td>\n\
                <td>" + data.city + "</td>\n\
                <td>" + data.state + "</td>\n\
                <td>" + data.zip + "</td>\n\
                <td>\n\
                <a type='button' class='btn'data-toggle='modal' \n\
                data-target='#editModal' \n\
                data-address-id='" + data.id + "'>Edit</a> \n\
                <a type='button' class='btn' data-toggle='modal' \n\
                data-target='#deleteModal' \n\
                data-address-id='" + data.id + "'>Delete</a> \n\
                <a type='button' class='btn' data-toggle='modal' \n\
                data-target='#viewModal' \n\
                data-address-id='" + data.id + "'>View</a>\n\
                </td>\n\
        </tr>";
    }

});

