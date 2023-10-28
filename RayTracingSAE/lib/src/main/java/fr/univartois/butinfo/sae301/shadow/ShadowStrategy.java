

package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.DirectionalLight;
import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.lights.PointLight;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

public class ShadowStrategy implements IShadowStrategy {
	
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

