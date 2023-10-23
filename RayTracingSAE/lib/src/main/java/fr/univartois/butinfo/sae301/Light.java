package fr.univartois.butinfo.sae301;

public abstract class Light {
    protected Triplet direction;
    protected Triplet color;

    public Light(Triplet direction, Triplet color) {
        this.direction = direction;
        this.color = color;
    }

    public abstract LightType getType();
}

