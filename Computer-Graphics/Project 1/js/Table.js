class Table extends SceneObject {
    addTableLeg(x, y, z) {
        'use strict';

        geometry = new THREE.CylinderGeometry(2, 2, 20, 15);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y - 10, z);
        this.add(mesh);
  }

    addTableTop(x, y, z) {
        'use strict';

        geometry = new THREE.CubeGeometry(60, 2, 30);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        this.add(mesh);
  }

    constructor(x, y, z) {
        super(x, y, z);

        material = new THREE.MeshBasicMaterial({ color: 0x00ff00, wireframe: true });
        
        this.addTableTop(0, 0, 0);
        this.addTableLeg(-25, -1, -12);
        this.addTableLeg(-25, -1, 12);
        this.addTableLeg(25, -1, 12);
        this.addTableLeg(25, -1, -12);
        all_mesh.push(material);
    }

}
