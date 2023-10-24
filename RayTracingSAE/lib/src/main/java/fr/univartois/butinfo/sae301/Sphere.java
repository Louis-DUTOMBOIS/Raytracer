package fr.univartois.butinfo.sae301;

public class Sphere extends SceneObject{
	private double radius;
	public Sphere(Vector pos, Color color, double radius) {
		super(pos, color);
		this.radius = radius;
	}

}