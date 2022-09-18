class Teste extends SceneObject {

	constructor(x, y, z) {
        super(x, y, z);

        material = new THREE.MeshPhongMaterial({ color: 0xc0c0c0, wireframe: false});
        geometry = new THREE.CubeGeometry(20, 20, 20);
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        mesh.visible = true;
        this.add(mesh);

        material = new THREE.MeshStandardMaterial({ color: 0xc0c0c0, wireframe: false});
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        mesh.visible = false;
        this.add(mesh);


        material = new THREE.MeshBasicMaterial({ color: 0xc0c0c0, wireframe: false});
        mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        mesh.visible = false;
        this.add(mesh);
    }
}