package oop2;

public abstract class Apple implements Phone{
    private Color color;
    private Material material;

    Apple(Color color, Material material) {
        this.color = color;
        this.material = material;
    }

}
