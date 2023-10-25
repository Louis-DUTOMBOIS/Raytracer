package fr.univartois.butinfo.sae301;

public interface ISceneObject {

	Point getOrigin();
	
	double intersect(Point p, Vector d);
	Color getColor();
}
