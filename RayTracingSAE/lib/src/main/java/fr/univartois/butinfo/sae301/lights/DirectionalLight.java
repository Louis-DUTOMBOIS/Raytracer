package fr.univartois.butinfo.sae301.lights;

import fr.univartois.butinfo.sae301.opetriplet.Color;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

/**
 * 
 * Represents a directional light source in a 3D scene.
 * 
 * @author Theo, Louis, Hugo, Alex
 *
 */
public class DirectionalLight extends Light {
	
	private Vector direction;
	
    /**
     * Constructs a directional light with the specified direction and color.
     *
     * @param direction The direction in which the light is emitted.
     * @param color     The color of the light source.
     */
    public DirectionalLight(Vector direction, Color color) {
        super(color);
        this.direction = direction;
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

	public Vector getDirection() {
		return direction;
	}
    
    
}