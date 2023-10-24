package fr.univartois.butinfo.sae301;

/**
 * Represents a directional light source in a 3D scene.
 */
public class DirectionalLight extends Light {
    /**
     * Constructs a directional light with the specified direction and color.
     *
     * @param direction The direction in which the light is emitted.
     * @param color     The color of the light source.
     */
    public DirectionalLight(Triplet direction, Color color) {
        super(direction, color);
    }

    /**
     * Get the type of the light source, which is Directional.
     *
     * @return The type of the light source.
     */
    @Override
    public LightType getType() {
        return LightType.DIRECTIONAL;
    }
}