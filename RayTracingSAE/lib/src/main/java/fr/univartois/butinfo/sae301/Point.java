package fr.univartois.butinfo.sae301;


public class Point {
	private double x;
	private double y;
	private double z;
	private Triplet trip;
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.trip = new Triplet(x, y, z);
		
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	
	public Triplet subtraction(Triplet t) {
		return  Triplet.subtraction();
	}
	
	public Triplet multiplicationScailary(double d) {
		return new Triplet(d*x, d*y, d*z);
	}

	
}
