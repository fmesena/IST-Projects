class Ball extends SceneObject {

	rotateWheels() {
		'use strict'

		this.children[0].rotation.x += ((-1) * Math.sqrt((this.getVelocity() * dt * this.getDirection().getComponent(0) * level)**2 + (this.getVelocity() * dt * this.getDirection().getComponent(2) * level)**2))/(ballRadius);
	}

	moveForward() {
		'use strict'

		this.position.x += this.getVelocity() * dt * this.getDirection().getComponent(0) * level;
		this.position.z += this.getVelocity() * dt * this.getDirection().getComponent(2) * level;
	}

	previewPos() {
		'use strict'

		var x_preview = this.getPositionX() + this.getVelocity() * dt * this.getDirection().getComponent(0) * level;
		var y_preview = this.getPositionY() + this.getDirection().getComponent(1)*(this.getVelocity());
		var z_preview = this.getPositionZ() + this.getVelocity() * dt * this.getDirection().getComponent(2) * level;

		this.userData.preview = new THREE.Vector3(x_preview, y_preview, z_preview);
	}

	hasColision(other) {
		'use strict'

		var my_center = this.getPosition();
		var distance;
		var scalar;

		var x_preview = this.userData.preview.getComponent(0);
		var y_preview = this.userData.preview.getComponent(1);
		var z_preview = this.userData.preview.getComponent(2);

		if(other instanceof Field){

			if (x_preview + ballRadius >= fieldX/2  || x_preview - ballRadius <= -fieldX/2){
					this.setDirection(new THREE.Vector3((-1)* this.getDirection().getComponent(0), 0, this.getDirection().getComponent(2)).normalize())
			}

			if (z_preview + ballRadius >= fieldZ/2  || z_preview - ballRadius <= -fieldZ/2){
					this.setDirection(new THREE.Vector3(this.getDirection().getComponent(0), 0, this.getDirection().getComponent(2)*(-1)).normalize())
			}
		
		}


		if (other instanceof Ball){

			distance = (x_preview - other.userData.preview.getComponent(0))**2 + (z_preview - other.userData.preview.getComponent(2))**2

			if (distance <= (2*ballRadius)**2) {
				this.handleCollision(other);
			}

		}
	}

	handleCollision(other){
		var old_dir = this.getDirection()
		var old_v = this.getVelocity()

		this.setDirection(other.getDirection())
		this.setVelocity(other.getVelocity())

		other.setDirection(old_dir)
		other.setVelocity(old_v)
	}

	update() {
		'use strict';
		var k = new THREE.Vector3();
		k.addVectors(this.position, this.getDirection());
		this.lookAt(k);
		this.moveForward();
		this.rotateWheels();
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

	getVelocity() {
		'use strict';

		return this.userData.velocity;
	}

	setVelocity(v) {
		'use strict';

		this.userData.velocity = v;
	}

	getDirection() {
		'use strict';

		return this.userData.d;
	}

	setDirection(dir) {
		'use strict';

		this.userData.d = dir;
	}

    constructor(x, y, z, dir, prev, color, v) {
        'use strict';

        super(x, y, z);

        material = new THREE.MeshBasicMaterial({color: color, wireframe: true});
        geometry = new THREE.SphereGeometry(ballRadius, 10, 10);

        var sphere = new THREE.Mesh(geometry, material)

		//sphere.add(new THREE.AxisHelper(10))

        this.add(sphere)

        this.userData = { velocity: v, d: dir, preview: prev };

        all_mesh.push(material);
    }
}
