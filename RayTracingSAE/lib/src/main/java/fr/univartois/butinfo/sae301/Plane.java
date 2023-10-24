package fr.univartois.butinfo.sae301;

public class Plane extends SceneObject{
	private int width;
	private int height;
	public Plane (Vector pos, Color color, int width, int height) {
		super(pos, color);
		this.width = width;
		this.height = height;
	}

}