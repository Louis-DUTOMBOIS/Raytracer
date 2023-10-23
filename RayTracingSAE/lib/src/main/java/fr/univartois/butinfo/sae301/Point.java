package fr.univartois.butinfo.sae301;


public class Point {
	private Triplet trip;
	public Point(double x, double y, double z) {
		this.trip = new Triplet(x, y, z);
		
	}
	
	public Triplet getTrip() {
		return trip;
	}
	
	public Vector subtraction(Point t) {
		Triplet result = trip.subtraction(t.trip);
		return new Vector(result.getX(),result.getY(),result.getZ());
	}
	
	public Point multiplicationScailary(double d) {
		Triplet result =  trip.multiplicationScailary(d);
		return new Point(result.getX(),result.getY(),result.getZ());
	}

	public Point subtractionVec(Vector t) {
		Triplet result = trip.subtraction(t.getTrip());
		return new Point(result.getX(),result.getY(),result.getZ());
	}
	
}
