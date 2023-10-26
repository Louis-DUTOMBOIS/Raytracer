package fr.univartois.butinfo.sae301;

public class LambertMethodStrategy implements IColorStrategy {
	
	@Override
    public Color calculateColor(Vector normal, Light light, Point intersectionPoint) {
        Vector toLight = light.getPosition().subtraction(intersectionPoint);
        Vector lightDirection = toLight.normalize();
        double cosTheta = normal.normalize().scalarProduct(lightDirection);

        if (cosTheta > 0) {
            return light.getColor().multiply(cosTheta);
        } else {
            return Color.BLACK;
        }
    }

}
