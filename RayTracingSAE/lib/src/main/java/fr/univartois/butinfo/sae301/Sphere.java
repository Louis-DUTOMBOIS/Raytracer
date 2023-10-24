package fr.univartois.butinfo.sae301;

/*
 * Represents a sphere object in a 3D scene.
 */
public class Sphere extends SceneObject{
	/*
     * The radius of the sphere.
     */
	private double radius;
	
	/*
     * Creates a new sphere with the given vector, color and radius.
     *
     * @param vector The vector of the sphere.
     * @param color The color of the sphere.
     * @param radius The radius of the sphere.
     */
	public Sphere(Vector pos, Color color, double radius) {
		super(pos, color);
		this.radius = radius;
	}

}