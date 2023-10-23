package fr.univartois.butinfo.saeS3A01;

public class Triplet {
	private double x;
	private double y;
	private double z;
	public Triplet(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public Triplet add(Triplet t) {
		return new Triplet(t.x+x, t.y+y, t.z+z);
	}
	
	public Triplet subtraction(Triplet t) {
		return new Triplet(t.x-x, t.y-y, t.z-z);
	}
	
	public Triplet multiplicationScailary(double d) {
		return new Triplet(d*x, d*y, d*z);
	}
	
	public double scalarProduct(Triplet t) {
		 return t.x*x + t.y*y + t.z*z;
	}
	
	public Triplet vectorProduct(Triplet t) {
		return new Triplet(y*t.z - z*t.y, z*t.x - x*t.z, x*t.y - t.x*y);
		
	}
	
	public Triplet SchurProduct(Triplet t) {
		return new Triplet(x*t.x, y*t.y, z*t.z);		
	}
	
	public double length() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public Triplet normalize() {
		double len = 1/length();
		return new Triplet(len*x,len*y,len*z);
	}
}
