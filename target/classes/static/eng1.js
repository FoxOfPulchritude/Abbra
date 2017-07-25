/*
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

// Submit form using AJAX for the login

$(document).ready(function() {
	console.log("The script loaded up correctly.");
	$('#login-button').ajaxForm(function() {
		alert("Login was succesful!");
	})
})