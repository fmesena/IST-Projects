class Airplane extends SceneObject{


	rotateLeft(){
		var v = new THREE.Vector3(0, 1, 0);
		this.rotateOnAxis(v, rotation*dt);

		//this.rotateY(rotation*dt);
	}

	rotateRight(){
		var v = new THREE.Vector3(0, 1, 0);
		this.rotateOnAxis(v, (-1)*rotation*dt);
		//this.rotateY(rotation*dt*(-1));
	}

	rotateUp(){
		var v = new THREE.Vector3(0, 0, 1);
		this.rotateOnAxis(v, rotation*dt);
	}

	rotateDown(){
		var v = new THREE.Vector3(0, 0, 1);
		this.rotateOnAxis(v, (-1)*rotation*dt);
	}



	update(){
		if(rotate_left) this.rotateLeft();
		if(rotate_right) this.rotateRight();
		if(rotate_up) this.rotateUp();
		if(rotate_down) this.rotateDown();
	}



	changeToPrevious(){
		for (var i = this.children.length - 1; i >= 0; i--) {
			this.children[i].material = previous_mesh;
		}

	}


	changePrevious(){
		if(previous_mesh instanceof THREE.MeshPhongMaterial)
			previous_mesh = lambert;
		else
			previous_mesh = phong;
	}


	changeToBasic(){
		for (var i = this.children.length - 1; i >= 0; i--) {
			this.children[i].material = basic;
		}
	}


	changeToLambert(){
		for (var i = this.children.length - 1; i >= 0; i--) {
			this.children[i].material = lambert;
		}
		previous_mesh = lambert;

	}


	changeToPhong(){
		for (var i = this.children.length - 1; i >= 0; i--) {
			this.children[i].material = phong;
		}
		previous_mesh = phong;
	}

	changeMaterial(){
		if(this.children[0].material instanceof THREE.MeshPhongMaterial)
			this.changeToLambert()
		else
			this.changeToPhong();
	}

	rotateZ(rotation){
		this.rotation.z += rotation *dt ;
	}

	rotateY(rotation){
		this.rotation.y += rotation *dt;
	}



	rotateWheels() {
		'use strict'

		this.children[0].rotation.x += ((-1) * Math.sqrt((this.getVelocity() * dt * this.getDirection().getComponent(0) * level)**2 + (this.getVelocity() * dt * this.getDirection().getComponent(2) * level)**2))/(ballRadius);
	}

	moveForward() {
		'use strict'

		this.position.x += this.getVelocity() * dt * this.getDirection().getComponent(0) * level;
		this.position.z += this.getVelocity() * dt * this.getDirection().getComponent(2) * level;
	}


	getPosition() {
		return new THREE.Vector3(this.position.x, this.position.y, this.position.z);
	}

	getPositionX(){
		return this.position.x
	}

	getPositionY(){
		return this.position.y
	}

	getPositionZ(){
		return this.position.z
	}

	setPosition(x, y, z) {
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
	}


	getDirection() {
		'use strict';

		return this.userData.d;
	}

	setDirection(dir) {
		'use strict';

		this.userData.d = dir;
	}


	createWing(x, y, z, height, size, rotation, axis){
		var v0, v1, v2;
		var geometry = new THREE.Geometry();

		v0 = new THREE.Vector3(x + size/2, y, z + height/2);
		v1 = new THREE.Vector3(x + size/2, y, z-height/2);
		v2 = new THREE.Vector3(x - size/2, y, z-height/2);

		geometry.vertices.push(v0, v1, v2);

		geometry.faces.push(new THREE.Face3(0, 1, 2));
		geometry.faces.push(new THREE.Face3(0, 2, 1));

		geometry.computeFaceNormals();

		
		material = phong;
		mesh = new THREE.Mesh(geometry, material);

		this.add(mesh);

		if(axis == "x")
			mesh.rotateX(rotation);
		else if(axis == "y")
			mesh.rotateY(rotation);
		else if(axis == "z")
			mesh.rotateZ(rotation);


	}


	createPyramid(x, y, z, height, size, rotation){
		var v0, v1, v2, v3, v4;
		var geometry = new THREE.Geometry();
		
		v0 = new THREE.Vector3(x, y, z);
		v1 = new THREE.Vector3(x+height, y, z + size/2);
		v2 = new THREE.Vector3(x+height, y, z - size/2);
		v3 = new THREE.Vector3(x+height, y-size, z+size/2);
		v4 = new THREE.Vector3(x+height, y-size, z-size/2);
		
		geometry.vertices.push(v0, v1, v2, v3, v4);
		
		geometry.faces.push(new THREE.Face3(0, 1, 2));

		geometry.faces.push(new THREE.Face3(0, 3, 1));

		geometry.faces.push(new THREE.Face3(0, 2, 4));

		geometry.faces.push(new THREE.Face3(0, 4, 3));

		geometry.faces.push(new THREE.Face3(1, 3, 4));

		geometry.faces.push(new THREE.Face3(2, 1, 4));





		geometry.computeFaceNormals();
		
		material = phong;
		mesh = new THREE.Mesh(geometry, material)

		if(rotation){
			mesh.rotateZ(rotation);
		}

		this.add(mesh);

	}


    constructor(x, y, z, height, size) {
        'use strict';

        super(x, y, z);

        var xcenter = x - height/2;
        var ycenter = y + size/2;
        var zcenter = z;

        this.createPyramid(xcenter, ycenter, z, height, size);
        this.createPyramid(xcenter + size , ycenter + 10, z, height/3, size/3, Math.PI/19);
        this.createWing(x + size/2, y + size/4, z + size, height/2, size);
        this.createWing(x + size/2, y - size/4, z + size, height/2, size, Math.PI, "x");
        this.createWing(x + 2*size, y + size/4, z + size/2, height/3, size/2);
        this.createWing(x + 2*size, y - size/4, z + size/2, height/3, size/2, Math.PI, "x");
        this.createWing(x + 2*size, y, z + size/2, height/3, size/2, -Math.PI/2, "x");

    }
}
