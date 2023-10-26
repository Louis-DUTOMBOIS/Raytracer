package fr.univartois.butinfo.sae301;

public class Plane implements ISceneObject{
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
	@Override
	public Point getOrigin() {
		return pos;
	}
	public Point getPos() {
		return pos;
	}
	public void setPos(Point pos) {
		this.pos = pos;
	}
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
	
	@Override
	public double intersect(Point p, Vector d) {
		if ((d.scalarProduct(normal)) == 0) {
			return -1;
		}
		else {
			double t = (normal.scalarProduct(pos.subtraction(p))) / (d.scalarProduct(normal));
		return t;
		}
		
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}