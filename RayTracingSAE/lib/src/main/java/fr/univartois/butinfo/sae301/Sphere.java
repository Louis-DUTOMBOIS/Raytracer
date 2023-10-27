package fr.univartois.butinfo.sae301;

/**
 * 
 * @author hugo, louis, théo, alex
 *
 */

/*
 * Represents a sphere object in a 3D scene.
 */
public class Sphere implements ISceneObject{
	/*
     * The radius of the sphere.
     */
	
	//existing attributes
	
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

	/**
	 * Returns the origin point of the sphere.
	 *
	 * @return The origin point of the sphere.
	 */
	@Override
	public Point getOrigin() {
	    return pos;
	}

	/**
	 * Returns the position point of the sphere.
	 *
	 * @return The position point of the sphere.
	 */
	public Point getPos() {
	    return pos;
	}

	/**
	 * Sets the position point of the sphere to the specified point.
	 *
	 * @param pos The new position point for the sphere.
	 */
	public void setPos(Point pos) {
	    this.pos = pos;
	}

	/**
	 * Returns the radius of the sphere.
	 *
	 * @return The radius of the sphere.
	 */
	public double getRadius() {
	    return radius;
	}

	/**
	 * Sets the radius of the sphere to the specified value.
	 *
	 * @param radius The new radius for the sphere.
	 */
	public void setRadius(double radius) {
	    this.radius = radius;
	}

	/**
	 * Returns the color of the sphere.
	 *
	 * @return The color of the sphere.
	 */
	public Color getColor() {
	    return color;
	}

	/**
	 * Sets the color of the sphere to the specified color.
	 *
	 * @param color The new color for the sphere.
	 */
	public void setColor(Color color) {
	    this.color = color;
	}
	
	/**
	 * Determines the distance between a point p following a direction d and the sphere.
	 *
	 * @param p The origin point of the ray.
	 * @param d The direction vector of the ray.
	 * @return The distance at which the ray intersects the sphere, or a negative value if there is no intersection.
	 */
	public double intersect(Point p, Vector d) {
	    Vector oc = p.subtraction(this.pos); // Vector from the center of the sphere to the ray's origin
	 
	    double a = 1;
	    double b = (oc.multiplicationScailary(2)).scalarProduct(d);
	    double c = oc.scalarProduct(oc) - (this.radius*this.radius);
	    double discriminant = (b * b) - 4.0 * a * c;

	    if (discriminant < 0) {
	        return -1; // No intersection
	    } 
	    if (discriminant == 0) {
	    	
	        return (-b / (2.0 * a)); // No intersection
	    } 
	    else {
	        double t1 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
	        double t2 = (-b + Math.sqrt(discriminant)) / (2.0 * a);

	        if (t1 >= 0) {
	            return t1; // Intersection at t1 (closest intersection)
	        } else if (t2 >= 0) {
	            return t2; // Intersection at t2
	        } else {
	            return -1; // No intersection
	        }
	    }
	}

	/**
	 * Returns a string representation of the Sphere object, including its position, radius, and color.
	 *
	 * @return A string containing information about the Sphere object, including its position, radius,
	 * and color.
	 */
	@Override
	public String toString() {
	    return "Sphere [pos=" + pos + ", radius=" + radius + ", color=" + color + "]";
	}
	
	
	

}