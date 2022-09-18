function createCamera() {
    'use strict';

    var aspect = window.innerWidth / window.innerHeight;
    //camera = new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 1, 2000 );

    cameras = [

       // camera 1 will be the ortographic (top)
       //new THREE.OrthographicCamera(window.innerWidth / -20, window.innerWidth / 20, window.innerHeight / 20, window.innerHeight / -20, 1, 100),
       new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 0, 4000 ),
       // camera 2 will be the ortographic (back)
       //new THREE.OrthographicCamera(window.innerWidth / -20, window.innerWidth / 20, window.innerHeight / 20, window.innerHeight / -20, 1, 100),
       new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 0, 4000 ),
       // camera 3 will be the ortographic (side)
       //new THREE.OrthographicCamera(window.innerWidth / -20, window.innerWidth / 20, window.innerHeight / 20, window.innerHeight / -20, 1, 100),
       new THREE.OrthographicCamera( frustumSize * aspect / - 2, frustumSize * aspect / 2, frustumSize / 2, frustumSize / - 2, 0, 4000 ),
       // xxx
       new THREE.PerspectiveCamera(70, window.innerWidth / window.innerHeight, 1, 1000)

    ];

      cameras[0].position.x = 0;
      cameras[0].position.y = 400;
      cameras[0].position.z = 0;
      cameras[0].lookAt(scene.position);
      scene.add(cameras[0]);

      cameras[1].position.x = 400;
      cameras[1].position.y = 0;
      cameras[1].position.z = 0;
      cameras[1].lookAt(scene.position);
      scene.add(cameras[1]);

      cameras[2].position.x = 0;
      cameras[2].position.y = 0;
      cameras[2].position.z = 400;
      cameras[2].lookAt(scene.position);
      scene.add(cameras[2]);

      cameras[3].position.x = 35;
      cameras[3].position.y = 45;
      cameras[3].position.z = 50;
      cameras[3].lookAt(scene.position);
      scene.add(cameras[3]);

      scene.activeCamera = cameras[0];
}
