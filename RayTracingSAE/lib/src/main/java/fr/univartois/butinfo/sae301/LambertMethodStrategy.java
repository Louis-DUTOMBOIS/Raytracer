package fr.univartois.butinfo.sae301;
import java.awt.Color;
import java.util.List;

public class LambertMethodStrategy implements IColorStrategy {
	
	
	public static Color calculateColor(Vector normal, List<Light> lights, Point intersectionPoint, ISceneObject object) {
		java.awt.Color color = new Color(0,0,0);
		for (Light light : lights) {
            if (light instanceof DirectionalLight) {
                Vector ldir = ((DirectionalLight) light).getDirection();
                double tmp = Math.max(normal.scalarProduct(ldir), 0);
                fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));    
                color2 = object.getColor().schurProduct(color2).schurProduct(intersectionPoint.getColor());
                color = new Color((float) (color2.getTrip().getX()),(float) (color2.getTrip().getY()),(float) (color2.getTrip().getZ()));
            } else if (light instanceof PointLight) {
                Vector ldir = ((PointLight) light).position.subtraction(intersectionPoint).normalize();
                double tmp = Math.max(normal.scalarProduct(ldir), 0);
                fr.univartois.butinfo.sae301.Color color2 = (light.getColor().multiplicationScailary(tmp));
                color2 = object.getColor().schurProduct(color2).schurProduct(intersectionPoint.getColor());
                color = new Color((float) (color2.getTrip().getX()),(float) (color2.getTrip().getY()),(float) (color2.getTrip().getZ()));
            }
        }
        return color;
	}

}
