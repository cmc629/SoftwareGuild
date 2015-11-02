/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {


    $(document).on('click', '#create-button', function (e) {

        e.preventDefault(); //if you click on something it takes you to something. but if you use this preventdefault, it will not take you to anything
        //remember that originally clicking the add button would take us to an add contact page. it doesn't do that anymore
        
        $('#validation-errors').empty(); //remove all validation errors

        $.ajax({
            type: 'POST',
            url: "contact/",
            data: JSON.stringify({//stringify takes javascript object and turns into string that's formatted to JSON
                //taking input parameter and making javascript object which goes into stringify
                firstName: $('#add-first-name').val(), //.val() is a jquery method to get the value of input box
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json', //accept tells spring what to respond with
                'Content-Type': 'application/json' //content type tells spring what it's trying to send it
            },
            dataType: 'json'
        }).success(function (data, status) {
            //console.log(data);

            $('#add-first-name').val(""); //setting values of all these fields to empty
            $('#add-last-name').val("");
            $('#add-company').val("");
            $('#add-phone').val("");
            $('#add-email').val("");

            var tableRow = buildContactRow(data);

            $('#contactTable').append($(tableRow));


        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });
    
    
    $(document).on('click', '.delete-link', function(e) {
        
        e.preventDefault();
        
        var contactId = $(e.target).data('contact-id');
        
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + contactId
        }).success(function(data, status) {
            
            $('#contact-row-' + contactId).remove(); //delete from the dom
            
        });
        
    });
    
    $(document).on('click', '#edit-button', function(e) {
        
        e.preventDefault();
        
        $('#edit-validation-errors').empty();
        
        //var modal = $(this); //referencing this references the current function. if we reference this inside success, it'll reference to ajax request
        
        var contactId = $('#edit-contact-id').val();
        
        $.ajax({
            type: "PUT",
            url: "contact/" + contactId,
            data: JSON.stringify({
                id: contactId,
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
            }),
            headers: {
                'Accept': 'application/json', 
                'Content-Type': 'application/json' 
            },
            dataType: 'json'
        }).success(function(data, status) {
            
            $('#editModal').modal('hide');
            
            //rebuild table row containing the id reference
            
            var tableRow = buildContactRow(data);
            $('#contact-row-' + data.id).replaceWith($(tableRow)); //the $(tableRow) takes string html into jquery element
            
            
        }).error(function(data, status) {
            
            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#edit-validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });
            
        });
        
    });
    
    
    //fire whenever detail modal starts displaying
    $('#detailsModal').on('show.bs.modal', function(e) {
        
        var link = $(e.relatedTarget); //represent the link of the contact name that brings to view details
        
        var contactId = link.data('contact-id');
        
        var modal = $(this); //this is reference to #detailsModal
        
        $.ajax({
           
            type: 'GET',
            url: "contact/" + contactId
            
        }).success(function(contact) {
            
            modal.find("#contact-firstName").text(contact.firstName);
            modal.find("#contact-lastName").text(contact.lastName);
            modal.find("#contact-company").text(contact.company);
            modal.find("#contact-phone").text(contact.phone);
            modal.find("#contact-email").text(contact.email);
            
        });
        
    });
    
    $('#editModal').on('show.bs.modal', function(e) {
       
        var link = $(e.relatedTarget);
        
        var contactId = link.data('contact-id');
        
        var modal = $(this);
        
        $.ajax({
            type: 'GET',
            url: "contact/" + contactId
            
        }).success(function(contact) { //event handler for success
            
            modal.find('#edit-contact-id').val(contact.id);
            modal.find('#edit-first-name').val(contact.firstName);
            modal.find('#edit-last-name').val(contact.lastName);
            modal.find('#edit-company').val(contact.company);
            modal.find('#edit-email').val(contact.email);
            modal.find('#edit-phone').val(contact.phone);
            
        });
        
    });
    
    function buildContactRow(data) {
        return "<tr id='contact-row-" + data.id +"'>\n\
                <td><a data-contact-id='" + data.id + "' data-toggle='modal' data-target='#detailsModal'>" + data.firstName + " " + data.lastName + "</a></td>\n\
                <td>" + data.company + "</td>\n\
                <td><a data-contact-id='" + data.id + "' data-toggle='modal' data-target='#editModal'>Edit</td>\n\
                <td><a data-contact-id='" + data.id + "' class='delete-link'>Remove</td>\n\
                </tr>";
        
    }


});