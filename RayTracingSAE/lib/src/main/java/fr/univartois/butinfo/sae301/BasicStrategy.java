package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.util.List;

public class BasicStrategy implements IColorStrategy{

	public static Color calculateColor(Vector normal, List<Light> light, Point intersectionPoint, ISceneObject object) {
		
			float r = (float) (object.getColor().getTrip().getX());
			float g = (float) (object.getColor().getTrip().getY());
			float b = (float) (object.getColor().getTrip().getZ());

			Color color = new Color(r, g, b);
			return color;
	}
}
