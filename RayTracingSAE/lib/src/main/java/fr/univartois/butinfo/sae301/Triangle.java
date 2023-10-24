package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Triangle extends SceneObject{
	private Vector[] vertices;
	public Triangle(Vector pos, Color color, Vector[] vertices) {
		super(pos, color);
		this.vertices = vertices;
	}
	public void render(Graphics g) {
		g.setColor(color);
		int[] xPoint = new int[3];
		int[] yPoint = new int[3];
		for(int i = 0; i<3; i++) {
			xPoint[i] = pos.getX() + vertices[i].getX();
			yPoint[i] = pos.getY() + vertices[i]getY();
		}
		g.fillPolygon(xPoint, yPoint, 3);
	}
}
