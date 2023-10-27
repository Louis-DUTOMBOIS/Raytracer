

package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.util.List;

public class ShadowStrategy implements IShadowStrategy {
    @Override
    public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects) {
        // Iterate through scene objects to check for shadows.
    	Vector ldir = new Vector(0,0,0);
        for (ISceneObject object : sceneObjects) {
            // Check if the current object intersects with a ray from the intersection to the light source.
        	for (Light light : lights) {
                if (light instanceof DirectionalLight) {
                    ldir = ((DirectionalLight) light).getDirection();
                } else if (light instanceof PointLight) {
                    ldir = ((PointLight) light).position.subtraction(intersection).normalize();
                }
            }
            
			double t = object.intersect(intersection, ldir);
            if (t > 0) {
                // An intersection was found, meaning the point is in shadow.
                return true;
            }
        }
        // No intersections found, meaning the point is not in shadow.
        return false;
    }
}

