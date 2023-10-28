package fr.univartois.butinfo.sae301.creationpicture;

import java.awt.Color;
import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

/**
 * This class, BasicStrategy, implements the IColorStrategy interface and defines a color calculation strategy for a scene object.
 * The basic color strategy simply returns the object's color without any modification.
 * 
 * @author Theo, Louis, Hugo, Alex
 *
 */
public class BasicStrategy implements IColorStrategy {

	public static fr.univartois.butinfo.sae301.opetriplet.Color calculateColor(Vector normal, List<Light> light, Point intersectionPoint, ISceneObject object) {
		
			double r = object.getColor().getTrip().getX();
			double g = object.getColor().getTrip().getY();
			double b = object.getColor().getTrip().getZ();

			fr.univartois.butinfo.sae301.opetriplet.Color color = new fr.univartois.butinfo.sae301.opetriplet.Color(r, g, b);
			return color;
	}
}
