class PauseObject extends SceneObject {

    constructor(x, y, z) {
        'use strict';

        super(x, y, z);
        
        var texture = new THREE.TextureLoader().load('textures/pause.png');

        geometry = new THREE.PlaneGeometry((frustumSize * aspect / 5 - frustumSize * aspect / - 5)/3, (frustumSize * aspect / 5 - frustumSize * aspect / - 5)/3, 1);
        
        material = new THREE.MeshBasicMaterial({side: THREE.DoubleSide, map:texture, color: 0xffffff, wireframe: false});

        var mesh = new THREE.Mesh(geometry, material);

        mesh.position.set(x, y, z);
        
        this.add(mesh);

        all_mesh.push(mesh);
    }
}