class PoolBall extends SceneObject {

	changeToPhong(){
		this.children[0].material = this.children[0].pM;
	}

	changeToBasic(){
		this.children[0].material = this.children[0].bM;
	}


	move() {
		'use strict'

		if (go) { 
			if (this.userData.velocity < max_speed)
				this.userData.velocity += dt;
		 	else 
		 		this.userData.velocity = max_speed;
		 }

		 else {
		 	if(this.userData.velocity > 0)
	 			this.userData.velocity -= dt;
	 		else 
	 			this.userData.velocity = 0;
		 }

		this.position.applyAxisAngle(y, this.userData.velocity/movementRadius);
		this.rotation.y += this.userData.velocity/movementRadius;
		this.children[0].rotation.x -= this.userData.velocity/this.userData.r;
	}


	update() {
		'use strict';

		this.move();
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

	getRadius() {
		return this.userData.r;
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

    constructor(x, y, z, radius, dir, v) {
        'use strict';

        super(x, y, z);

      	var texture = new THREE.TextureLoader().load('textures/15.jpg');

		geometry = new THREE.SphereGeometry(radius, 30, 30);
		
		var basicBall = new THREE.MeshBasicMaterial({color: 0xffffff, wireframe:false, map: new THREE.TextureLoader().load('textures/15.jpg')});
        
        var phongBall = new THREE.MeshPhongMaterial({color: 0xffffff, specular: 0xffffff, shininess: 120, wireframe: false, map: texture});
        
		var mesh = new SceneMesh(basicBall, phongBall, geometry);

        this.add(mesh)

        this.userData = { velocity: v, d: dir, r: radius };

        all_mesh.push(phongBall, basicBall);
    }
}
