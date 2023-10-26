package fr.univartois.butinfo.sae301;

import java.awt.Color;

public class BasicStrategy implements IColorStrategy{

	@Override
	public Color calculateColor(Vector normal, Light light, Point intersectionPoint) {
		ISceneObject sphere = sceneObjects.get(0);

        float r = (float) (sphere.getColor().getTrip().getX());
        float g = (float) (sphere.getColor().getTrip().getY());
        float b = (float) (sphere.getColor().getTrip().getZ());

        Color color = new Color(r,g,b);

        if (intersection != null) {
            image.setRGB(i, j, color.getRGB());
        }

		else {
			image.setRGB(i, j, 0);
		}
	}

}
