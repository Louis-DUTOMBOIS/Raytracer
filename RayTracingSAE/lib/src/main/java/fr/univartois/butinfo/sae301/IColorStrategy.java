package fr.univartois.butinfo.sae301;

public interface IColorStrategy {

	Color calculateColor(Vector normal, Light light, Point intersectionPoint);

}
