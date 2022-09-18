function createCameras() {
    'use strict';

    aspect = window.innerWidth / window.innerHeight;

    cameras = [

      new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000),

      new THREE.OrthographicCamera(frustumSize * aspect / - 5, frustumSize * aspect / 5, frustumSize / 5, frustumSize / -5, 1, 2000)
    ];

      cameras[0].position.x = 50;
      cameras[0].position.y = 50;
      cameras[0].position.z = 50;
      cameras[0].lookAt(board_scene.position);
      cameras[0].isPerspectiveCamera = true;
      
      board_scene.add(cameras[0]);

      cameras[1].position.x = 0;
      cameras[1].position.y = 0;
      cameras[1].position.z = 30;
      cameras[1].lookAt(pause_scene.position);
      pause_scene.add(cameras[1]);

      board_scene.activeCamera = cameras[0];
      pause_scene.activeCamera = cameras[1];

      controls = new THREE.OrbitControls(cameras[0]);
      controls.maxPolarAngle = Math.PI/2;
      controls.enabled = true;
}

