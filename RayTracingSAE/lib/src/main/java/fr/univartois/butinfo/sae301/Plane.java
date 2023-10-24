package fr.univartois.butinfo.sae301;

public class Plane extends SceneObject{
	/*
     * The width of the plane.
     */
	private int width;
	/*
     * The height of the plane.
     */
	private int height;
	/*
     * Creates a new plane with the given vector, color and radius.
     *
     * @param vector The vector of the plane.
     * @param color The color of the plane.
     * @param width The width of the plane.
     * @param height The height of the plane.
     */
	public Plane (Vector pos, Color color, int width, int height) {
		super(pos, color);
		this.width = width;
		this.height = height;
	}

}