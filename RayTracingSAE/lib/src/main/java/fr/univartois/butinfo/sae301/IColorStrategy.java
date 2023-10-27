package fr.univartois.butinfo.sae301;

import java.util.List;

/**
 * The IColorStrategy interface defines a strategy for calculating the color of a scene object.
 * Implementing classes must provide an implementation for the `calculateColor` method.
 *
 * @author Theo, Louis, Hugo, Alex
 */
public interface IColorStrategy {

    /**
     * Calculates the color of the object based on its normal, the scene lights, the intersection point,
     * and the object itself.
     *
     * @param normal           The normal of the object at the intersection point.
     * @param light            The list of lights in the scene.
     * @param intersectionPoint The intersection point between a ray and the object.
     * @param object           The scene object for which the color should be calculated.
     * @return The calculated color for the object.
     */
    static java.awt.Color calculateColor(Vector normal, List<Light> light, Point intersectionPoint, ISceneObject object) {
        // You should replace the 'return null' statement with your implementation.
        return null;
    }
}
