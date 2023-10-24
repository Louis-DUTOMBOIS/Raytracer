package fr.univartois.butinfo.sae301;

public class Plane implements ISceneObject{
	private Point pos;
	private Vector normal;
	/*
     * Creates a new plane with the given vector, color and radius.
     *
     * @param vector The vector of the plane.
     * @param color The color of the plane.
     * @param width The width of the plane.
     * @param height The height of the plane.
     */
	public Plane (Point pos, Vector normal) {
		this.pos = pos;
		this.normal = normal;
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
	

}