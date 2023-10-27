package fr.univartois.butinfo.sae301;

/**
 * The base class for representing different types of lights in a 3D scene.
 * This class serves as a common superclass for both directional and point lights.
 * 
 * @author Theo, Louis, Hugo, Alex
 * 
 */
public abstract class Light {
    /**
     * The direction of the light (for directional lights) or the position of the light (for point lights).
     */
    protected Vector direction;

    /**
     * The color of the light.
     */
    protected Color color;


    public Color getColor() {
		return color;
	}

	/**
     * Creates a new light with the given direction and color.
     *
     * @param direction The direction or position of the light.
     * @param color The color of the light.
     */
    public Light(Color color) {
        this.color = color;
    }

    /**
     * Gets the type of the light (either DIRECTIONAL or POINT).
     *
     * @return The type of the light.
     */
    public abstract LightType getType();
    
    public Color getColorFromLight() {
    	return this.color;
    }
    
}
