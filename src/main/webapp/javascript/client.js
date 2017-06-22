$(document).ready(function () {
    $.getJSON('../restservices/clients',
    function (json) {
        var tr;
        for (var i = 0; i < json.length; i++) {
            tr = $("<tr clienid=" + json[i].id + "/>");
            tr.append("<td>" + json[i].firstname + "</td>");
            tr.append("<td>" + json[i].lastname + "</td>");
            tr.append("<td>" + "<button value='" + json[i].id + "' class='editbtn'>BEWERK</button>" + "</td>");
            $('#clientTable').append(tr);
            $('.editbtn').click(function() {
            	localStorage.setItem('clientid', $(this).attr('value'));
            	window.location = 'wijzigclient.html' 
            });
        }
    });
    $( "#addclient" ).click(function() {
    	window.location = 'nieuweclient.html' 
    });
});
