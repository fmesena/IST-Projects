/*global THREE, requestAnimationFrame, console*/

var cameras, scene, renderer, geometry, mesh, table, chair, lamp, support, material;
var all_mesh = [];

var frustumSize = 100;

var wew = new THREE.Vector3(0, 1, 0);
var d   = new THREE.Vector3(0, 0, -1);

const alfa 		= 3.14/100;
const max_speed = 1;

var clock = new THREE.Clock(true);

var forward, backwards, breakF, breakB, rotate_left, rotate_right, dt, rotate = 0;
var wheels = [];



// ---------------------------------------------------------------- //



function createScene() {
    'use strict';

    scene = new THREE.Scene();

    scene.add(new THREE.AxisHelper(10));

    var x = new THREE.AxisHelper(5);

    table = new Table(0, 21, 0);
    chair = new Chair(0, 11, 26, 0);
    lamp  = new Lamp(40, 0, 0);

    wheels[0].add(x);

    scene.add(table);
    scene.add(chair);
    scene.add(lamp);
}

function onResize() {
    'use strict';

    renderer.setSize(window.innerWidth, window.innerHeight);

    if (window.innerHeight > 0 && window.innerWidth > 0) {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
    }

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
        scene.traverse(function (node) {
            if (node instanceof THREE.AxisHelper) {
                node.visible = !node.visible;
            }
        });
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
        scene.activeCamera = cameras[3];
        break;
    case 37:
    	rotate_left = 1;
        break;
    case 38:
    	forward = 1;
    	breakF  = 0;
    	breakB  = 0;
        break;
    case 39:
        rotate_right = 1;
        break;
    case 40:
        backwards = 1;
        breakF  = 0;
    	breakB  = 0;
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
    	forward = 0;
    	backwards = 0;
    	breakF  = 1;
        break;
    case 39:
        rotate_right = 0;
        break;
    case 40:
        backwards = 0;
        forward = 0;
        breakB    = 1;
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
	//console.log(chair.getVelocity());
	chair.update();
}

function onWindowResize() {

	var aspect = window.innerWidth / window.innerHeight;

	for (var i = 0; i < 3; i++) {
		cameras[i].left   = -frustumSize * aspect / 2;
		cameras[i].right  =  frustumSize * aspect / 2;
		cameras[i].top    =  frustumSize / 2;
		cameras[i].bottom = -frustumSize / 2;
		cameras[i].updateProjectionMatrix();
	}

	renderer.setSize( window.innerWidth, window.innerHeight );

}

function animate() {
    'use strict';

    update();

    render();

    requestAnimationFrame(animate);
}
