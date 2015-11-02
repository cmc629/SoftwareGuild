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
            url: 'collection/',
            data: JSON.stringify({
                title: $('#add-title').val(),
                releaseDate: Date.parse($('#add-date').val()),
                mpaaRating: $('#add-rating').val(),
                director: $('#add-director').val(),
                studio: $('#add-studio').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataTye: 'json'
        }).success(function (data, status) {

            $('#addModal').modal('hide');

            $('#add-title').val("");
            $('#add-date').val("");
            $('#add-director').val("");
            $('#add-rating').val("G");
            $('#add-studio').val("");

            var panel = buildDvdPanel(data);

            $('#accordion').append($(panel));


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

        var dvdId = $('#edit-dvd-id').val();

        $.ajax({
            type: 'PUT',
            url: 'collection/' + dvdId,
            data: JSON.stringify({
                id: dvdId,
                title: $('#edit-title').val(),
                releaseDate: Date.parse($('#edit-date').val()),
                mpaaRating: $('#edit-rating').val(),
                director: $('#edit-director').val(),
                studio: $('#edit-studio').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            
            $('#editModal').modal('hide');

            var tableView = buildTableView(data);
            var tableHeading = buildTableHeading(data);

            $('#dvd-table-' + data.id).replaceWith($(tableView));
            $('#dvd-view-title-' + data.id).replaceWith($(tableHeading));
            
        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#edit-validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });
        });

    });
    
    $(document).on('click', '#add-comment-button', function (e) {
        
        e.preventDefault();
        
//        var link = $(e.relatedTarget);
//        console.log("link is" + link);
//        var dvdId = link.data('dvd-id');
        
        var dvdId = $(e.target).data('dvd-id');
        
        $.ajax({
            type: 'POST',
            url: dvdId + '/note',
            data: JSON.stringify({
                content: $('#add-comment').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            
            var commentRow = buildCommentRow(data);
            
            $('#comment-box').append($(commentRow));
            
            $('#add-comment').val("");
            
        });
        
    });
    
    $(document).on('click', '#edit-note-button', function (e) {

        e.preventDefault();

        var noteId = $('#edit-note-id').val();

        $.ajax({
            type: 'PUT',
            url: 'note/' + noteId,
            data: JSON.stringify({ //why send note as json when you can just get the note using pathvariable from the DAO in controller
                id: noteId,
                content: $('#edit-content').val(),
                dvdId: $('#edit-note-dvdId').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            
            $('#editNoteModal').modal('hide');

            var commentRow = buildCommentRow(data);
            
            $('#note-id-' + data.id).replaceWith($(commentRow));
            
        }).error(function (data, status) {

            var errors = data.responseJSON.validationErrors;

            $.each(errors, function (index, validationError) {

                $('#edit-validation-errors').append(validationError.fieldName + " " + validationError.message).append("<br />");

            });
        });

    });
    
    $(document).on('click', '#delete-note-button', function (e) {

        e.preventDefault();

        var noteId = $('#delete-note-id').val();
        
        console.log("this means you got to delete modal. The note id happens to be " + noteId);
        
        $.ajax({
            type: 'DELETE',
            url: 'note/' + noteId
        }).success(function (data, status) {
            
            console.log("This is the success for delete note");
            
            $('#deleteNoteModal').modal('hide');

            $('#note-id-' + noteId).remove();
            
        });

    });

    $('#editModal').on('show.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var dvdId = link.data('dvd-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'collection/' + dvdId

        }).success(function (dvd) {

            modal.find('#edit-dvd-id').val(dvd.id);
            modal.find('#edit-title').val(dvd.title);
            var date = new Date(dvd.releaseDate); //dvd.releaseDate is in milliseconds. create js date object from milliseconds
            var formattedDate = getFormattedDashDate(date); //convert date object into string date format with hyphens (mm-dd-yyyy)
            modal.find('#edit-date').val(formattedDate);
            modal.find('#edit-rating').val(dvd.mpaaRating);
            modal.find('#edit-director').val(dvd.director);
            modal.find('#edit-studio').val(dvd.studio);

        });

    });
    
    $('#editNoteModal').on('show.bs.modal', function (e) {
        
        var link = $(e.relatedTarget);

        var noteId = link.data('note-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'note/' + noteId

        }).success(function (note) {

            modal.find('#edit-note-id').val(note.id);
            modal.find('#edit-content').val(note.content);
            modal.find('#edit-note-dvdId').val(note.dvdId);

        });

    });
    
    $('#deleteNoteModal').on('show.bs.modal', function (e) {
        
        var link = $(e.relatedTarget);

        var noteId = link.data('note-id');

        var modal = $(this);

        $.ajax({
            type: 'GET',
            url: 'note/' + noteId

        }).success(function (note) {

            modal.find('#show-note-content').text(note.content);
            modal.find('#delete-note-id').val(noteId);
            modal.find('#delete-note-dvdId').val(note.dvdId);

        });

    });

    $(document).on('click', '#open-add-modal', function (e) {

        $('#validation-errors').empty();

    });

    function buildDvdPanel(data) {
        var date = new Date(data.releaseDate);
        var formattedDate = getFormattedDate(date);

        return "<div id= 'dvd-panel-" + data.id + "' class='panel panel-default'>\n\
                <div class='custom panel-heading' role='button' id='heading" + data.id +
                "' data-toggle='collapse' data-parent='#accordion' href='#collapse" +
                data.id + "' aria-expanded='true' aria-controls='collapse" +
                data.id + "'>\n\
                <h4 class='panel-title'>\n\
                " + data.title + "\n\
                </h4>\n\
                </div>\n\
                <div id='collapse" + data.id + "' class='panel-collapse collapse'\n\\n\
                role='tabpanel' aria-labelledby='heading" + data.id + "'>\n\
                <div class='panel-body'>\n\
                Title: " + data.title + " <br>\n\
                Release Date: " + formattedDate + " <br>\n\
                MPAA Rating: " + data.mpaaRating + " <br>\n\
                Director: " + data.director + " <br>\n\
                Studio: " + data.studio + " <br>\n\
                <a role='button' class='btn btn-xs btn-success' href='collection/view/" + data.id + "'>View</a>\n\
                </div>\n\
                </div>\n\
                </div>";
    }
    
    function buildTableHeading(data) {
        
        return "<h3 id='dvd-view-title-" + data.id + "' class='panel-title'>" + data.title + "</h3>"
        
    }
    
    function buildTableView(data) {
        var date = new Date(data.releaseDate);
        var formattedDate = getFormattedDate(date);
        
        return "<tbody id='dvd-table-" + data.id +"'>\n\
            <tr>\n\
                <td>Title</th>\n\
                <td>" + data.title + "</th>\n\
            </tr>\n\
            <tr>\n\
                <td>Release Date</td>\n\
                <td>" + formattedDate + "</td>\n\
            </tr>\n\
            <tr>\n\
                <td>MPAA Rating</td>\n\
                <td>" + data.mpaaRating + "</td>\n\
            </tr>\n\
            <tr>\n\
                <td>Director</td>\n\
                <td>" + data.director + "</td>\n\
            </tr>\n\
            <tr>\n\
                <td>Studio</td>\n\
                <td>" + data.studio + "</td>\n\
            </tr>\n\
        </tbody>";
        
    }
    
    function buildCommentRow(data) {
        return "<div id='note-id-" + data.id +"' class='well well-sm'>\n\
                    <div class='row'>\n\
                        <div class='col-md-10'>\n\
                            " + data.content + "\n\
                        </div>\n\
                        <div class='col-md-1'>\n\
                            <a href='#' data-note-id='" + data.id + "' data-target='#editNoteModal' data-toggle='modal'>Edit</a>\n\
                        </div>\n\
                        <div class='col-md-1'>\n\
                            <a href='#' data-note-id='" + data.id + "' data-target='#deleteNoteModal' data-toggle='modal'>Delete</a>\n\
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

