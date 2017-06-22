function sendData(){
	var voornaam = $('#voornaam').val();
	var achternaam = $('#achternaam').val();
	$.ajax({
		url: "../restservices/clients?Q1=" + localStorage.getItem("clientid") + "&Q2=" + voornaam + "&Q3=" + achternaam,
		method: "PUT",
		success: function(result){
			window.location = 'leden.html' 
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
		url: "../restservices/clients?Q1=" + localStorage.getItem("clientid"),
		method: "DELETE",
		success: function(result){
			window.location = 'leden.html' 
		},
		error(){
			console.log('Error');
		}
	});
}

$( "#deleteButton" ).click(function() {
	deleteData();
});