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
            url: '../FlooringMVC/',
            data: JSON.stringify({
                customerName: $('#add-customer-name').val(),
                date: Date.parse($('#add-date').val()),
                productName: $('#add-product-name').val(),
                stateName: $('#add-state-name').val(),
                area: $('#add-area').val(),
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#addModal').modal('hide');

            $('#add-customer-name').val("");
            $('#add-date').val("");
            $('#add-product-name').val("Laminate");
            $('#add-state-name').val("PA");
            $('#add-area').val("");

            var wholePanel = buildWholePanel(data);

            $('#accordion').append($(wholePanel));

        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });

        });

    });
    
    $(document).on('click', '#edit-button', function (e) {
        console.log("I got to edit button!");
        e.preventDefault();

        $('#edit-validation-errors').empty();

        var orderId = $('#edit-order-id').val();
        console.log("The order ID is: " + orderId);
        $.ajax({
            type: 'PUT',
            url: '../FlooringMVC/' + orderId,
            data: JSON.stringify({
                orderNumber: orderId,
                customerName: $('#edit-customer-name').val(),
                date: Date.parse($('#edit-date').val()),
                productName: $('#edit-product-name').val(),
                stateName: $('#edit-state-name').val(),
                area: $('#edit-area').val(),
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            
            $('#editModal').modal('hide');

            var wholePanel = buildWholePanel(data);

            $('#accordion').replaceWith($(wholePanel));
            
            console.log("successfully replaced!")
            
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
    
    $('#editModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var orderId = link.data('order-id');

        var modal = $(this);
        
        $.ajax({
            type: 'GET',
            url: '../FlooringMVC/' + orderId

        }).success(function (order) { //event handler for success

            modal.find('#edit-order-id').val(order.orderNumber);
            modal.find('#edit-customer-name').val(order.customerName);
            var date = new Date(order.date);
            var formattedDate = getFormattedDashDate(date)
            modal.find('#edit-date').val(formattedDate);
            modal.find('#edit-product-name').val(order.product.productName);
            modal.find('#edit-state-name').val(order.state.stateName);
            modal.find('#edit-area').val(order.area);
            
        });

    });
    
    function buildWholePanel(data) {
        
        var date = new Date(data.date);
        var formattedDate = getFormattedDate(date);
        
        console.log("Please get here");
        
        return "<div class='panel panel-default'>\n\
            <div class='custom panel-heading' role='button' id='heading" + data.date + "' data-toggle='collapse' data-parent='#accordion' href='#collapse" + data.date + "' aria-expanded='true' aria-controls='collapse" + data.date + "'>\n\
                <h4 class='panel-title'>" + formattedDate + "</h4>\n\
            </div>\n\
            <div id='collapse" + data.date + "' class='panel-collapse collapse in'role='tabpanel' aria-labelledby='heading" + data.date + "'>\n\
                <div class='panel-body'>\n\
                    <div class='row'>\n\
                        <div class='col-md-6'>\n\
                            Order #: " + data.orderNumber + "\n\
                        </div>\n\
                        <div class='col-md-2'>\n\
                            <a href='' data-toggle='modal' data-target='#editModal' data-order-id='" + data.orderNumber + "' role ='button'>Edit</a>\n\
                        </div>\n\
                        <div class='col-md-2'>\n\
                            <a href='${pageContext.request.contextPath}/orders/delete/" + data.orderNumber + "' role ='button'>Delete</a>\n\
                        </div>\n\
                        <div class='col-md-2'>\n\
                            <a href='${pageContext.request.contextPath}/orders/view/" + data.orderNumber + "' role ='button'>Details</a>\n\
                        </div>\n\
                    </div>\n\
                    <br />\n\
                    <div class='row'>\n\
                        <div class='col-md-1'></div>\n\
                        <div class='col-md-11'>\n\
                            <p>Name: " + data.customerName + "</p>\n\
                            <p>Product: " + data.product.productName + "</p>\n\
                            <p>State: " + data.state.stateName + "</p>\n\
                            <p>Area: " + data.area + " sq ft</p>\n\
                        </div>\n\
                    </div>\n\
                    <hr class='featurette-divider'>\n\
                </div>\n\
            </div>\n\
        </div>";
        
    }
    
    function getFormattedDate(date) {

        var monthNames = [
            "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"
        ];

        var monthIndex = date.getMonth();

        return (monthNames[monthIndex]) + ' ' + date.getDate() + ', ' + date.getFullYear();
    }
    
    function getFormattedDashDate(date) {
        
        return ((date.getMonth() + 1) + '-' + date.getDate() + '-' + date.getFullYear());
        
    }

});

