package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Sphere extends SceneObject{
	private double radius;
	public Sphere(Vector pos, Color color, double radius) {
		super(pos, color);
		this.radius = radius;
	}
	public void render(Graphics g) {
		int x = pos.getX() - radius;
		int y = pos.getY() - radius;
		int diameter = (int) (2*radius);
		g.setColor(color);
		g.fillOval(x, y, diameter, diameter);
	}
}