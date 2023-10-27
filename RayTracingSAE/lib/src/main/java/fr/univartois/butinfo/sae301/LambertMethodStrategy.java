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

	public static Color calculateColor(Vector normal, List<Light> lights, Point intersectionPoint,
			ISceneObject object) {
		float r;
		float g;
		float b;
		fr.univartois.butinfo.sae301.Color colordiff = BasicStrategy.calculateColor(normal, lights, intersectionPoint, object);
		Color color = new Color(0);
		for (Light light : lights) {
			if (light instanceof DirectionalLight) {
				Vector ldir = ((DirectionalLight) light).getDirection();
				double tmp = Math.max(ldir.scalarProduct(normal), 0);
				fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));
				color2 = colordiff.schurProduct(color2).add(intersectionPoint.getColor());

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
			} else if (light instanceof PointLight) {
				Vector ldir = ((PointLight) light).position.subtraction(intersectionPoint).normalize();
				double tmp = Math.max(normal.scalarProduct(ldir), 0);
				fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));
				color2 = colordiff.schurProduct(color2).add(intersectionPoint.getColor());
				
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
		}
		return color;
	}

}
