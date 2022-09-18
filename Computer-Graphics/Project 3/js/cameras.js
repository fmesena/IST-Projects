function createCamera() {
    'use strict';

    var aspect = window.innerWidth / window.innerHeight;
    //camera = new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 1, 2000 );

    cameras = [

      new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000),

      new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000),

      new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000),

      new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000)
    ];

      cameras[0].position.x = 150;
      cameras[0].position.y = 150;
      cameras[0].position.z = 150;
      cameras[0].lookAt(scene.position);
      scene.add(cameras[0]);

      cameras[1].position.x = -70;
      cameras[1].position.y = 40;
      cameras[1].position.z = 70;
      cameras[1].lookAt(scene.position);
      scene.add(cameras[1]);

      cameras[2].position.x = 50;
      cameras[2].position.y = 40;
      cameras[2].position.z = 0;
      cameras[2].lookAt(scene.position);
      scene.add(cameras[2]);



      scene.activeCamera = cameras[0];
}
