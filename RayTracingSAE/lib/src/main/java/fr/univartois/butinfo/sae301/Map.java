package fr.univartois.butinfo.sae301;

import java.awt.Graphics;

public class Map extends SceneObject{
	private double width;
	private double height;
	public Map (Vector pos, Color color, double width, double height) {
		super(pos, color);
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(pos.getX(), pos.getY(), width, height);
	}
}