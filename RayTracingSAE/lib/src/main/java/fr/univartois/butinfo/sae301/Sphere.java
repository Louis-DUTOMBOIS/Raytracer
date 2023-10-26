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

	@Override
	public String toString() {
		return "Sphere [pos=" + pos + ", radius=" + radius + ", color=" + color + "]";
	}
	
	
	

}