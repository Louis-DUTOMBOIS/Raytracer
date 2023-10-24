package fr.univartois.butinfo.sae301;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

	int width = 0;
	int height = 0;
	int maxverts = 0;
	String pictureFileName = "picture.png";
	Camera camera= null;
	List<Color> ambientColors = new ArrayList<>();
	List<Color> diffuseColors = new ArrayList<>();
	List<Color> specularColors = new ArrayList<>();
	List<Integer> shininessValues = new ArrayList<>();
	List<Light> lights = new ArrayList<>();
	List<PointLight> pointsLight = new ArrayList<>();
	List<Point> points = new ArrayList<>();
	List<Triangle> triangles = new ArrayList<>();
	List<Sphere> spheres = new ArrayList<>();
	List<Plane> planes = new ArrayList<>();

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

	public List<Color> getAmbientColors() {
		return ambientColors;
	}

	public List<Color> getDiffuseColors() {
		return diffuseColors;
	}

	public List<Color> getSpecularColors() {
		return specularColors;
	}

	public List<Integer> getShininessValues() {
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

	public void read() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("fileParser.txt"));

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
					camera = new Camera(new Point(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])
                        ), new Point(
                            Double.parseDouble(parts[4]),
                            Double.parseDouble(parts[5]),
                            Double.parseDouble(parts[6])
                        ), new Point(
                            Double.parseDouble(parts[7]),
                            Double.parseDouble(parts[8]),
                            Double.parseDouble(parts[9])
                        ), Integer.parseInt(parts[10]));
					break;
				case "ambient":
					ambientColors.add(new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])));
					break;
				case "diffuse":
					diffuseColors.add(new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])));
					break;
				case "specular":
					specularColors.add(new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])));
					break;
				case "shininess":
					shininessValues.add(Integer.parseInt(parts[1]));
					break;
				case "directional":
					lights.add(new DirectionalLight(
							new Vector(Double.parseDouble(parts[1]), 
									Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							new Color(Double.parseDouble(parts[4]), 
									Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6]))));
					break;
				case "point":
					pointsLight.add( new PointLight(new Vector(Double.parseDouble(parts[1]), 
							Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3])),
					new Color(Double.parseDouble(parts[4]), 
							Double.parseDouble(parts[5]),
							Double.parseDouble(parts[6]))));
					break;
				case "maxverts":
					maxverts = Integer.parseInt(parts[1]);
					break;
				case "vertex":
					points.add(new Point(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])
                        ));
                    break;
				case "tri":
					if (parts.length >= 4) {
                        int values1 = Integer.parseInt(parts[1]);
                        int values2 = Integer.parseInt(parts[2]);
                        int values3 = Integer.parseInt(parts[3]);
                        if (values1 >= 0 && values1 < points.size() && values2 >= 0 && values2 < points.size() && values3 >= 0 && values3 < points.size()) {
                            triangles.add(new Triangle(diffuseColors.get(0), points.get(values1), points.get(values2), points.get(values3)));
                        }
                    }
                    break;
				case "sphere":
					spheres.add(new Sphere(
                            new Point(
                                Double.parseDouble(parts[1]),
                                Double.parseDouble(parts[2]),
                                Double.parseDouble(parts[3]
                            )),
                            diffuseColors.get(0), Double.parseDouble(parts[4])
                        ));
                        break;
				case "plane":
					planes.add(new Plane(new Point(Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]
                        )),new Vector(Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]
                        ))));
					break;
				default:
                    break;
				}
			}
		}
	}
	
	public void constructScene() {
		SceneBuilder sceneBuild = null;
		sceneBuild.newInstance();
		sceneBuild.setImageHeight(height);
		sceneBuild.setImageWidth(width);
		sceneBuild.setOutputFileName(pictureFileName);
		sceneBuild.setCamera(camera);
		for (int i=0; i<lights.size() ; i++) {
			sceneBuild.addLight(lights.get(i));
		}
		for (int i=0; i<lights.size() ; i++) {
			sceneBuild.addLight(pointsLight.get(i));
		}
		sceneBuild.addSceneObject((ISceneObject) planes);
		sceneBuild.addSceneObject((ISceneObject) spheres);
		sceneBuild.addSceneObject((ISceneObject) triangles);	
	}
}
