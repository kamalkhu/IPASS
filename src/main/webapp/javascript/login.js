console.log("hoi");
$(document).ready(function(){
	$("#loginButton").click(function() {
		var username = $('#un').val();
		var password = $('#pw').val();
		console.log("wow");
		$.getJSON('restservices/trainers', function(trainers) {
			for(var i = 0; i < trainers.length; i++){
				var obj = trainers[i];
				if(obj.username === username && obj.password === password){
					window.location = 'page/thuis.html'
				}
			}
		});
	});
});

$('.message a').click(function() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
});

function sendData(){
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var username = $('#username').val();
	var password = $('#password').val();
	$.ajax({
		url: "restservices/trainers?Q1=" + firstname + "&Q2=" + lastname + "&Q3=" + username + "&Q4=" + password,
		method: "POST",
		success: function(result){
			$('form').animate({
				height : "toggle",
				opacity : "toggle"
			}, "slow");
			alert("U kunt nu inloggen met uw gebruikersnaam en wachtwoord.")
		},
		error(){
			console.log('Error');
		}
	});
}

$("#registerButton").click(function() {
	sendData();
});