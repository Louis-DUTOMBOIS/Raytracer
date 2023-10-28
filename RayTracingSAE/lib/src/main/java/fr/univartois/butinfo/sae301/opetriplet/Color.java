package fr.univartois.butinfo.sae301.opetriplet;

/**
 * 
 * Represents a color using three components (RGB) stored as a Triplet.
 * This class provides methods for performing color operations such as addition,
 * scalar multiplication, and Schur product.
 * 
 * @author Theo, Louis, Hugo, Alex
 * 
 */
public class Color {

    private Triplet trip;

    /**
     * Constructs a Color object with the specified RGB components.
     *
     * @param x The red component of the color.
     * @param y The green component of the color.
     * @param z The blue component of the color.
     */
    public Color(double x, double y, double z) {
        this.trip = new Triplet(x, y, z);
    }

    /**
     * Gets the Triplet representing the RGB components of the color.
     *
     * @return The Triplet object containing the RGB components.
     */
    public Triplet getTrip() {
        return trip;
    }

    /**
     * Adds another color to this color.
     *
     * @param c The Color object to add to this color.
     * @return A new Color object representing the result of the addition.
     */
    public Color add(Color c) {
        Triplet result = trip.add(c.getTrip());
        return new Color(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Multiplies the color by a scalar value.
     *
     * @param d The scalar value for multiplication.
     * @return A new Color object representing the result of the scalar multiplication.
     */
    public Color multiplicationScailary(double d) {
        Triplet result = trip.multiplicationScailary(d);
        return new Color(result.getX(), result.getY(), result.getZ());
    }

    /**
     * Performs a Schur product (component-wise multiplication) with another color.
     *
     * @param c The Color object to perform the Schur product with.
     * @return A new Color object representing the result of the Schur product.
     */
    public Color schurProduct(Color c) {
        Triplet result = trip.schurProduct(c.getTrip());
        return new Color(result.getX(), result.getY(), result.getZ());
    }

	@Override
	public String toString() {
		return "Color [trip=" + trip + "]";
	}
    
    
}