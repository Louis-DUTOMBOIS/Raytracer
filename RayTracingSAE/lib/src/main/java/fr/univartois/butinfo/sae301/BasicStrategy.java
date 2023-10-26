package fr.univartois.butinfo.sae301;

import java.awt.Color;

public class BasicStrategy implements IColorStrategy{

	@Override
	public Color calculateColor(Vector normal, Light[] light, Point intersectionPoint, ISceneObject object) {
		
			float r = (float) (object.getColor().getTrip().getX());
			float g = (float) (object.getColor().getTrip().getY());
			float b = (float) (object.getColor().getTrip().getZ());

			Color color = new Color(r, g, b);
			return color;
	}
}
