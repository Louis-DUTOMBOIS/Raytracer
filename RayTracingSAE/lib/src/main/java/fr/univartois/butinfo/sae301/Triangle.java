package fr.univartois.butinfo.sae301;

public class Triangle implements ISceneObject{
	/*
     * The vectices of the triangle.
     */
	private Point point1;
	private Point point2;
	private Point point3;
	private Color color;
	/*
     * Creates a new triangle with the given vector, color and radius.
     *
     * @param color The color of the triangle.
     * @param radius The radius of the triangle.
     */
	public Triangle(Color color, Point point1, Point point2, Point point3) {
		this.color = color;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
	@Override
	public Point getOrigin() {
		return point1;
	}
	public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	public Point getPoint3() {
		return point3;
	}
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
