class Lamp extends SceneObject {


    addLampLight(x, y, z) {
        'use strict'
        
        geometry = new THREE.CylinderGeometry(1, 4, 5, 15);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        mesh.rotation.z = 5.5;
        this.add(mesh);
    }

    addLightBall(x, y, z){
        'use strict'

        geometry = new THREE.SphereGeometry(2, 10, 10);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        this.add(mesh);
    }


    addSecondPole(x, y, z){
        'use strict'

        geometry = new THREE.CylinderGeometry(1, 1, 22, 15);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x-10, y, z);
        mesh.rotation.z = -5;
        this.add(mesh);
    }

    addLampBall(x, y, z){
        geometry = new THREE.SphereGeometry(2, 10, 10);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        this.add(mesh);

    }
    addLampPole(x, y, z){
        'use strict'

        geometry = new THREE.CylinderGeometry(1, 1, 28, 15);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y-9, z);
        this.add(mesh);
    }
    addLampBase(x, y, z){
        'use strict';
        
        geometry = new THREE.CylinderGeometry(5, 5, 2, 15);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        this.add(mesh);
    }

    constructor(x, y, z){
        'use strict';

        super(x, y, z);
        material = new THREE.MeshBasicMaterial({color: 0xff00ff, wireframe: true});

        this.addLampBase(0, 1, 0);
        this.addLampPole(0, 25, 0);
        this.addLampBall(0, 30, 0);
        this.addSecondPole(0, 33, 0);
        this.addLightBall(-20, 36, 0);
        this.addLampLight(-21, 35, 0);
        all_mesh.push(material);
    }
}
