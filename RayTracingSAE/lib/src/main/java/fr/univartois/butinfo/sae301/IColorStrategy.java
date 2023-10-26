package fr.univartois.butinfo.sae301;

public interface IColorStrategy {

	java.awt.Color calculateColor(Vector normal, Light[] light, Point intersectionPoint, ISceneObject object);

}
