package fr.univartois.butinfo.sae301;

/**
 * 
 * @author hugo, louis, théo, alex
 *
 */

/**
 * Represents a point in three-dimensional space, defined by its coordinates (x, y, z).
 */
public class Point {
	
	//existing attributes
	
    private Triplet trip;
    private Color color;

    /**
     * Constructs a Point object with the specified coordinates (x, y, z).
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @param z The z-coordinate of the point.
     */
    public Point(double x, double y, double z , Color color) {
        this.trip = new Triplet(x, y, z);
        this.color = color;
    }

    /**
     * Gets the Triplet representing the coordinates of the point.
     *
     * @return The Triplet object containing the (x, y, z) coordinates of the point.
     */
    public Triplet getTrip() {
        return trip;
    }

    /**
     * Computes the vector resulting from subtracting another point from this point.
     *
     * @param t The Point object to subtract from this point.
     * @return A Vector representing the result of the subtraction.
     */
    public Vector subtraction(Point t) {
        Triplet result = trip.subtraction(t.trip);
        return new Vector(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Computes a new point resulting from scalar multiplication by a constant factor.
     *
     * @param d The scalar factor for multiplication.
     * @return A new Point object representing the result of the multiplication.
     */
    public Point multiplicationScailary(double d) {
        Triplet result = trip.multiplicationScailary(d);
        return new Point(result.getX(), result.getY(), result.getZ(), color);
    }

    /**
     * Computes a new point resulting from subtracting a vector from this point.
     *
     * @param t The Vector object to subtract from this point.
     * @return A new Point object representing the result of the subtraction.
     */
    public Point subtractionVec(Vector t) {
        Triplet result = trip.subtraction(t.getTrip());
        return new Point(result.getX(), result.getY(), result.getZ(), color);
    }

    /**
     * Returns the color of the object.
     *
     * @return The color of the object.
     */
    public Color getColor() {
        return color;
    }
    
    
}