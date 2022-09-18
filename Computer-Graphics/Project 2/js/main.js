/*global THREE, requestAnimationFrame, console*/

var cameras, scene, renderer, geometry, mesh, material, field, ball;

var fieldX, diag, ballRadius, wallHeight;

var all_mesh = [];
var balls    = [];
var allAxis  = [];
var allObjects = [];

var forward, backwards, breakF, breakB;
var d;

var frustumSize = 200;
var verifiy_colision = 0;
var level = 5;
var colided = [];

const alfa 		= 3.14/100;
const max_speed = 1;
const NUM_BALLS = 10;
const fieldZ = 50;

fieldX = fieldZ*2;
wallHeight = Math.sqrt(fieldX**2 + fieldZ**2)/10;
ballRadius = wallHeight/2;

var clock = new THREE.Clock(true);
var level_change = new THREE.Clock(true);
var timer = 0;

var dt;



// ---------------------------------------------------------------- //


function createScene() {
    'use strict';

    scene = new THREE.Scene();

    //ball = new Ball(44.55, 27.95, 20.05);
    var x, z, dir, colided, positions

    for (var i = 0; i < NUM_BALLS; i++) {
        positions = createPosition()
        colided = createCollisions(positions, i)

        while(colided != 1){
            positions = createPosition()
            colided = createCollisions(positions, i)
        }

        dir = new THREE.Vector3(Math.random()*2 - 1, 0, Math.random()*2 - 1).normalize(); //randomizar valores de x e z
    	  var axis = new THREE.AxisHelper(10);

        if(i == 0)
            balls[i] = new Ball(positions[0], ballRadius + 2, positions[1], dir, dir, 0xFF00FF, THREE.Math.randFloat(1, 5));
        else
            balls[i] = new Ball(positions[0], ballRadius + 2, positions[1], dir, dir, 0xFFFF00, THREE.Math.randFloat(1, 5));

        balls[i].add(axis);
        allObjects.push(balls[i])
        allAxis.push(axis);
        scene.add(balls[i]);
    }
    field = new Field(0, 0, 0);
    scene.add(field, new THREE.AxisHelper(10));
}

function createPosition(){

    x = Math.random()*fieldX - fieldX/2;
    z = Math.random()*fieldZ - fieldZ/2;

    if(x < 0)
      x += ballRadius;

    else
      x -= ballRadius;

    if(z < 0)
      z += ballRadius;

    else
      z -= ballRadius;

    return [x, z];
}

function createCollisions(positions, i){
    var x = positions[0]
    var z = positions[1]

    for(var e = 0; e < i; e++){

      distance = (x - balls[e].getPositionX())**2 + (z - balls[e].getPositionZ())**2

        if(distance <= (2*ballRadius)**2){
          return 0
        }
    }

    return 1
}


function onKeyDown(e) {
    'use strict';

    switch (e.keyCode) {
    case 65: //A
    case 97: //a
        for (var i = all_mesh.length - 1; i >= 0; i--) {
        	all_mesh[i].wireframe = !all_mesh[i].wireframe;
        }
        break;
    case 83:  //S
    case 69:  //E
    case 101: //e
    	for (var i = allAxis.length - 1; i >= 0; i--) {
        	allAxis[i].visible = !allAxis[i].visible
        }
        break;
    case 49:
        scene.activeCamera = cameras[0];
        break;
    case 50:
        scene.activeCamera = cameras[1];
        break;
    case 51:
        scene.activeCamera = cameras[2];
        break;
    case 52:
        scene.activeCamera = cameras[3]
    case 37:
        break;
    case 38:
        break;
    case 39:
        break;
    case 40:
        break;
    }
}


function onKeyUp(e) {
    'use strict';

    switch (e.keyCode) {
    case 37:
        break;
    case 38:
        break;
    case 39:
        break;
    case 40:
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

  var i, j, xlook, ylook, zlook;

  dt = clock.getDelta();

  for (var i = 0; i < NUM_BALLS; i++)
    balls[i].previewPos();

  for (var i = 0; i < NUM_BALLS; i++)
    for (var j = i+1; j < NUM_BALLS+1; j++) {
        balls[i].hasColision(allObjects[j]);
    }

  for (i = 0; i < NUM_BALLS; i++) {
      balls[i].update();
  }

  cameras[2].lookAt(balls[0].position);
  cameras[2].position.x = balls[0].position.x + balls[0].getDirection().getComponent(0)*20*(-1);
  cameras[2].position.y = balls[0].position.y + 10;
  cameras[2].position.z = balls[0].position.z + balls[0].getDirection().getComponent(2)*20*(-1);

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

    timer += level_change.getDelta();

    if(timer > 30) {
      level = level*2;
      timer = 0;
    }

    update();

    render();

    requestAnimationFrame(animate);
}
