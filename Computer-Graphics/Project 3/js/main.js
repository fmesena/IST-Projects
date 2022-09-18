/*global THREE, requestAnimationFrame, console*/

var cameras, scene, renderer, geometry, mesh, material;

var sun, airplane;
var lamps = [];
var Central_axis;
var HEIGHT = 200;
var SIDE = 40;

var lambert = new THREE.MeshLambertMaterial({color: 0x0033cc});
var phong = new THREE.MeshPhongMaterial({color: 0x0033cc});
var basic = new THREE.MeshBasicMaterial({color: 0xc0c0c0})
var previous_mesh;
var basic_active = 0;


var rotate_left, rotate_right, rotate_up, rotate_down = 0;


var frustumSize = 200;

const rotation 		= 10;

var clock = new THREE.Clock(true);

var dt;



// ---------------------------------------------------------------- //
function createSun(){
	

	sun = new THREE.DirectionalLight(0xffffff, 1)

	sun.castShadow = true;

}

function createScene() {
	'use strict';
	scene = new THREE.Scene();

  	airplane = new Airplane(0, 0, 0, HEIGHT, SIDE);
  	createSun();

  	//Lamp creations
  	var lamp1 = new Lamplight(0, 150, 150);
  	var lamp2 = new Lamplight(150, 150, 0);
  	var lamp3 = new Lamplight(0, 150, -150);
  	var lamp4 = new Lamplight(-150, 150, 0);
  	lamps.push(lamp1, lamp2, lamp3, lamp4);
  	
  
  	scene.add(sun, lamp1, lamp2, lamp3, lamp4, airplane);
   
}

function onKeyDown(e) {
	'use strict';

	switch (e.keyCode) {
	case 76: //l
		if(airplane.children[0].material instanceof THREE.MeshBasicMaterial){
			airplane.changeToPrevious();
			basic_active = 0;
		}

		else{
			airplane.changeToBasic();
			basic_active = 1;	
		}
	case 71:  //g
		if(basic_active)
			airplane.changePrevious();
		else
			airplane.changeMaterial();
		break;
	case 78: // n
		if(sun.intensity > 0)
			sun.intensity = 0;
		else if(sun.intensity == 0)
			sun.intensity = 2;
		break;
	case 101: //e
		break;
	case 49:
		if(lamps[0].getLightStatus())
			lamps[0].turnOff();
		else
			lamps[0].turnOn();
		break;
	case 50:
		if(lamps[1].getLightStatus())
			lamps[1].turnOff();
		else
			lamps[1].turnOn();
		break;
	case 51:
		if(lamps[2].getLightStatus())
			lamps[2].turnOff();
		else
			lamps[2].turnOn();
		break;
	case 52:
		if(lamps[3].getLightStatus())
			lamps[3].turnOff();
		else
			lamps[3].turnOn();
		break;
	case 53:
		scene.activeCamera = cameras[0];
		break;
	case 54:
		scene.activeCamera = cameras[1];
		break;
	case 55:
		scene.activeCamera = cameras[2];
		break;
	case 56:
		scene.activeCamera = cameras[3]
	case 37:
		rotate_left = 1;
		break;
	case 38:
		rotate_up = 1;
		break;
	case 39:
		rotate_right = 1;
		break;
	case 40:
		rotate_down = 1;
		break;
	}
}


function onKeyUp(e) {
	'use strict';

	switch (e.keyCode) {
	case 37:
		rotate_left = 0;
		break;
	case 38:
		rotate_up = 0;
		break;
	case 39:
		rotate_right = 0;
		break;
	case 40:
		rotate_down = 0;
		break;
	}

}

function render() {
	'use strict';

	renderer.render(scene, scene.activeCamera);
}

function init() {
	'use strict';

	renderer = new THREE.WebGLRenderer({
		antialias: true
	});
	renderer.setSize(window.innerWidth, window.innerHeight);
	document.body.appendChild(renderer.domElement);

	createScene();
	createCamera();

	render();

	window.addEventListener("keydown", onKeyDown);
	window.addEventListener("keyup", onKeyUp);
	window.addEventListener("resize", onWindowResize);
}

function update() {
	'use strict'
	airplane.update();

}



function onWindowResize() {
	'use strict'

	var aspect = window.innerWidth / window.innerHeight;
  renderer.setSize( window.innerWidth, window.innerHeight );

	if (aspect > 1) {
		cameras[0].left   = -frustumSize * aspect / 5;
		cameras[0].right  =  frustumSize * aspect / 5;
		cameras[0].top    =  frustumSize / 5;
		cameras[0].bottom = -frustumSize / 5;
	}

  else {
	cameras[0].left   = -frustumSize / 5;
	cameras[0].right  =  frustumSize / 5;
	cameras[0].top    =  frustumSize / (aspect * 5);
	cameras[0].bottom = -frustumSize / (aspect * 5);
  }

  cameras[0].updateProjectionMatrix();

  for (var i = 1; i < 3; i++)
	if (window.innerHeight > 0 && window.innerWidth > 0) {
	  cameras[i].aspect = window.innerWidth / window.innerHeight;
	  cameras[i].updateProjectionMatrix();
	}
}

function animate() {
	'use strict';

	dt = clock.getDelta();

	update();

	render();

	requestAnimationFrame(animate);
}
