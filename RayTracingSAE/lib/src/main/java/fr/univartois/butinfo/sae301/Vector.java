package fr.univartois.butinfo.sae301;

/**
 * A class representing a three-dimensional vector defined by its coordinates (x, y, z).
 * This class provides methods for vector operations, including addition, subtraction,
 * scalar multiplication, scalar product, vector product, length calculation, and normalization.
 */
public class Vector {
    private Triplet trip;

    /**
     * Constructs a Vector with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z-coordinate of the vector.
     */
    public Vector(double x, double y, double z) {
        this.trip = new Triplet(x, y, z);
    }

    /**
     * Gets the Triplet representing the coordinates of the vector.
     *
     * @return The Triplet object containing the (x, y, z) coordinates of the vector.
     */
    public Triplet getTrip() {
        return trip;
    }

    /**
     * Adds another vector to this vector, producing a new vector.
     *
     * @param t The Vector object to add to this vector.
     * @return A new Vector object representing the result of the addition.
     */
    public Vector add(Vector t) {
        Triplet result = trip.add(t.trip);
        return new Vector(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Adds a point to this vector, producing a new point.
     *
     * @param t The Point object to add to this vector.
     * @return A new Point object representing the result of the addition.
     */
    public Point add(Point t) {
        Triplet result = trip.add(t.getTrip());
        return new Point(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Subtracts another vector from this vector, producing a new vector.
     *
     * @param t The Vector object to subtract from this vector.
     * @return A new Vector object representing the result of the subtraction.
     */
    public Vector subtraction(Vector t) {
        Triplet result = trip.subtraction(t.trip);
        return new Vector(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Multiplies the vector by a scalar value, producing a new vector.
     *
     * @param d The scalar value for multiplication.
     * @return A new Vector object representing the result of the scalar multiplication.
     */
    public Vector multiplicationScailary(double d) {
        Triplet result = trip.multiplicationScailary(d);
        return new Vector(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Calculates the scalar product (dot product) between this vector and a triplet.
     *
     * @param w The Triplet for calculating the scalar product.
     * @return The scalar product between the vector and the triplet.
     */
    public double scalarProduct(Vector w) {
        return trip.scalarProduct(w.getTrip());
    }

    /**
     * Calculates the vector product (cross product) between this vector and a triplet.
     *
     * @param t The Triplet for calculating the vector product.
     * @return A new Vector object representing the result of the vector product.
     */
    public Vector vectorProduct(Triplet t) {
        Triplet result = trip.vectorProduct(t);
        return new Vector(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Calculates the length (magnitude) of the vector.
     *
     * @return The length of the vector.
     */
    public double length() {
        return trip.length();
    }

    /**
     * Normalizes the vector to have a unit length, producing a new normalized vector.
     *
     * @return A new normalized Vector with a unit length.
     */
    public Vector normalize() {
        Triplet result = trip.normalize();
        return new Vector(result.getX(), result.getY(), result.getZ());
    }
}