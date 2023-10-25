package fr.univartois.butinfo.sae301;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

	private int width = 0;
	private int height = 0;
	private int maxverts = 0;
	private String pictureFileName = "output.png";
	private Camera camera= null;
	private Color ambientColors = null;
	private Color diffuseColors = null;
	private Color specularColors = null;
	private int shininessValues = 0;
	private List<Light> lights = new ArrayList<>();
	private List<PointLight> pointsLight = new ArrayList<>();
	private List<Point> points = new ArrayList<>();
	private List<Triangle> triangles = new ArrayList<>();
	private List<Sphere> spheres = new ArrayList<>();
	private List<Plane> planes = new ArrayList<>();
	private boolean shadow = false;

	public int getMaxverts() {
		return maxverts;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public Camera getCamera() {
		return camera;
	}

	public Color getAmbientColors() {
		return ambientColors;
	}

	public Color getDiffuseColors() {
		return diffuseColors;
	}

	public Color getSpecularColors() {
		return specularColors;
	}

	public int getShininessValues() {
		return shininessValues;
	}

	public List<Light> getLights() {
		return lights;
	}

	public List<PointLight> getPointsLight() {
		return pointsLight;
	}

	public List<Point> getPoints() {
		return points;
	}

	public List<Triangle> getTriangles() {
		return triangles;
	}

	public List<Sphere> getSpheres() {
		return spheres;
	}

	public List<Plane> getPlanes() {
		return planes;
	}

	public void read(File text) throws FileNotFoundException {
		Scanner scanner = new Scanner(text);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			if (line.startsWith("#") || line.isEmpty()) {
				continue;
			}
			String[] parts = line.split("\\s+");
			if (parts.length > 1) {
				String key = parts[0];
				switch (key) {
				case "size":
					width = Integer.parseInt(parts[1]);
					height = Integer.parseInt(parts[2]);
					break;
				case "output":
					pictureFileName = parts[1];
					break;
				case "camera":
					camera = new Camera(
							new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							new Point(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6])),
							new Vector(Double.parseDouble(parts[7]), Double.parseDouble(parts[8]),
									Double.parseDouble(parts[9])),
							Integer.parseInt(parts[10]));
					break;
				case "ambient":
					ambientColors = new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]));
					break;
				case "diffuse":
					diffuseColors = new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]));
					break;
				case "specular":
					specularColors = new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]));
					break;
				case "shininess":
					shininessValues = Integer.parseInt(parts[1]);
					break;
				case "directional":
					lights.add(new DirectionalLight(
							new Vector(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							new Color(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6]))));
					break;
				case "point":
					pointsLight.add(new PointLight(
							new Vector(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							new Color(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6]))));
					break;
				case "maxverts":
					maxverts = Integer.parseInt(parts[1]);
					break;
				case "vertex":
					points.add(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])));
					break;
				case "tri":
					if (parts.length >= 4) {
						int values1 = Integer.parseInt(parts[1]);
						int values2 = Integer.parseInt(parts[2]);
						int values3 = Integer.parseInt(parts[3]);
						if (values1 >= 0 && values1 < points.size() && values2 >= 0 && values2 < points.size()
								&& values3 >= 0 && values3 < points.size()) {
							triangles.add(new Triangle(diffuseColors, points.get(values1), points.get(values2),
									points.get(values3)));
						}
					}
					break;
				case "sphere":
					spheres.add(new Sphere(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])), ambientColors, Double.parseDouble(parts[4])));
					break;
				case "plane":
					planes.add(new Plane(
							new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							new Vector(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							ambientColors));
					break;
				case "shadow":
					if (parts[1] == "true") {
						this.shadow=true;
					}
				default:
					break;
				}
			}
		}
	}

	public Scene constructScene() {
		SceneBuilder sceneBuild = SceneBuilder.newInstance();
		sceneBuild.setImageHeight(height);
		sceneBuild.setImageWidth(width);
		sceneBuild.setOutputFileName(pictureFileName);
		sceneBuild.setCamera(camera);
		for (int i = 0; i < lights.size(); i++) {
			sceneBuild.addLight(lights.get(i));
		}
		for (int i = 0; i < lights.size(); i++) {
			sceneBuild.addLight(pointsLight.get(i));
		}
		for (int i = 0; i < planes.size(); i++) {
			sceneBuild.addSceneObject(planes.get(i));
		}
		for (int i = 0; i < spheres.size(); i++) {
			sceneBuild.addSceneObject(spheres.get(i));
		}
		for (int i = 0; i < triangles.size(); i++) {
			sceneBuild.addSceneObject(triangles.get(i));
		}
		return sceneBuild.build();
	}
}
