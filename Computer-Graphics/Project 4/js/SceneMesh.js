class SceneMesh extends THREE.Mesh {
    
    constructor(bM, pM, geometry) {
        super(geometry, pM);
        this.bM = bM;
        this.pM = pM;
    }
}