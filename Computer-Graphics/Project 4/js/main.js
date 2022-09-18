/*global THREE, requestAnimationFrame, console*/

var cameras, scene, renderer, geometry, material, dt;
var sun, pointlight, ball, rubik, board;

var all_mesh = [];

var board_scene, pause_scene;
var pauseMesh;

var cam_direction = new THREE.Vector3(1, 1, 1);

var frustumSize = 200;
var aspect = window.innerWidth / window.innerHeight;

var basicOn = false;

var clock = new THREE.Clock(true);
var go = false;
var max_speed = 1;
var y = new THREE.Vector3(0, 1, 0);
var pause = false;

var movementRadius = 26;

var controls;


//----------------------------------------------------------------------//

function createSun(){
	'use strict';

	sun = new THREE.DirectionalLight(0xffffff, 1)
	sun.position.set(1, 1, 0.5);
	sun.target.position.set(0, 0, 0);
	sun.visible = true;
	sun.castShadow = true;
	board_scene.add(sun);
}


function createPointLight(){
	'use strict';

	pointlight = new THREE.PointLight(0xffffff, 0.8, 80, 2);
	pointlight.position.set(10, 10, 10);
	pointlight.visible = true;
	board_scene.add(pointlight);
}

function createPauseScene(){
	pause_scene = new THREE.Scene();

	pauseObject = new PauseObject(0, 0, 0);
	
	pause_scene.add(pauseObject);

}

function createBoardScene(){
	board_scene = new THREE.Scene();

	board = new ChessBoard(0, 0, 0);
	ball  = new PoolBall(movementRadius, 6, 0, 6, new THREE.Vector3(0, 0, -1), 0);
	rubik = new RubikCube(0, 6, 0);

	createSun();
	createPointLight();

	board_scene.add(board, ball, rubik);
}


function createScenes() {
	'use strict';

	createBoardScene();
	createPauseScene();
}


function onKeyDown(e) {
    'use strict';

    if (e.keyCode == 83) {
		pause = !pause;
		controls.enabled = !controls.enabled;
		return;
	}

    if (e.keyCode == 82)     // R - Refresh
    	if (pause) { 
	    	createScenes();
			createCameras();
			render(board_scene);
			pause = false;
			go = false;
			basicOn = false;
			return;
    	}

    if (!pause) {
	    switch (e.keyCode) {
	    case 87: 		// W - wireframe
	        for (var i = all_mesh.length - 1; i >= 0; i--) {
	        	all_mesh[i].wireframe = !all_mesh[i].wireframe;
	        }
	        break;
	    case 66: 		// B - ball movement
	    	go = !go;
	    	break;
	    case 49:
	        scene.activeCamera = cameras[0];
	        break;
	    case 50:
	        scene.activeCamera = cameras[1];
	        break;
	    case 68:  		// D - on/off directional light
	        sun.visible = !sun.visible;       
	        break;
	    case 76: 		// L - sem iluminação, BasicMaterial
	        if(basicOn){
	        	rubik.changeToPhong();
	        	board.changeToPhong();
	        	ball.changeToPhong();
	        	basicOn = false;
	        }
	        else{
	        	rubik.changeToBasic();
	        	board.changeToBasic();
	        	ball.changeToBasic();
	        	basicOn = true;
	        }
	        break;
	    case 80: 		// P - on/off point light
	    	pointlight.visible = !pointlight.visible;
	        break;
		}
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


function onWindowResize() {
	'use strict'

	aspect = window.innerWidth / window.innerHeight;
	var aspect = window.innerWidth / window.innerHeight;
  	renderer.setSize( window.innerWidth, window.innerHeight );

	if (aspect > 1) {
		cameras[1].left   = -frustumSize * aspect / 5;
		cameras[1].right  =  frustumSize * aspect / 5;
		cameras[1].top    =  frustumSize / 5;
		cameras[1].bottom = -frustumSize / 5;
	}

  else {
	cameras[1].left   = -frustumSize / 5;
	cameras[1].right  =  frustumSize / 5;
	cameras[1].top    =  frustumSize / (aspect * 5);
	cameras[1].bottom = -frustumSize / (aspect * 5);
  }

  cameras[1].updateProjectionMatrix();

  if (window.innerHeight > 0 && window.innerWidth > 0) {
      cameras[0].aspect = window.innerWidth / window.innerHeight;
      cameras[0].updateProjectionMatrix();
    }



  for (var i = 0; i < 2; i++)
	if (window.innerHeight > 0 && window.innerWidth > 0) {
	  cameras[i].aspect = window.innerWidth / window.innerHeight;
	  cameras[i].updateProjectionMatrix();
	}
}


function init() {
	'use strict';

	renderer = new THREE.WebGLRenderer({
		antialias: true
	});
	renderer.setSize(window.innerWidth, window.innerHeight);
	document.body.appendChild(renderer.domElement);

	createScenes();
	createCameras();

	render(board_scene);

	window.addEventListener("keydown", onKeyDown);
	window.addEventListener("keyup", onKeyUp);
	window.addEventListener("resize", onWindowResize);
}


function update() {
	'use strict'

	if (!pause){
		ball.update();
		controls.update();
	}
}


function render(scene) {
	'use strict';

	renderer.render(scene, scene.activeCamera);
}


function animate() {
	'use strict';

	dt = clock.getDelta();

	update();

	if(pause)
		render(pause_scene);
	else
		render(board_scene);

	requestAnimationFrame(animate);
}
