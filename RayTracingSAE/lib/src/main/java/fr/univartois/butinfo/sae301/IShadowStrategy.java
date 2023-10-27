package fr.univartois.butinfo.sae301;

public interface IShadowStrategy {
	boolean detectShadow(Point intersectionPoint, ISceneObject object, Vector vector, double distance);
}
