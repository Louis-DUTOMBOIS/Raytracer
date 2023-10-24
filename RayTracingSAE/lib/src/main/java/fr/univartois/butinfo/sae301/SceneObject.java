package fr.univartois.butinfo.sae301;

public abstract class SceneObject {
	protected Vector pos;
	protected Color color;
	public SceneObject(Vector pos, Color color) {
		this.pos = pos;
		this.color = color;
	}
	public void translate(Vector translation) {
		pos.add(translation);
	}
}
