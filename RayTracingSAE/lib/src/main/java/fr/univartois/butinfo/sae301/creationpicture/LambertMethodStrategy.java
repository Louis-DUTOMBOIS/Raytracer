package fr.univartois.butinfo.sae301.creationpicture;

import java.awt.Color;
import java.util.List;

import fr.univartois.butinfo.sae301.lights.DirectionalLight;
import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.lights.PointLight;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

/**
 * The `LambertMethodStrategy` class implements the `IColorStrategy` interface and defines a Lambertian reflection model
 * for calculating the color of a scene object. It takes into account the interaction of light sources with the object.
 *
 * @author Theo, Louis, Hugo, Alex
 */
public class LambertMethodStrategy implements IColorStrategy {
	
	public static fr.univartois.butinfo.sae301.opetriplet.Color CalculateLd(Vector normal, List<Light> lights, Point intersectionPoint) {
		fr.univartois.butinfo.sae301.opetriplet.Color color3 = new fr.univartois.butinfo.sae301.opetriplet.Color(0,0,0);
		for (Light light : lights) {
			if (light instanceof DirectionalLight) {
				Vector ldir = ((DirectionalLight) light).getDirection();
				double tmp = Math.max(ldir.scalarProduct(normal), 0);
				fr.univartois.butinfo.sae301.opetriplet.Color color2 = (light.getColor().multiplicationScailary(tmp));
				color3 = color3.add(color2);
			}
			else if (light instanceof PointLight) {
				Vector ldir = ((PointLight) light).getPosition().subtraction(intersectionPoint).normalize();
				double tmp = Math.max(ldir.scalarProduct(normal), 0);
				fr.univartois.butinfo.sae301.opetriplet.Color color2 = (light.getColor().multiplicationScailary(tmp));
				color3 = color3.add(color2);
			}
			
		}
		return color3;
	}

	public static Color calculateColor(Vector normal, List<Light> lights, Point intersectionPoint,
			ISceneObject object) {
		float r;
		float g;
		float b;
		fr.univartois.butinfo.sae301.opetriplet.Color colordiff = BasicStrategy.calculateColor(normal, lights, intersectionPoint, object);
		Color color = new Color(0);
		for (Light light : lights) {
				fr.univartois.butinfo.sae301.opetriplet.Color colorLd = CalculateLd(normal, lights, intersectionPoint);
				fr.univartois.butinfo.sae301.opetriplet.Color color2 = colordiff.schurProduct(colorLd).add(intersectionPoint.getColor());

				if (color2.getTrip().getX() <= 1) {
					r = (float) color2.getTrip().getX();
				} else
					r = (float) 1.0;

				if (color2.getTrip().getY() <= 1) {
					g = (float) color2.getTrip().getY();
				} else
					g = (float) 1.0;

				if (color2.getTrip().getZ() <= 1) {
					b = (float) color2.getTrip().getZ();
				} else
					b = (float) 1.0;

				color = new Color(r,g,b);
		}
		return color;
	}

}
