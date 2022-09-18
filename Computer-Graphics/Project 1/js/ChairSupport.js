class ChairSupport extends SceneObject {


	constructor(x, y, z) {
		'use strict';
		
		super(x, y, z);

		material  = new THREE.MeshBasicMaterial({ color: 0x00f0f6, wireframe: true });

		geometry = new THREE.CubeGeometry(10, 2, 10);
	    mesh = new THREE.Mesh(geometry, material);
	    mesh.position.set(x, y, z);
	    this.add(mesh);

   		var geometry1 = new THREE.CubeGeometry(10, 16, 2);
   	 	var mesh1 = new THREE.Mesh(geometry1, material);
    	mesh1.position.set(x, y+9, z+4);
   	 	this.add(mesh1);

   	 	all_mesh.push(material);
	}

}