/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('#year-search .input-group.date').datepicker({
        format: " yyyy",
        orientation: "bottom auto",
        viewMode: "years",
        minViewMode: "years"

    });
    
    $('.input-group.date').datepicker({
        format: "mm-dd-yyyy",
        orientation: "bottom auto",
        todayHighlight: true

    });

});