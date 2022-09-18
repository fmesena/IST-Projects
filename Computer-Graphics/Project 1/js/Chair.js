class Chair extends SceneObject {

	rotateChairLeft() {
		'use strict';

		rotate += alfa;
		d.applyAxisAngle(wew, alfa);
		support.rotateY(alfa);
	}

	rotateChairRight() {
		'use strict';

		rotate -= alfa;
		d.applyAxisAngle(wew, -alfa);
		support.rotateY(-alfa);
	}

	rotateWheels(direction) {
		'use strict'

		wheels[0].rotation.z += direction * alfa;
		wheels[1].rotation.z += direction * alfa;
		wheels[2].rotation.z += direction * alfa;
		wheels[3].rotation.z += direction * alfa;
	}

	alignWheels() {
		'use strict';

		wheels[0].rotation.y += rotate;
		wheels[1].rotation.y += rotate;
		wheels[2].rotation.y += rotate;
		wheels[3].rotation.y += rotate;


		rotate = 0;
	}

	moveForward(speed) {
		'use strict'

		if (this.userData.velocity < speed)
			this.userData.velocity += dt;
	 	else {
	 		this.userData.velocity = speed;
			breakB  = 0;
		}

		if (breakB)
			this.rotateWheels(1);
		if (forward)
			this.rotateWheels(-1);

		if (rotate != 0 | this.getVelocity() != 0)
	 		this.alignWheels();
	}

	moveBackwards(speed) {
		'use strict'

		if(this.userData.velocity > -speed)
	 		this.userData.velocity -= dt;
	 	else {
	 		this.userData.velocity = -speed;
			breakF  = 0;
		}

		if (backwards)
			this.rotateWheels(1);
		if (breakF)
			this.rotateWheels(-1);

	 	if (rotate != 0 | this.getVelocity() != 0)
	 		this.alignWheels();
	}


	update() {
		'use strict';

		dt = clock.getDelta();

		if (rotate_right == 1) this.rotateChairRight();
		if (rotate_left  == 1) this.rotateChairLeft();
		if (forward      == 1) {
			this.moveForward(max_speed);
			//this.rotateWheels(-1);
		}
		if (backwards    == 1) { 
			this.moveBackwards(max_speed);
			//this.rotateWheels(1);
		}
		if (breakF       == 1) { 
			this.moveBackwards(0);
			//this.rotateWheels(1);
		}
		if (breakB       == 1) {
			this.moveForward(0);
			//this.rotateWheels(-1);
		}

		this.translateOnAxis(d, this.userData.velocity);
	}


	setVelocity(v) {
		this.userData.velocity = v;
	}

	getVelocity() {
		return this.userData.velocity;
	}


	addChairBase(x, y, z) {
		'use strict';

		var geometry1 = new THREE.CubeGeometry(10, 1, 2);
		var geometry2 = new THREE.CubeGeometry(2, 1, 10);

		var mesh1 = new THREE.Mesh(geometry1, material);
		var mesh2 = new THREE.Mesh(geometry2, material);

		mesh1.position.set(x, y, z);
		mesh2.position.set(x, y, z);

		this.add(mesh1);
		this.add(mesh2);
	}

	addChairWheels(x, y, z) {
		'use strict';

		geometry = new THREE.TorusGeometry(0.5, 0.5, 8, 3);

		var mesh1 = new THREE.Mesh(geometry, material);
		var mesh2 = new THREE.Mesh(geometry, material);
		var mesh3 = new THREE.Mesh(geometry, material);
		var mesh4 = new THREE.Mesh(geometry, material);

		mesh1.position.set(x+5, y, z);
		mesh2.position.set(x-5, y, z);
		mesh3.position.set(x, y, z+5);
		mesh4.position.set(x, y, z-5);

		wheels.push(mesh1);
		wheels.push(mesh2);
		wheels.push(mesh3);
		wheels.push(mesh4);

		this.add(mesh1);
		this.add(mesh2);
		this.add(mesh3);
		this.add(mesh4);

		wheels[0].rotateOnAxis(wew, Math.PI/2);
		wheels[1].rotateOnAxis(wew, Math.PI/2);
		wheels[2].rotateOnAxis(wew, Math.PI/2);
		wheels[3].rotateOnAxis(wew, Math.PI/2);
	}

	addChairLeg(x, y, z) {
		'use strict';

		geometry = new THREE.CubeGeometry(2, 8, 2);
    	mesh = new THREE.Mesh(geometry, material);
   	 	mesh.position.set(x, y, z);
    	this.add(mesh);
	}

	constructor(x, y, z) {
		'use strict';

		super(x, y, z);

		this.userData = { velocity:0 };

	    support = new ChairSupport(0, 0, 0);

		material = new THREE.MeshBasicMaterial({ color: 0x00f0f6, wireframe: true });

		this.addChairBase(0, -9.5, 0);
		this.addChairLeg(0, -5, 0);
		this.addChairWheels(0, -10, 0);

	  	this.add(support);

		all_mesh.push(material);
	}
}
