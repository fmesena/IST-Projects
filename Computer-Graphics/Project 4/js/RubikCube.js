class RubikCube extends SceneObject {

	changeToBasic(){
		this.children[0].material = this.children[0].bM;
	}

	changeToPhong(){
		this.children[0].material = this.children[0].pM;
	}


    constructor(x, y, z) {
        'use strict';

        super(x, y, z);

        var texture = new THREE.TextureLoader().load( "textures/rubik.jpg" );

    	var rubikMaterials = [
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/red.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5}),
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/green.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5}),
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/blue.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5}),
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/yellow.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5}),
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/white.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5}),
    		new THREE.MeshPhongMaterial({color: 0xeeeeee, specular: 0x333333, shininess: 30, wireframe: false, map: new THREE.TextureLoader().load(" textures/orange.png"), bumpMap: new THREE.TextureLoader().load("textures/bump.png"), bumpScale: 0.5})
    		];

    	var rubikBasicMaterials = [
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/red.png")}),
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/green.png")}),
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/blue.png")}),
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/yellow.png")}),
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/white.png")}),
    		new THREE.MeshBasicMaterial({color: 0xeeeeee, wireframe: false, map: new THREE.TextureLoader().load(" textures/orange.png")})
    		];

        geometry = new THREE.BoxGeometry(12, 12, 12, 20);

        var mesh = new SceneMesh(new THREE.MeshFaceMaterial(rubikBasicMaterials), new THREE.MeshFaceMaterial(rubikMaterials), geometry);

        this.add(mesh);

        for (var i = rubikMaterials.length - 1; i >= 0; i--) {
        	all_mesh.push(rubikMaterials[i]);
        	all_mesh.push(rubikBasicMaterials[i]);
        }
    }
}
