class Field extends SceneObject {


    addLongWall(x, y, z){
        'use strict'

        material = new THREE.MeshBasicMaterial({color: 0xF5F5DC, wireframe: true});

        geometry = new THREE.CubeGeometry(fieldX + 4, wallHeight, 2)

        mesh = new THREE.Mesh(geometry, material)

        mesh.position.set(x, y, z)

        this.add(mesh)

        all_mesh.push(material)
    }

    addSmallWall(x, y, z){
        'use strict'

        material = new THREE.MeshBasicMaterial({color: 0xF5F5DC, wireframe: true});

        geometry = new THREE.CubeGeometry(2, wallHeight, fieldZ)

        mesh = new THREE.Mesh(geometry, material)

        mesh.position.set(x, y, z)

        this.add(mesh)

        all_mesh.push(material)
    }


    addFloor(x, y, z){
        'use strict';

        material = new THREE.MeshBasicMaterial({color: 0x608038, wireframe: true});

        geometry = new THREE.CubeGeometry(fieldX + 4, 2, fieldZ + 4);

        mesh = new THREE.Mesh(geometry, material);

        mesh.position.set(x, y, z)

        this.add(mesh)

        all_mesh.push(material)
    }

    constructor(x, y, z){
        'use strict';

        super(x, y, z);
        //material = new THREE.MeshBasicMaterial({color: 0xee55bbb, wireframe: true});

        this.addFloor(0, 1, 0);
        this.addLongWall(0, 2 + wallHeight/2, - (fieldZ / 2 + 1));
        this.addLongWall(0, 2 +  wallHeight/2, fieldZ / 2 + 1)
        this.addSmallWall(-(fieldX/2 + 1), 2 +  wallHeight/2, 0)
        this.addSmallWall(fieldX/2 + 1, 2 +  wallHeight/2, 0)

        allObjects.push(this)
    }
}
