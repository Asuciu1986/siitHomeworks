package oop2;

abstract class Samsung implements Phone {

    private Color color;
    private Material material;

    Samsung(Color color, Material material) {
        this.color = color;
        this.material = material;
    }

}
