function createCamera() {
    'use strict';

    var aspect = window.innerWidth / window.innerHeight;
    //camera = new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 1, 2000 );

    cameras = [

       new THREE.OrthographicCamera( frustumSize * aspect / - 5, frustumSize * aspect / 5, frustumSize / 5, frustumSize / -5, 1, 2000 ),

       new THREE.PerspectiveCamera(110, window.innerWidth / window.innerHeight, 1, 1000),

       new THREE.PerspectiveCamera(90, window.innerWidth / window.innerHeight, 1, 1000),

       new THREE.OrthographicCamera(frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 1, 2000)

    ];

      cameras[0].position.x = 0;
      cameras[0].position.y = 80;
      cameras[0].position.z = 0;
      cameras[0].lookAt(scene.position);
      scene.add(cameras[0]);

      cameras[1].position.x = 10;
      cameras[1].position.y = 60;
      cameras[1].position.z = 20;
      cameras[1].lookAt(scene.position);
      scene.add(cameras[1]);

      cameras[2].position.x = balls[0].position.x + 10;
      cameras[2].position.y = balls[0].position.y + 10;
      cameras[2].position.z = balls[0].position.z + 10;
      cameras[2].lookAt(balls[0].position);

      cameras[3].position.x = 0;
      cameras[3].position.y = 0;
      cameras[3].position.z = 80;
      cameras[3].lookAt(scene.position);
      scene.add(cameras[2]);



      scene.activeCamera = cameras[0];
}
