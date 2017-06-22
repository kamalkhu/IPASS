$(document).ready(function() {
	$.getJSON('../restservices/clients', function(data){
	    var html = '';
	    var len = data.length;
	    for (var i = 0; i< len; i++) {
	        html += '<option value="' + data[i].id + '">' + data[i].firstname + " " + data[i].lastname + '</option>';
	    }
	    $('#client').append(html);
	});
	
	$.getJSON('../restservices/trainers', function(data){
	    var html = '';
	    var len = data.length;
	    for (var i = 0; i< len; i++) {
	        html += '<option value="' + data[i].id + '">' + data[i].firstname + " " + data[i].lastname + '</option>';
	    }
	    $('#personaltrainer').append(html);
	}); 
});

function sendData(){
	var startdate = $('#startdate').val();
	var starttime = $('#starttime').val();
	var duration = $('#duration').val();
	var type = $('#type').val();
	var client = $('#client').val();
	var personaltrainer = $('#personaltrainer').val();
	$.ajax({
		url: "../restservices/activities?Q1=" + localStorage.getItem("activityid") + "&Q2=" + startdate + "&Q3=" + starttime + "&Q4=" + duration + "&Q5=" + type + "&Q6=" + client + "&Q7=" + personaltrainer,
		method: "PUT",
		success: function(result){
			window.location = 'rooster.html' 
		},
		error(){
			console.log('Error');
		}
	});
}

$( "#submitButton" ).click(function() {
	sendData();
});

function deleteData(){
	$.ajax({
		url: "../restservices/activities?Q1=" + localStorage.getItem("activityid"),
		method: "DELETE",
		success: function(result){
			window.location = 'rooster.html' 
		},
		error(){
			console.log('Error');
		}
	});
}

$( "#deleteButton" ).click(function() {
	deleteData();
});