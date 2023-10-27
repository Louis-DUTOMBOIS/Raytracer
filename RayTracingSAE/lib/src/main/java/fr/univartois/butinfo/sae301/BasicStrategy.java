package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.util.List;

/**
 * This class, BasicStrategy, implements the IColorStrategy interface and defines a color calculation strategy for a scene object.
 * The basic color strategy simply returns the object's color without any modification.
 * 
 * @author Theo, Louis, Hugo, Alex
 *
 */
public class BasicStrategy implements IColorStrategy {

    /**
     * Calculates the color of the object based on its normal, the scene lights, the intersection point,
     * and the object itself.
     *
     * @param normal           The normal of the object at the intersection point.
     * @param light            The list of lights in the scene.
     * @param intersectionPoint The intersection point between a ray and the object.
     * @param object           The scene object for which the color should be calculated.
     * @return The color calculated for the object based on the basic color strategy.
     */
    public static Color calculateColor(Vector normal, List<Light> light, Point intersectionPoint, ISceneObject object) {
        // Retrieve the color components of the object.
        float r = (float) (object.getColor().getTrip().getX());
        float g = (float) (object.getColor().getTrip().getY());
        float b = (float) (object.getColor().getTrip().getZ());

        // Create a new color from the R, G, and B components.
        Color color = new Color(r, g, b);

        // Return the calculated color.
        return color;
    }
}
