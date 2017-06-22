function sendData(){
	var voornaam = $('#voornaam').val();
	var achternaam = $('#achternaam').val();
	$.ajax({
		url: "../restservices/clients?Q1=" + voornaam + "&Q2=" + achternaam,
		method: "POST",
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