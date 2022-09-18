class ChessBoard extends SceneObject {

    changeToPhong(){
        this.children[0].material = this.children[0].pM;
    }

    changeToBasic(){
        this.children[0].material = this.children[0].bM;
    }


    constructor(x, y, z) {
        'use strict';

        super(x, y, z);
        
        var texture = new THREE.TextureLoader().load('textures/chess2.png');

        geometry = new THREE.PlaneGeometry(70, 70, 20, 20);
        
        var phongBoard = new THREE.MeshPhongMaterial({side: THREE.DoubleSide, color: 0xeeeeee, specular: 0x222222, map:texture, wireframe: false});
        var basicBoard = new THREE.MeshBasicMaterial({color: 0xffffff, wireframe: false, map: new THREE.TextureLoader().load(" textures/chess2.png")});
        
        var mesh = new SceneMesh(basicBoard, phongBoard, geometry);

        mesh.position.set(x, y, z);

        this.rotateX(-Math.PI/2);
        
        this.add(mesh);

        all_mesh.push(phongBoard, basicBoard);
    }
}
