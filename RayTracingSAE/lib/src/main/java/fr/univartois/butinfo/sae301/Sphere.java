package fr.univartois.butinfo.sae301;

/*
 * Represents a sphere object in a 3D scene.
 */
public class Sphere implements ISceneObject{
	/*
     * The radius of the sphere.
     */
	private Point pos;
	private double radius;
	private Color color;
	
	/*
     * Creates a new sphere with the given vector, color and radius.
     *
     * @param vector The vector of the sphere.
     * @param color The color of the sphere.
     * @param radius The radius of the sphere.
     */
	public Sphere(Point pos, Color color, double radius) {
		this.pos = pos;
		this.radius = radius;
		this.color = color;
	}

	@Override
	public Point getOrigin() {
		return pos;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}