package fr.univartois.butinfo.sae301;

/**
 * 
 * @author hugo, louis, théo, alex
 *
 */


/**
 * The Triangle class represents a 3D triangle in a scene.
 */

public class Triangle implements ISceneObject {
	/*
	 * The vectices of the triangle.
	 */
	
	//existing attributes
	private Point point1;
	private Point point2;
	private Point point3;
	private Color color;

	/*
	 * Creates a new triangle with the given vector, color and radius.
	 *
	 * @param color The color of the triangle.
	 */
	public Triangle(Color color, Point point1, Point point2, Point point3) {
		this.color = color;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	/**
	 * Returns the origin point of the triangle.
	 *
	 * @return The origin point of the triangle.
	 */
	@Override
	public Point getOrigin() {
	    return point1;
	}

	/**
	 * Returns the first point of the triangle.
	 *
	 * @return The first point of the triangle.
	 */
	public Point getPoint1() {
	    return point1;
	}

	/**
	 * Sets the first point of the triangle to the specified point.
	 *
	 * @param point1 The new first point for the triangle.
	 */
	public void setPoint1(Point point1) {
	    this.point1 = point1;
	}

	/**
	 * Returns the second point of the triangle.
	 *
	 * @return The second point of the triangle.
	 */
	public Point getPoint2() {
	    return point2;
	}

	/**
	 * Sets the second point of the triangle to the specified point.
	 *
	 * @param point2 The new second point for the triangle.
	 */
	public void setPoint2(Point point2) {
	    this.point2 = point2;
	}

	/**
	 * Returns the third point of the triangle.
	 *
	 * @return The third point of the triangle.
	 */
	public Point getPoint3() {
	    return point3;
	}

	/**
	 * Sets the third point of the triangle to the specified point.
	 *
	 * @param point3 The new third point for the triangle.
	 */
	public void setPoint3(Point point3) {
	    this.point3 = point3;
	}

	/**
	 * Returns the color of the triangle.
	 *
	 * @return The color of the triangle.
	 */
	public Color getColor() {
	    return color;
	}

	/**
	 * Sets the color of the triangle to the specified color.
	 *
	 * @param color The new color for the triangle.
	 */
	public void setColor(Color color) {
	    this.color = color;
	}

	/**
	 * Calculates the intersection between the triangle and a ray defined by a point and a direction vector.
	 *
	 * @param p The starting point of the ray.
	 * @param d The direction vector of the ray.
	 * @return The parameter 't' at which the ray intersects the triangle or -1 if there is no intersection.
	 */
	@Override
	public double intersect(Point p, Vector d) {
	    double t;
	    Vector normal = (point2.subtraction(point1)).vectorProduct((point3.subtraction(point1)).getTrip()).normalize();
	    if ((d.scalarProduct(normal)) == 0) {
	        return -1;
	    } else {
	        t = (normal.scalarProduct(point1.subtraction(p))) / (d.scalarProduct(normal));
	    }

	    Point point = (d.multiplicationScailary(t)).add(p);
	    if ((point2.subtraction(point1)).vectorProduct((point.subtraction(point1).getTrip()))
	            .scalarProduct(normal) >= 0) {
	        if ((point3.subtraction(point2)).vectorProduct((point.subtraction(point2).getTrip()))
	                .scalarProduct(normal) >= 0) {
	            if ((point1.subtraction(point3)).vectorProduct((point.subtraction(point3).getTrip()))
	                    .scalarProduct(normal) >= 0) {
	                return t;
	            } else {
	                return -1;
	            }
	        } else {
	            return -1;
	        }
	    } else {
	        return -1;
	    }
	}

}
