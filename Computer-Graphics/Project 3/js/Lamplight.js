class Lamplight extends SceneObject{

	

	getPositionX(){
		return this.position.x;
	}


	getPositionY(){
		return this.position.y;
	}

	getPositionZ(){
		return this.position.z;
	}


	getLightStatus(){
		return this.userData.light;
	}


	turnOff(){
		this.children[0].intensity = 0;
		this.userData.light = false;
	}

	turnOn(){
		this.children[0].intensity = 2;
		this.userData.light = true;
	}


	createLight(x, y, z){
		var l;
		l = new THREE.SpotLight(0xfcd440, 2);
		l.position.set(x, y, z);

		l.castShadow = true;

		l.shadow.mapSize.width = 1024;
		l.shadow.mapSize.height = 1024;

		l.shadow.camera.near = 500;
		l.shadow.camera.far = 4000;
		l.shadow.camera.fov = 30;
		this.add(l);
	}

	rotate(){
		var angle;
		
		if(this.getPositionX() == 0){
			angle = this.getPositionZ()/this.getPositionY();
			this.rotation.x = Math.atan(angle);

		}
		
		else if(this.getPositionZ() == 0){
			angle = this.getPositionX()/this.getPositionY();
			this.rotation.z = Math.atan(-(angle));
		}
	}


	addBulb(x, y, z){
       'use strict'

		var geometry = new THREE.SphereGeometry(2, 10, 10);
		var material = new THREE.MeshStandardMaterial( {color: 0xaa00aa, wireframe: false} );
        var mesh = new THREE.Mesh(geometry, material);
        mesh.position.set(x, y, z);
        this.add(mesh);
    }


	constructor(x, y, z){
		super(x, y, z);
		var geometry = new THREE.CylinderGeometry( 1, 7, 10, 10 );
		var material = new THREE.MeshPhongMaterial( {color: 0xaa00aa, wireframe: false} );
		var lamp = new THREE.Mesh(geometry, material);
		var axis = new THREE.AxisHelper(10)
		
		this.userData = {light: true};

		this.createLight(0, 2, 0);
		this.addBulb(0, 2, 0);
		this.add(lamp)
		this.add(axis)
		
		this.rotate();


	}

}