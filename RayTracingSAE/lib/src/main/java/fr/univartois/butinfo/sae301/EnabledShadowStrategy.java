package fr.univartois.butinfo.sae301;

public class EnabledShadowStrategy implements IShadowStrategy{


	@Override
	public boolean detectShadow(Point intersectionPoint, ISceneObject object, Vector vector, double distance) {
		boolean haveShadow = false;
		double distanceOfObject = object.intersect(intersectionPoint, vector);
		if (distanceOfObject > 0) {
			haveShadow = true;
		}
		return haveShadow;
	}

}
