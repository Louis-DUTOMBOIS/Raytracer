package fr.univartois.butinfo.sae301;

/**
 * 
 * @author hugo, louis, théo, alex
 *
 */

public class Plane implements ISceneObject{
	
	//existing attributes
	
	private Point pos;
	private Vector normal;
	private Color color;
	/*
     * Creates a new plane with the given vector, color and radius.
     *
     * @param vector The vector of the plane.
     * @param color The color of the plane.
     * @param width The width of the plane.
     * @param height The height of the plane.
     */
	public Plane (Point pos, Vector normal, Color color) {
		this.pos = pos;
		this.normal = normal;
		this.color = color;
	}
	/**
	 * Returns the origin point of the plane.
	 *
	 * @return The origin point of the plane.
	 */
	@Override
	public Point getOrigin() {
	    return pos;
	}

	/**
	 * Returns the position of the plane.
	 *
	 * @return The position point of the plane.
	 */
	public Point getPos() {
	    return pos;
	}

	/**
	 * Sets the position of the plane to the specified point.
	 *
	 * @param pos The new position point for the plane.
	 */
	public void setPos(Point pos) {
	    this.pos = pos;
	}

	/**
	 * Returns the normal vector of the plane.
	 *
	 * @return The normal vector of the plane.
	 */
	public Vector getNormal() {
	    return normal;
	}

	/**
	 * Sets the normal vector of the plane to the specified vector.
	 *
	 * @param normal The new normal vector for the plane.
	 */
	public void setNormal(Vector normal) {
	    this.normal = normal;
	}

	/**
	 * Calculates the intersection between the plane and a ray defined by a point and a direction vector.
	 *
	 * @param p The starting point of the ray.
	 * @param d The direction vector of the ray.
	 * @return The parameter 't' at which the ray intersects the plane or -1 if there is no intersection.
	 */
	@Override
	public double intersect(Point p, Vector d) {
	    if ((d.scalarProduct(normal)) == 0) {
	        return -1;
	    } else {
	        double t = (normal.scalarProduct(pos.subtraction(p))) / (d.scalarProduct(normal));
	        return t;
	    }
	}

	/**
	 * Returns the color of the plane.
	 *
	 * @return The color of the plane.
	 */
	@Override
	public Color getColor() {
	    // TODO Auto-generated method stub
	    return color;
	}

}