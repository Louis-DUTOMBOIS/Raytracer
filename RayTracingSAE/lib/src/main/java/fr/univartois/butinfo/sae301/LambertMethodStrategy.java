package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.util.List;

/**
 * The `LambertMethodStrategy` class implements the `IColorStrategy` interface and defines a Lambertian reflection model
 * for calculating the color of a scene object. It takes into account the interaction of light sources with the object.
 *
 * @author Theo, Louis, Hugo, Alex
 */
public class LambertMethodStrategy implements IColorStrategy {

    /**
     * Calculates the color of the object based on the Lambertian reflection model, taking into account the normal vector,
     * lights in the scene, the intersection point, and the object itself.
     *
     * @param normal           The normal vector of the object at the intersection point.
     * @param lights           The list of lights in the scene.
     * @param intersectionPoint The intersection point between a ray and the object.
     * @param object           The scene object for which the color should be calculated.
     * @return The calculated color for the object using the Lambertian reflection model.
     */
    public static Color calculateColor(Vector normal, List<Light> lights, Point intersectionPoint, ISceneObject object) {
        java.awt.Color color = new Color(0, 0, 0);

        for (Light light : lights) {
            if (light instanceof DirectionalLight) {
                Vector ldir = ((DirectionalLight) light).getDirection();
                double tmp = Math.max(normal.scalarProduct(ldir), 0);
                fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));
                color2 = object.getColor().schurProduct(color2).schurProduct(intersectionPoint.getColor());
                color = new Color((float) (color2.getTrip().getX()), (float) (color2.getTrip().getY()), (float) (color2.getTrip().getZ()));
            } else if (light instanceof PointLight) {
                Vector ldir = ((PointLight) light).position.subtraction(intersectionPoint).normalize();
                double tmp = Math.max(normal.scalarProduct(ldir), 0);
                fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));
                color2 = object.getColor().schurProduct(color2).schurProduct(intersectionPoint.getColor());
                color = new Color((float) (color2.getTrip().getX()), (float) (color2.getTrip().getY()), (float) (color2.getTrip().getZ()));
            }
        }
        return color;
    }
}
