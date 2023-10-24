package fr.univartois.butinfo.sae301;

public class Triangle extends SceneObject{
	private Vector[] vertices;
	public Triangle(Vector pos, Color color, Vector[] vertices) {
		super(pos, color);
		this.vertices = vertices;
	}
	
}
