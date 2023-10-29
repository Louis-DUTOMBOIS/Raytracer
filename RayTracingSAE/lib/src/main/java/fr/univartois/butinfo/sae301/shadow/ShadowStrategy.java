

package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.DirectionalLight;
import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.lights.PointLight;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

/**
 * The ShadowStrategy class implements the IShadowStrategy interface and represents a shadow calculation strategy that checks for shadows in a scene.
 * This strategy considers the presence of objects in the scene to determine whether a given point is in shadow.
 *
 * To calculate shadows, it traces rays from the intersection point to each light source and checks for intersections with scene objects. If an intersection is found, the point is considered in shadow.
 * @author Theo, Louis, Hugo, Alex
 */
public class ShadowStrategy implements IShadowStrategy {
    /**
     * Checks if a given point is in shadow by tracing rays to each light source and checking for intersections with scene objects.
     *
     * @param intersection   The point for which shadow is being checked.
     * @param lights         The list of lights in the scene.
     * @param sceneObjects   The list of objects in the scene.
     * @return `true` if the point is in shadow, `false` otherwise.
     */
    @Override
    public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects) {
        // Iterate through scene objects to check for shadows.
    	Vector ldir = new Vector(0,0,0);
        for (ISceneObject object : sceneObjects) {
            // Check if the current object intersects with a ray from the intersection to the light source.
        	for (Light light : lights) {
                if (light instanceof DirectionalLight) {
                    ldir = ((DirectionalLight) light).getDirection().normalize();
                } else if (light instanceof PointLight) {
                    ldir = (intersection.subtraction(((PointLight) light).getPosition())).normalize();
                }
            }
            
			double t = object.intersect(intersection, ldir);
            if (t > 0) {
            	System.out.println("true");
                // An intersection was found, meaning the point is in shadow.
                return true;
            }
        }
        // No intersections found, meaning the point is not in shadow.
        return false;
    }
}

