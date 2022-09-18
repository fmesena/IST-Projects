var time_timeout;
var time_timeout_locked;
var mouse_is_down = false;
var turnedON = false;
var current_i = 0;
var index = 0;
var a = 0;
var menuIndex = 1;
var locked = false;
var black_screen = false;
var current_div;
var current_background = "#001a4d";
var menuBackground;
var numberOfFriends = 0;
var canAddFriend = 0;
var friendToRemove;
var interval;
var alertType;
var alertOn = 0;
var numberOfProductsD = 0;
var numberOfProductsF = 0;
var priceATM;
var SoundATM;
var globalPin = [];
var story = [];
var posTop = 20;
var posLeft = 30;
var pinLeft;
var pinTop;
var defaultHeart = [
            110, 89, 150, 117, 143, 95, 144, 200,
            177, 149, 134, 105, 123, 82, 72, 182,
            116, 159, 150, 121];
var glicemia = [
            70, 89, 145, 117, 143, 95, 74, 86,
            111, 124, 88, 105, 123, 79, 91, 140,
            109, 100, 83, 100];
var defaultAlcohol = [0.2, 0.23, 0.15, 0.7, 1.1, 0.62,
			0.44, 0.33, 0.27, 0.98, 0.77, 0.56,
			0.44, 0.2, 1.05, 0.79, 0.83, 0.67,
			0.19, 0.55];

var defaultBloodPressure = [[128, 80], [126, 82], [125, 89], [134, 79], [131, 81], [133, 82], [140, 85], [91, 70],
					[110, 71], [141, 92], [145, 96], [150, 93], [151, 99], [141, 94], [85, 59], [89, 53], [87, 52],
					[140, 92], [146, 91], [141, 90]];

var highHeart = [130, 134, 140, 145, 160, 165, 170, 180, 155, 199, 203, 177,
				144, 164, 182, 170, 175, 188, 169, 189];
var highAlcohol = [0.55, 0.60, 0.80, 0.70, 0.75, 0.65, 0.64, 0.55, 0.98, 0.52,
				   0.51, 0.66, 0.77, 0.76, 0.80, 0.82, 0.71, 0.90, 0.74, 0.68];
var highBloodPressure = [[145, 95], [148, 97], [149, 93], [142, 92], [151, 99], [141, 94], [150, 93], [141, 92], [145, 96]
						[140, 92], [146, 91], [80, 55], [79, 50], [85, 58], [89, 59], [75, 40], [80, 50], [86, 53], [73, 45], [81, 50]];

var normalHeart = [103, 110, 118, 100, 104, 98, 103, 101, 115, 109, 103,
					111, 96, 94, 95, 90, 99, 126, 119, 102];

var normalAlcohol = [0.49, 0.45, 0.40, 0.38, 0.35, 0.30, 0.24, 0.20, 0.11, 0.02,
					0.23, 0.26, 0.33, 0.44, 0.48, 0.32, 0.15, 0.18, 0.09, 0.39];

var normalBloodPressure = [[130, 80], [131, 83], [129, 80], [135, 89], [125, 77], [120, 80], [115, 75], [110, 65],
							[120, 70], [100, 63], [105, 70], [124, 81], [118, 66], [123, 63], [95, 77], [105, 84], [110, 84], [135, 83], [132, 82], [133, 80]];

var heart = defaultHeart;
var alcohol = defaultAlcohol;
var bloodPressure = defaultBloodPressure;
var moveJump = 5;


var pedidoBebidas = [];
var pedidoComidas = [];


/*DEFINICOES FLAGS*/
var som = 1;
var ezUnlock = 1;
var notifications = 1;
/***********************/

var dumb = 1;




function iniciar(){
	loadAllRoomData(getData());
	var inter = setInterval(function(){changeColor()} , 200);
	setTimeout(function(){clearInterval(inter); changeToMenus();}, 1000);
	document.addEventListener("keydown", moveImage, false);
}

function changeColor(){
	var colors = ["aqua", "khaki", "skyblue", "cadetblue", "forestgreen", "palegreen", "firebrick", "tomato", "golden rod", "moccasin", "light gray"];
	var x = Math.floor((Math.random() * 10) + 1);
	var t = document.getElementById("titulo")
	t.style.color = colors[x];
}

function changeToMenus(){
	var r = document.getElementById("rave");
	r.style.display= "none";
	menuBackground = current_background;
	updateBackground('#001a4d');
	document.getElementById("MENUS").style.display = "block";
	showMenus();
	updateClock();
}

function updateBackground(color){
	current_background = color;
	menuBackground = current_background;
	var e = document.getElementsByClassName("raveUnlocked");
	var m = document.getElementsByClassName("menu");
	for(var i = 0; i < e.length; i++){
		e[i].style.backgroundColor = color;
	}
	//for(var f = 0; f < m.length; f++){
	//	m[f].style.backgroundColor = color;
	//2}
}

var bolasBonitas = ["&#9679;&#8226;&#8226;&#8226;&#8226;", "&#8226;&#9679;&#8226;&#8226;&#8226;", "&#8226;&#8226;&#9679;&#8226;&#8226;",
					"&#8226;&#8226;&#8226;&#9679;&#8226;", "&#8226;&#8226;&#8226;&#8226;&#9679;"];

function plusMenus(n){
	var menus = document.getElementsByClassName("menu");
	showMenus(menuIndex += n);
}

function showMenus(n){
	var i;
	var menus = document.getElementsByClassName("menu");
	if(n > menus.length){menuIndex = 1;}
	if(n< 1){
		menuIndex = menus.length;
	}
	console.log(menuIndex-1);
	changeTo(menus[menuIndex -1]);
	document.getElementById("bolas").innerHTML = bolasBonitas[menuIndex-1];
}

function changeTo(interface){
	var l = interface.classList;
	if(current_div != undefined){
		current_div.style.display = "none";
		if(current_div.className == "medsFeature"){
			document.getElementById("alert").style.display = "none";   //sair de uma feature dos medidores
		}
		else if(l[0] =="menu")
			document.getElementById("MENUS").style.display = "block";
	}

	current_div = interface;
	current_div.style.display = "block";
	showClock();
}

function showClock(){
	if(time_timeout != undefined)
		clearTimeout(time_timeout);
	updateClock();
}

function showLockedClock(){
	if(time_timeout != undefined)
		clearTimeout(time_timeout);
	updateLockedClock();
}
/*Funcao que atualiza o relogio de segundo em segundo*/
function updateClock() {
    var now = new Date();
    var min = now.getMinutes();
    var hor = now.getHours();
    var time = now.getHours();
    if(hor < 10){
    	time = "0" + hor;
    	console.log(time);
    }
    if (min < 10)
    	time += ":" + "0" + min;
    else
   		time +=  ':' + now.getMinutes();
	var l = current_div.classList;
	if(l[0] == "menu"){
		document.getElementById("MENUS").getElementsByClassName("time_unlock")[0].innerHTML = time;
	}
	else{
		if(current_div.getElementsByClassName("time_unlock").length > 0){
			current_div.getElementsByClassName("time_unlock")[0].innerHTML = time;
		}
	}
    time_timeout = setTimeout(updateClock, 1000);
}

function updateLockedClock(){
	var now = new Date();
    var min = now.getMinutes();
    if (min < 10)
    	time = now.getHours() + ":" + "0" + min;
    else
   		time = now.getHours() + ':' + now.getMinutes();
   	document.getElementById("unblocked").getElementsByClassName("time_lock")[0].innerHTML = time;
   	time_timeout_locked = setTimeout(updateLockedClock, 1000);
}

/*****************************************************/

/* Processo de bloqueio e desbloqueio do ecra*/
function lock_unlock(){
	if(locked && black_screen){
		unlock();
	}
	else if(locked && !black_screen){
		turnOffScreen();
	}
	else
		lock();

}

function turnOffScreen(){
	document.getElementById("unblocked").style.display = "none";
	document.getElementById("blocked").style.display = "block";
	black_screen = true;
	var sound = new Audio("sounds/lock.mp3");
	sound.play();
}
function lock(){
	if(som){
	var sound = new Audio("sounds/lock.mp3");
	sound.play();
	}
	locked = true;
	black_screen = true;
	current_div.style.display = "none";
	document.getElementById("blocked").style.display = "block";
	if(interval!= null){
		clearInterval(interval);
		document.getElementById("alert").style.display = "none";
	}
	if(current_div.classList[0] == "menu"){
		document.getElementById("MENUS").style.display = "none"
	}
	if(current_div.className =="medsFeature"){
		document.getElementById("RESULTS").style.display = "none"

	}
	if(som)
		stopAudio();
}

function unlock(){
	black_screen = false;
	document.getElementById("blocked").style.display = "none";
	document.getElementById("unblocked").style.display = "block";
	showLockedClock();
}
function easyUnlock(){
	console.log(current_div);
	document.getElementById("unblocked").style.display = "none";
	if(current_div.classList[0] == "menu"){
		document.getElementById("MENUS").style.display = "block"
	}
	if(current_div.className =="medsFeature"){
		document.getElementById("RESULTS").style.display = "block"
	}
	current_div.style.display = "block";
	if(alertOn){
		window[alertType]();
	}
	locked = false;
	clearTimeout(time_timeout_locked);
	if(som)
		restartAudio();

}
/*******************************************************/

/****************** Shows and Hides*******************/
function hideMenu(){
	current_div.style.display = "none";
	hideArrows();
	hideTime();
}

function hideArrows(){
	document.getElementsByClassName("prev")[0].style.display = "none";
	document.getElementsByClassName("next")[0].style.display = "none";
}
function showArrows(){
	document.getElementsByClassName("prev")[0].style.display = "block";
	document.getElementsByClassName("next")[0].style.display = "block";
}
function hideTime(){
	document.getElementById("time").style.display = "none";
}

function showTime(){
	document.getElementById("time").style.display = "block";
}

/************************ SOCIAL ************************/

function changeToSocial(){
  document.getElementById("MENUS").style.display = "none";
	var m = document.getElementById("SUBMENUSOCIAL");
	story.push(current_div);
	console.log(current_div);
	changeTo(m);
}

function changeToAddFriend(){
  var d = document.getElementById("FRIENDS_ADD");
	story.push(current_div);
  changeTo(d);
  canAddFriend = 1;
}

function changeToRemoveFriend(){
  var d = document.getElementById("FRIENDS_REMOVE");
	story.push(current_div);
  changeTo(d);
}

function changeToLocateFriend(){
  var d = document.getElementById("FRIENDS_LOCATE");
  story.push(current_div);
  changeTo(d);
}

function changeToOfferFriend(){
  var d = document.getElementById("FRIENDS_OFFER");
	story.push(current_div);
  changeTo(d);
}

function addFriend() {
  if(canAddFriend) {
    var input = document.getElementById("userInput").value;

    var tbody1 = document.getElementById("friendsRemoveBody");
    var tbody2 = document.getElementById("friendsLocateBody");
    var tbody3 = document.getElementById("friendsOfferBody");

    var row1 = tbody1.insertRow(numberOfFriends);
    row1.classList.add("body");
    row1.addEventListener("click", function(){confirmRemove(input);});

    var row2 = tbody2.insertRow(numberOfFriends);
    row2.classList.add("body");
    row2.addEventListener("click", function(){locateFriend();});

    var row3 = tbody3.insertRow(numberOfFriends);
    row3.classList.add("body");
    row3.addEventListener("click", function(){consumoOffer();});

    var cell1 = row1.insertCell(0);
    cell1.classList.add("cell100");
    cell1.innerHTML = input;

    var cell2 = row2.insertCell(0);
    cell2.classList.add("cell100");
    cell2.innerHTML = input;

    var cell3 = row3.insertCell(0);
    cell3.classList.add("cell100");
    cell3.innerHTML = input;

    var friend = document.getElementById("friendName");
    friend.innerHTML = input;

    var to = document.getElementById("FRIEND_ADDED");
    changeTo(to);

    canAddFriend = 0;
    numberOfFriends++;
  }
}

function confirmRemove(name) {
  friendToRemove = name;
  var d = document.getElementById("FRIENDS_REMOVE_ALERT");
  story.push(current_div);
  changeTo(d);
}

function removeFriend() {
  var tbody1 = document.getElementById("friendsRemoveBody");
  var tbody2 = document.getElementById("friendsLocateBody");
  var tbody3 = document.getElementById("friendsOfferBody");

  /*console.log(tbody1.rows[0].cells[0].innerHTML);
  console.log(name);*/

  for(var i = 0; i < numberOfFriends; i++)
    if (tbody1.rows[i].cells[0].innerHTML == friendToRemove) {
      tbody1.deleteRow(i);
      tbody2.deleteRow(i);
      tbody3.deleteRow(i);
      numberOfFriends--;
      break;
    }

  back();
}



function locateFriend() {
	var locations = ['P1', 'P2', 'P3', 'P4', 'P5'];
	var x = Math.floor(Math.random() * 4);
	var d = document.getElementById("SUBMENUMAPA");
	changeTo(d);
	selectRoom(locations[x]);
	back();
}


/************************ MEDIDORES ************************/

function changeToMeds(){
	document.getElementById("MENUS").style.display = "none";
	var m = document.getElementById("SUBMENUMEDS");
	story.push(current_div);
	console.log(current_div);
	changeTo(m);
}

function openHeartRate(){
	document.getElementById("RESULTS").style.display = "block";
	var d = document.getElementById("HEARTRATERESULTS");
	story.push(current_div);
	if(showResults(heart, d, document.getElementById("BPM")) > 120){
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "#EF0000";
		dangerAlert();
		alertType = "dangerAlert";
		alertOn=1;
	}
	else{
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "184E1A";
		goodAlert();
		alertType= "goodAlert";
		alertOn = 1;
	}
}

function showResults(values, Totaldiv, div){
    var x = Math.floor((Math.random() * 20));
    if(div == bp1){
    	div.innerHTML = values[x][0];
    	document.getElementById("bp2").innerHTML = values[x][1];
    }
    else{
    	div.innerHTML = values[x];
    }
    changeTo(Totaldiv);
    return values[x];

}

function dangerAlert(){
	var visible = 0;
	var d = document.getElementById("alert_img");
	d.src="icons/danger.png";
	document.getElementById("alert").style.display = "none";
	interval = setInterval(function(){visible = showAlert(visible)} ,500);
	if(som){
		SoundATM = new Audio("sounds/alarm.mp3");
		SoundATM.play();
		SoundATM.loop = true;
	}
}

function goodAlert(){
	var d = document.getElementById("alert_img");
	d.src="icons/good.png";
	document.getElementById("alert").style.display = "block";
	if(som){
		SoundATM = new Audio("sounds/good.mp3");
		SoundATM.play();
	}
}

function showAlert(visible){
	if(visible){
		document.getElementById("alert").style.display = "none";
		visible = 0;
	}
	else{
		document.getElementById("alert").style.display = "block";
		visible = 1;
	}
	return visible;
}

function openGlicemia(){
  var i = document.getElementById("RESULTS");
  i.style.backgroundColor = "#001a4d";
	document.getElementById("RESULTS").style.display = "block";
	var d = document.getElementById("GLICEMIARESULTS");
	story.push(current_div);
	showResults(glicemia, d, mg_dl);
}

function openAlcohol(){
	document.getElementById("RESULTS").style.display = "block";
	var d = document.getElementById("ALCOHOLRESULTS");
	story.push(current_div);
	if((showResults(alcohol, d, document.getElementById("g_l"))) > 0.5){
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "#EF0000";
		dangerAlert();
		alertType = "dangerAlert";
		alertOn=1;
	}
	else{
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "184E1A";
		goodAlert();
		alertType= "goodAlert";
		alertOn = 1;
	}
}

function openBloodPressure(){
	document.getElementById("RESULTS").style.display = "block";
	var d = document.getElementById("BLOODPRESSSURERESULTS");
	story.push(current_div);
	var val = showResults(bloodPressure, BLOODPRESSSURERESULTS, bp1);
	if((val[0] > 140 && val[1] > 90) || (val[0] < 90 && val[1] < 60)){
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "#EF0000";
		dangerAlert();
		alertType = "dangerAlert";
		alertOn=1;
	}
	else{
    var i = document.getElementById("RESULTS");
    i.style.backgroundColor = "184E1A";
		goodAlert();
		alertType= "goodAlert";
		alertOn = 1;
	}
}

/************************ RESTAURACAO ************************/

function changeToRest(){
	document.getElementById("MENUS").style.display = "none";
	var m = document.getElementById("SUBMENUFOOD");
	story.push(current_div);
	changeTo(m);
}
/********************ENCOMENDAR BEBIDAS************************/
function openBebidas(){
	var d = document.getElementById("DRINKS");
	//document.getElementById("rave").style.background = "beige"
	story.push(current_div);
	changeTo(d);
}
function orderQuantity_d(produto, price){
	priceATM = price;
	var d = document.getElementById("ORDER_D");
	var m = document.getElementById("produto_d");
	var q = document.getElementById("quantidade_d");
	var flag = 0;
	console.log(m);
	story.push(current_div);
	for (var i = pedidoBebidas.length - 1; i >= 0; i--) {
		console.log(pedidoBebidas[i][0])
		console.log(produto);
		if(pedidoBebidas[i][0] == produto){
			q.innerHTML = pedidoBebidas[i][1];
			flag = 1;
		}
	}
	if(q.innerHTML == 0){
		var p = document.getElementById("minus_d");
		p.style.display = "none";
	}
	else if(q.innerHTML > 0){
		var p = document.getElementById("minus_d");
		p.style.display = "block";
	}
	changeTo(d);
	m.innerHTML = produto;
}
function plusOne_d(){
	var d = document.getElementById("quantidade_d");
	if(d.innerHTML == 0){
		var p = document.getElementById("minus_d");
		p.style.display = "block";
	}
	d.innerHTML++;
}
function minusOne_d(){
	var d = document.getElementById("quantidade_d");
	if(d.innerHTML == 1){
		var p = document.getElementById("minus_d");
		p.style.display = "none";
	}
	d.innerHTML--;
}
function openOffers_d(){
	var d = document.getElementById("OFFER_CART");
	story.push(current_div);
	changeTo(d);

}

function backOrder_d(){
	console.log(priceATM);
	var d = document.getElementById("quantidade_d");
	var m = document.getElementById("produto_d");
	var flag  = 0;
	var tbody = document.getElementById("listOfPurchases_d");
	var l = 0;
	if(d.innerHTML != 0){
		if(pedidoBebidas != null){
			for (var i = pedidoBebidas.length - 1; i >= 0; i--) {
				if(pedidoBebidas[i][0] == m.innerHTML){
					pedidoBebidas[i][1] = parseInt(d.innerHTML);
					console.log("ENTREI AQUI");
					tbody.rows[i].cells[1] = pedidoBebidas[i][1];
					tbody.rows[i].cells[2].innerHTML = (parseInt(d.innerHTML) * parseFloat(pedidoBebidas[i][2])).toFixed(2);
					console.log(tbody.rows[i].cells[2]);
					flag = 1;
				}
			}
			if(!flag){
				pedidoBebidas.push([m.innerHTML, d.innerHTML, priceATM]);
				var row = tbody.insertRow(numberOfProductsD);
				row.classList.add("body");
				var cell1 = row.insertCell(0);
				cell1.innerHTML = m.innerHTML;
				cell1.classList.add("cell100");
				cell1.classList.add("column1");
				cell1.classList.add("prodCart");
				var cell2 = row.insertCell(1);
				cell2.classList.add("cell100");
				cell2.classList.add("column2");
				cell2.classList.add("prodCart");
				cell2.innerHTML = d.innerHTML;
				var cell3 = row.insertCell(2);
				cell3.classList.add("cell100");
				cell3.classList.add("column3");
				cell3.classList.add("prodCart");
				cell3.innerHTML = (d.innerHTML*priceATM).toFixed(2);
				numberOfProductsD++;
				console.log( "guardei nesta row", m.innerHTML);
				var d = m.innerHTML;
				row.addEventListener("click", function(){ orderQuantity_d(d, priceATM);});
			}
			else{ //QUANDO SE ALTERA PARA 0 E DEPOIS OK
				var table = document.getElementById('listOfPurchases_d');
    			for (var r = 0, n = table.rows.length; r < n; r++) {
    				if(table.rows[r].cells[0].innerHTML == m.innerHTML){
    					table.rows[r].cells[1].innerHTML = d.innerHTML;
    					if(table.rows[r].cells[1].innerHTML == 0){
    						console.log("eeee");
    						table.deleteRow(r);
    						numberOfProductsD--;
    						n--;
    						updateTotal_d();
    					}
    				}
				}
			}
		}
	document.getElementById("quantidade_d").innerHTML = 0;
	updateTotal_d();
	}
	else{
		for (var i = pedidoBebidas.length - 1; i >= 0; i--){
			if(pedidoBebidas[i][0] == m.innerHTML){
				pedidoBebidas.splice(i, 1);
				document.getElementById("listOfPurchases_d").deleteRow(i);
				numberOfProductsD--;
				updateTotal_d();
			}
		}
	}
	back();
}
function cancelPurchase_d(){
	if(numberOfProductsD != 0){
		var d = document.getElementById("CANCELPURCHASE_D");
		story.push(current_div);
		changeTo(d);
	}
	else{
		back();
		back();
	}
}

function restartPurchases_d(){
	deleteOrder_d();
}

function cancelOrder_d(){
	deleteOrder_d();
	back();
}
function deleteOrder_d(){
	var table = document.getElementById("listOfPurchases_d");
	var i = 0;
	while(i != numberOfProductsD){
		table.deleteRow(0);
		i++;
	}
    pedidoBebidas = [];
  	numberOfProductsD = 0;
  	updateTotal_d();
}

function showCart_d(){
	var d = document.getElementById("CART_TOTAL_D");
	story.push(current_div);
	changeTo(d);
	updateTotal_d();
	if(numberOfProductsD == 0){
		document.getElementById("checkPurchase_d").style.display = "none";
	}
	else
		document.getElementById("checkPurchase_d").style.display = "block";
}
 function updateTotal_d(){
 	var total = 0;
 	var table = document.getElementById('listOfPurchases_d');
    if(numberOfProductsD != 0){
    	for (var r = 0, n = table.rows.length; r < n; r++) {
    		total = (parseFloat(total) + parseFloat(table.rows[r].cells[2].innerHTML)).toFixed(2);
 		}
 		total+='€';
 		document.getElementById("total_pagar_d").innerHTML = total;
 		document.getElementById("table_total_d").style.display = "block";
 		document.getElementById("checkPurchase_d").style.display = "block";

 	}
 	else{
 		total = 0;
 		document.getElementById("total_pagar_d").innerHTML = total;
 		document.getElementById("table_total_d").style.display = "none";
 		document.getElementById("checkPurchase_d").style.display = "none";
 	}
 }

/*******************************************************************************/

/*******************************************************************************/
/****************************ENCOMENAR COMIDA***********************************/
/*******************************************************************************/

function openComidas(){
	var d = document.getElementById("FOOD");
	story.push(current_div);
	changeTo(d);
}

function orderQuantity_f(produto, price){
	priceATM = price;
	var d = document.getElementById("ORDER_F");
	var m = document.getElementById("produto_f");
	var q = document.getElementById("quantidade_f");
	var flag = 0;
	console.log(m);
	story.push(current_div);
	for (var i = pedidoComidas.length - 1; i >= 0; i--) {
		console.log(pedidoComidas[i][0])
		console.log(produto);
		if(pedidoComidas[i][0] == produto){
			q.innerHTML = pedidoComidas[i][1];
			flag = 1;
		}
	}
	if(q.innerHTML == 0){
		var p = document.getElementById("minus_f");
		p.style.display = "none";
	}
	else if(q.innerHTML > 0){
		var p = document.getElementById("minus_f");
		p.style.display = "block";
	}
	changeTo(d);
	m.innerHTML = produto;
}

function plusOne_f(){
	var d = document.getElementById("quantidade_f");
	if(d.innerHTML == 0){
		var p = document.getElementById("minus_f");
		p.style.display = "block";
	}
	d.innerHTML++;
}
function minusOne_f(){
	var d = document.getElementById("quantidade_f");
	if(d.innerHTML == 1){
		var p = document.getElementById("minus_f");
		p.style.display = "none";
	}
	d.innerHTML--;
}
function openOffers_f(){
	var d = document.getElementById("OFFER_CART");
	story.push(current_div);
	changeTo(d);

}

function backOrder_f(){
	console.log(priceATM);
	var d = document.getElementById("quantidade_f");
	var m = document.getElementById("produto_f");
	var flag  = 0;
	var tbody = document.getElementById("listOfPurchases_f");
	var l = 0;
	if(d.innerHTML != 0){
		if(pedidoComidas != null){
			for (var i = pedidoComidas.length - 1; i >= 0; i--) {
				if(pedidoComidas[i][0] == m.innerHTML){
					pedidoComidas[i][1] = parseInt(d.innerHTML);
					console.log("ENTREI AQUI");
					tbody.rows[i].cells[1] = pedidoComidas[i][1];
					tbody.rows[i].cells[2].innerHTML = (parseInt(d.innerHTML) * parseFloat(pedidoComidas[i][2])).toFixed(2);
					console.log(tbody.rows[i].cells[2]);
					flag = 1;
				}
			}
			if(!flag){
				pedidoComidas.push([m.innerHTML, d.innerHTML, priceATM]);
				var row = tbody.insertRow(numberOfProductsF);
				row.classList.add("body");
				var cell1 = row.insertCell(0);
				cell1.innerHTML = m.innerHTML;
				cell1.classList.add("cell100");
				cell1.classList.add("column1");
				cell1.classList.add("prodCart");
				var cell2 = row.insertCell(1);
				cell2.classList.add("cell100");
				cell2.classList.add("column2");
				cell2.classList.add("prodCart");
				cell2.innerHTML = d.innerHTML;
				var cell3 = row.insertCell(2);
				cell3.classList.add("cell100");
				cell3.classList.add("column3");
				cell3.classList.add("prodCart");
				cell3.innerHTML = (d.innerHTML*priceATM).toFixed(2);
				numberOfProductsF++;
				console.log( "guardei nesta row", m.innerHTML);
				var d = m.innerHTML;
				row.addEventListener("click", function(){ orderQuantity_f(d, priceATM);});
			}
			else{ //QUANDO SE ALTERA PARA 0 E DEPOIS OK
				var table = document.getElementById('listOfPurchases_f');
    			for (var r = 0, n = table.rows.length; r < n; r++) {
    				if(table.rows[r].cells[0].innerHTML == m.innerHTML){
    					table.rows[r].cells[1].innerHTML = d.innerHTML;
    					if(table.rows[r].cells[1].innerHTML == 0){
    						console.log("eeee");
    						table.deleteRow(r);
    						numberOfProductsF--;
    						n--;
    						updateTotal_f();
    					}
    				}
				}
			}
		}
	document.getElementById("quantidade_f").innerHTML = 0;
	updateTotal_f();
	}
	else{
		for (var i = pedidoComidas.length - 1; i >= 0; i--){
			if(pedidoComidas[i][0] == m.innerHTML){
				pedidoComidas.splice(i, 1);
				document.getElementById("listOfPurchases_f").deleteRow(i);
				numberOfProductsF--;
				updateTotal_f();
			}
		}
	}
	back();
}
function cancelPurchase_f(){
	if(numberOfProductsF != 0){
		var d = document.getElementById("CANCELPURCHASE_F");
		story.push(current_div);
		changeTo(d);
	}
	else{
		back();
		back();
	}
}

function restartPurchases_f(){
	deleteOrder_f();
}

function cancelOrder_f(){
	deleteOrder_f();
	back();
}
function deleteOrder_f(){
	var table = document.getElementById("listOfPurchases_f");
	var i = 0;
	while(i != numberOfProductsF){
		table.deleteRow(0);
		i++;
	}
    pedidoComidas = [];
  	numberOfProductsF = 0;
  	updateTotal_f();
}

function showCart_f(){
	var d = document.getElementById("CART_TOTAL_F");
	story.push(current_div);
	changeTo(d);
	updateTotal_f();
	if(numberOfProductsF == 0){
		document.getElementById("checkPurchase_f").style.display = "none";
	}
	else
		document.getElementById("checkPurchase_f").style.display = "block";
}
 function updateTotal_f(){
 	var total = 0;
 	var table = document.getElementById('listOfPurchases_f');
    if(numberOfProductsF != 0){
    	for (var r = 0, n = table.rows.length; r < n; r++) {
    		total = (parseFloat(total) + parseFloat(table.rows[r].cells[2].innerHTML)).toFixed(2);
 		}
 		total+='€';
 		document.getElementById("total_pagar_f").innerHTML = total;
 		document.getElementById("table_total_f").style.display = "block";
 		document.getElementById("checkPurchase_f").style.display = "block";

 	}
 	else{
 		total = 0;
 		document.getElementById("total_pagar_f").innerHTML = total;
 		document.getElementById("table_total_f").style.display = "none";
 		document.getElementById("checkPurchase_f").style.display = "none";
 	}
 }




/******************************************************************************/
function back(){
	if(!locked && !black_screen){
		if(current_div == document.getElementById("order")){
			document.getElementById("quantidade").innerHTML = 0;
		}
			if(current_div.className == "medsFeature"){
			document.getElementById("RESULTS").style.display = "none";
		}
		alertOn = 0;
		if(story.length != 0){
			changeTo(story[story.length-1]);
			story.pop();
		}
		if(interval!= null)
			clearInterval(interval);
	}
	stopAudio();
}
function stopAudio() {
    if(SoundATM != null){
    	SoundATM.pause();
    	SoundATM.currentTime = 0;
    }
}

function restartAudio(){
	if(SoundATM != null){
		SoundATM.play();
	}
}

function turn(){
	mouse_is_down = true;
	if(!turnedON)
		index =	setTimeout(function (){document.getElementById("rave").style.background = "grey"; turnedON = true; processing()}, 2500);
	else
		index =	setTimeout(function (){document.getElementById("rave").style.background = "black"; turnedON = false;}, 2500);

}

function func(){
    mouse_is_down = false;
    clearTimeout(index);
}


function changeToMaps(){
	document.getElementById("MENUS").style.display = "none";
	var m = document.getElementById("SUBMENUMAPA");
	story.push(current_div);
	changeTo(m);
}

function consumo(){
	document.getElementById("overlay").style.display = "block";
	deleteOrder_f();
	deleteOrder_d();
}

function consumoOffer(){
	document.getElementById("overlayOffer").style.display = "block";
	deleteOrder_f();
	deleteOrder_d();
}

function back_overlay(){
	document.getElementById("overlay").style.display = "none";
	back();
	back();
	back();
}

function back_overlayOffer(){
	document.getElementById("overlayOffer").style.display = "none";
	back();
	back();
	back();
  back();
}

function back_overlay_pop(){
	document.getElementById("overlay_pop_up").style.display = "none";
}

function showRequestReady(){
	if(notifications)
		document.getElementById("overlay_pop_up").style.display = "block";
}


/******************************DEFINIÇÕES***********************************/
function changeToSettings(){
	document.getElementById("MENUS").style.display = "none";
	var m = document.getElementById("SUBMENUDEFINICOES");
	story.push(current_div);
	changeTo(m);
}

function switchSetting(div){
	var d = div.id;
	switch(d){
		case "switchSom":
			if(som == 1){
				som = 0;
				div.src = "icons/switchOFF.png";
			}
			else{
				som = 1;
				div.src = "icons/switchOn.png";
			}
		case "switchUnlock":
			if(ezUnlock == 1){
				ezUnlock = 0;
				div.src = "icons/switchOFF.png";
			}
			else{
				ezUnlock = 1;
				div.src = "icons/switchOn.png";
			}
		case "switchNotifications":
			if(notifications == 1){
				notifications = 0;
				div.src = "icons/switchOff.png";
			}
			else{
				notifications = 1;
				div.src = "icons/switchOn.png";
			}
	}

}

/****************************** EXTRA BUTTONS ******************************/
function highMedsValues(){
	heart = highHeart;
	alcohol = highAlcohol;
	bloodPressure = highBloodPressure;
}

function normalMedsValues(){
	heart = normalHeart;
	bloodPressure = normalBloodPressure;
	alcohol = normalAlcohol;
}

function defaultMedsValues(){
	heart = defaultHeart;
	bloodPressure = defaultBloodPressure;
	alcohol = defaultAlcohol;
}




/*          MAPS        */


function loadAllRoomData(roomData) {
  sessionStorage.setItem("AllRoomData", JSON.stringify(roomData));
}


function getRoomCoords(roomName) {
  roomData = JSON.parse(sessionStorage.getItem("AllRoomData"));
  console.log(roomData);
  for(let i = 0; i < roomData.length; i++){
    if(roomData[i].roomname == roomName){
      return roomData[i].coords;
    }
    else
    	console.log("ggfgfg");
  }
}

function selectRoom(roomName) {
  sessionStorage.setItem("roomName", roomName);
  coords = getRoomCoords(roomName);
  console.log(roomName);
  console.log(coords);
  setLocationPin(coords[0], coords[1], coords[2], coords[3]);
}

function setLocationPin(x1, y1, x2, y2) {
  pinLeft = x1 + (x2 - x1) / 2.0 - 45;
  pinTop = y1 + (y2 - y1) / 2.0 - 45;
  document.getElementById("target").style.left = pinLeft;
  document.getElementById("target").style.top=pinTop;
  document.getElementById("target").style.visibility = "visible";
  updateArrow();
}


function removeElement(id) {
    var node = document.getElementById(id);
    node.parentNode.removeChild(node);
}


function drag(target, e) {
  pid = target.parentNode.id;
  clone = target.cloneNode(true);
  e.dataTransfer.setData('SpanImg', target.id);
}


function drop(target, e, roomName) {
  target.appendChild(clone);
  removeElement(e.dataTransfer.getData('SpanImg'));
  selectRoom(roomName);
}





function on() {
    document.getElementById("overlay_map").style.display = "block";
    document.getElementById("Trackers").style.display = "block";
    document.getElementById("MapOptions").style.display = "none";
}

function off() {
    document.getElementById("overlay_map").style.display = "none";
    document.getElementById("Trackers").style.display = "none";
    document.getElementById("MapOptions").style.display = "block";
}


function searchBar() {

}

function findFriend() {
	changeToLocateFriend();
}

function searchStages(){
	var d = document.getElementById("STAGESTOFIND");
	changeTo(d);
}

function showStage(stage){
	var d = document.getElementById("SUBMENUMAPA");
	changeTo(d);
	selectRoom(stage);
}

function searchBar(){
	var d = document.getElementById("BARSTOFIND");
	changeTo(d);
}

function showBar(bar){
	var d = document.getElementById("SUBMENUMAPA");
	changeTo(d);
	selectRoom(bar);
}

function chooseWC(){
	var m = document.getElementById("WC_ESCOLHER");
	//story.push(current_div);
	changeTo(m);
}

function emptyWC(){
	var wcs = ['WC1', 'WC2', 'WC3'];
	var x = Math.floor(Math.random() * (2 - 0 + 1) ) + 0;
	var d = document.getElementById("SUBMENUMAPA");
	changeTo(d);
	selectRoom(wcs[x]);
}


function component(width, height, color, x, y, type) {
    this.type = type;
    if (type == "image") {
        this.image = new Image();
        this.image.src = color;
    }
    this.width = width;
    this.height = height;
    this.speedX = 0;
    this.speedY = 0;
    this.x = x;
    this.y = y;
    this.update = function() {
        ctx = myGameArea.context;
        if (type == "image") {
            ctx.drawImage(this.image,
                this.x,
                this.y,
                this.width, this.height);
        } else {
            ctx.fillStyle = color;
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    }
    this.newPos = function() {
        this.x += this.speedX;
        this.y += this.speedY;
    }
}

function moveImage(e) {
	var img = document.getElementById('whereIam');
	var arrow = document.getElementById("arrow");
    var kc = e.keyCode;

    var top = parseInt(img.style.top.substr(0, img.style.top.length - 2));
    var left = parseInt(img.style.left.substr(0, img.style.left.length - 2));

    switch (kc) {
        case 37:
            img.style.left = (left - moveJump) + 'px';
            arrow.style.left = (left - moveJump) + 'px';
            updateArrow();
            break;
        case 38:
            img.style.top = (top - moveJump) + 'px';
            arrow.style.top = (top - moveJump) + 'px';
            updateArrow();
            break;
        case 39:
            img.style.left = (left + moveJump) + 'px';
            arrow.style.left = (left + moveJump) + 'px';
            updateArrow();
            break;
        case 40:
            img.style.top = (top + moveJump) + 'px';
            arrow.style.top = (top + moveJump) + 'px';
            updateArrow();
            break;
    }
}


function updateArrow() {

	var arrow = document.getElementById("arrow");
	var pin = document.getElementById("target");
	var me = document.getElementById("whereIam");

	var x = Math.abs(parseInt(pin.style.top) - parseInt(me.style.top));
	var y = Math.abs(parseInt(pin.style.left) - parseInt(me.style.left));

	var alfa = Math.atan(x / y) * 180 / Math.PI;

	if (parseInt(pin.style.left) >= parseInt(me.style.left) && parseInt(pin.style.top) <= parseInt(me.style.top)){
		arrow.style.transform = "rotate(" + (alfa * (-1)) + "deg)";
	}

	if (parseInt(pin.style.left) <= parseInt(me.style.left) && parseInt(pin.style.top) <= parseInt(me.style.top)){
		arrow.style.transform = "rotate(" + ((180-alfa) * (-1)) + "deg)";
	}

	if (parseInt(pin.style.left) <= parseInt(me.style.left) && parseInt(pin.style.top) >= parseInt(me.style.top)){
		arrow.style.transform = "rotate(" + ((180+alfa) * (-1)) + "deg)";
	}

	if (parseInt(pin.style.left) >= parseInt(me.style.left) && parseInt(pin.style.top) >= parseInt(me.style.top)){
		arrow.style.transform = "rotate(" + ((alfa) * (1)) + "deg)";
	}
}


function closerWC() {

	var me  = document.getElementById("whereIam");
	sessionStorage.setItem("roomName", 'WC1');
	sessionStorage.setItem("roomName", 'WC2');
	sessionStorage.setItem("roomName", 'WC3');
  	var wc1 = getRoomCoords('WC1');
  	var wc2 = getRoomCoords('WC2');
  	var wc3 = getRoomCoords('WC3');

	var x1 = Math.abs(parseInt(wc1[0]) - parseInt(me.style.top));
	var y1 = Math.abs(parseInt(wc1[1]) - parseInt(me.style.left));

	var x2 = Math.abs(parseInt(wc2[0]) - parseInt(me.style.top));
	var y2 = Math.abs(parseInt(wc2[1]) - parseInt(me.style.left));

	var x3 = Math.abs(parseInt(wc3[0]) - parseInt(me.style.top));
	var y3 = Math.abs(parseInt(wc3[1]) - parseInt(me.style.left));

	var d = document.getElementById("SUBMENUMAPA");
	changeTo(d);

	if ( Math.sqrt( (Math.pow(x1, 2) + Math.pow(y1, 2)) ) < Math.sqrt( (Math.pow(x2, 2) + Math.pow(y2, 2)) ) )
		if ( Math.sqrt( (Math.pow(x1, 2) + Math.pow(y1, 2)) ) < Math.sqrt( (Math.pow(x3, 2) + Math.pow(y3, 2)) ) )
			selectRoom("WC1");

	if ( Math.sqrt( (Math.pow(x2, 2) + Math.pow(y2, 2)) ) < Math.sqrt( (Math.pow(x3, 2) + Math.pow(y3, 2)) ) )
		if ( Math.sqrt( (Math.pow(x2, 2) + Math.pow(y2, 2)) ) < Math.sqrt( (Math.pow(x1, 2) + Math.pow(y1, 2)) ) )
			selectRoom("WC2");

	if ( Math.sqrt( (Math.pow(x3, 2) + Math.pow(y3, 2)) ) <= Math.sqrt( (Math.pow(x2, 2) + Math.pow(y2, 2)) ) )
		if ( Math.sqrt( (Math.pow(x3, 2) + Math.pow(y3, 2)) ) <= Math.sqrt( (Math.pow(x1, 2) + Math.pow(y1, 2)) ) )
			selectRoom("WC3");

}
