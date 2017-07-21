function calculateSanders() {
	var y = document.getElementById("t").value;
	y = Math.round(y);
	document.getElementById("result").innerHTML = 'You will save $' + y + ' in tuition since it will all be free.';
}

function calculateChristie() {
	var y = document.getElementById("t").value;
	var median_income = 45478;
	var scale = median_income * .04;
	var x = scale * 10;
	y = y - x;
	y = Math.round(y);
	document.getElementById("result").innerHTML = 'You will save $' + y + ' in tuition, but it is important to remember this is going off of the example Rubio, not Christie, gave and in theory the investor could ask for a completely different amount.';
}

function calculateRubio() {
	var y = document.getElementById("t").value;
	var median_income = 45478;
	var scale = median_income * .04;
	var x = scale * 10;
	y = y - x;
	y = Math.round(y);
	document.getElementById("result").innerHTML = 'You will save $' + y + ' in tuition, but it is important to remember this is going off of the example Rubio gave and in theory the investor could ask for a completely different amount.';
}

function calculateOmalley() {
	//varibles being declared
		var y = document.getElementById("t").value;
		var h = document.getElementById("yourstate").value;
		var income = h;
	switch(h) {
		case 'Alabama':
			income = 43330;
			break;
		case 'Alaska':
			income = 61749;
			break;
		case 'Arizona':
			income = 49698;
			break;
		case 'Arkansas':
			income = 40877;
			break;
		case 'California':
			income =57161;
			break;
		case 'Colorado':
			income = 61634;
			break;
		case 'Connecticut':
			income = 67807;
			break;
		case 'Delaware':
			income = 54377;
			break;
		case 'District Of Columbia':
			income = 61229;
			break;
		case 'Flordia':
			income = 47106;
			break;
		case 'Georgia':
			income = 47753;
			break;
		case 'Hawaii':
			income = 60814;
			break;
		case 'Idaho':
			income = 49952;
			break;
		case 'Illinois':
			income = 54083;
			break;
		case 'Indiana':
			income =48178;
			break;
		case 'Iowa':
			income = 53364;
			break;
		case 'Kansas':
			income =49804;
			break;
		case 'Kentucky':
			income = 42260;
			break;
		case 'Louisiana':
			income = 40844;
			break;
		case 'Maine':
			income = 50688;
			break;
		case 'Maryland':
			income = 69518;
			break;
		case 'Massachusetts':
			income = 64555;
			break;
		case 'Michigan':
			income = 49902;
			break;
		case 'Minnesota':
			income = 59847;
			break;
		case 'Mississippi':
			income = 40338;
			break;
		case 'Missouri':
			income = 49290;
			break;
		case 'Montana':
			income = 43924;
			break;
		case 'Nebraska':
			income = 55107;
			break;
		case 'Nevada':
			income = 49204;
			break;
		case 'New Hampshire':
			income = 69888;
			break;
		case 'New Jersey':
			income = 65321;
			break;
		case 'New Mexico':
			income = 44472;
			break;
		case 'New York':
			income = 51962;
			break;
		case 'North Carolina':
			income = 44254;
			break;
		case 'North Dakota':
			income = 55583;
			break;
		case 'Ohio':
			income = 46672;
			break;
		case 'Oklahoma':
			income = 47282;
			break;
		case 'Oregon':
			income = 54066;
			break;
		case 'Pennsylvania':
			income = 52481;
			break;
		case 'Rhode Island':
			income = 55158;
			break;
		case 'South Carolina':
			income = 43718;
			break;
		case 'South Dakota':
			income= 50488;
			break;
		case 'Tennessee':
			income= 42785;
			break;
		case 'Texas':
			income= 51752;
			break;
		case 'Utah':
			income = 60053;
			break;
		case 'Vermont':
			income= 56175;
			break;
		case 'Virginia':
			income = 65635;
			break;
		case 'Washington':
			income = 60520;
			break;
		case 'West Virginia':
			income = 43361;
			break;
		case 'Wisconsin':
			income = 54205;
			break;
		case 'Wyoming':
			income = 56569;
			break;
	}
	result = y - income * .1;
	result = Math.round(result);
	document.getElementById("result").innerHTML = "You would save $" + result + " in tuition.";
}

