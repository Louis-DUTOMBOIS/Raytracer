package fr.univartois.butinfo.sae301;

public class Vector {

	private Triplet trip;
	public Vector(double x, double y, double z) {
		this.trip = new Triplet(x, y, z);
	}
	
	public Triplet getTrip() {
		return trip;
	}
	
	public Vector add(Vector t) {
		Triplet result = trip.add(t.trip);
		return new Vector(result.getX(),result.getY(),result.getZ());
	}
	
	public Point add(Point t) {
		Triplet result = trip.add(t.getTrip());
		return new Point(result.getX(),result.getY(),result.getZ());
	}
	
	public Vector subtraction(Vector t) {
		Triplet result = trip.subtraction(t.trip);
		return new Vector(result.getX(),result.getY(),result.getZ());
	}
	
	public Vector multiplicationScailary(double d) {
		Triplet result =  trip.multiplicationScailary(d);
		return new Vector(result.getX(),result.getY(),result.getZ());
	}
	
	public double scalarProduct(Triplet t) {
		 return trip.scalarProduct(t);
	}
	
	public Vector vectorProduct(Triplet t) {
		Triplet result =  trip.vectorProduct(t);
		return new Vector(result.getX(),result.getY(),result.getZ());
		
	}
	
	public double length() {
		return trip.length();
	}
	
	public Vector normalize() {
		Triplet result =  trip.normalize();
		return new Vector(result.getX(),result.getY(),result.getZ());
	}
}
