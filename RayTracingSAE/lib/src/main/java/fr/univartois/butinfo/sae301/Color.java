package fr.univartois.butinfo.sae301;

public class Color {
	Triplet trip;
    public Color(double x, double y, double z) {
        this.trip = new Triplet(x,y,z);
    }
    
    public Triplet getTrip() {
		return trip;
	}

    public Color add(Color c) {
    	Triplet result = trip.add(c.getTrip());
        return new Color(result.getX(), result.getY() , result.getZ());
    }

    public Color multiplicationScailary(double d) {
    	Triplet result = trip.multiplicationScailary(d);
        return new Color(result.getX(), result.getY() , result.getZ());
    }

    public Color schurProduct(Color c) {
    	Triplet result = trip.schurProduct(c.getTrip());
        return new Color(result.getX(), result.getY() , result.getZ());
    }
}