package fr.univartois.butinfo.sae301;

import java.awt.Color;
import java.util.Vector;

public abstract class SceneObject {
	protected Vector pos;
	protected Color color;
	public SceneObject(Vector pos, Color color) {
		this.pos = pos;
		this.color = color;
	}
	public void translate(Vector translation) {
		pos = pos.add(translation);
	}
}
