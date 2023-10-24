package fr.univartois.butinfo.sae301;

public class Triangle extends SceneObject{
	/*
     * The vectices of the triangle.
     */
	private Vector[] vertices;
	/*
     * Creates a new triangle with the given vector, color and radius.
     *
     * @param vector The vector of the triangle.
     * @param color The color of the triangle.
     */
	public Triangle(Vector pos, Color color, Vector[] vertices) {
		super(pos, color);
		this.vertices = vertices;
	}
	
}
