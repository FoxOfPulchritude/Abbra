/*
 *	Basic JS part
 */

//animate in the content once the page is loaded
function animateInit() {
	document.getElementById("page").className="w3-animate-opacity";
}

/*
 * AngularJS scripts
 */
var app = angular.module("a", []);

app.controller("c", function($scope) {
	$scope.sample= testArticle();
});
function testArticle() {
	text = "";
	for(i=0;i<100;i++) {
		text += "This is an article. ";
	}
	return text;
}

/*
 * Jquery
 */
/*
$(document).ready(function() {

function toggleMenuFollow() {
	console.log("toggling");
	document.getElementById("nav").classList.toggle("w3-top")
}

function toggleLoginPage() {
	var l = document.getElementById("logon");
	if(l.style.display == "") {
		l.style.display = "block";
	}
	else if(l.style.display == "block") {
		l.style.display = "";
	}
}

//jquery updated methods show/hide and close

	var navMoving = 85;//$("#nav").scrollTop();
	$("#logon-menu-button").click(toggleLoginPage);
	$("#closer").click(toggleLoginPage);
	})
	*/