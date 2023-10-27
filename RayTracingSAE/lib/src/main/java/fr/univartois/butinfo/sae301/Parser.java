package fr.univartois.butinfo.sae301;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author hugo, louis, théo, alex
 *
 */

/**
 * The Parser class is responsible for parsing a text-format scene file and
 * creating a 3D scene based on the extracted information.
 */

public class Parser {
	
	// existing attributes

	private int width = 0;
	private int height = 0;
	private int maxverts = 0;
	private String pictureFileName = "output.png";
	private Camera camera = null;
	private Color ambientColors = new Color(0, 0, 0);
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

	/**
     * The width of the 3D scene.
     *
     * @return The width of the scene.
     */
    public int getWidth() {
        return width;
    }

    /**
     * The height of the 3D scene.
     *
     * @return The height of the scene.
     */
    public int getHeight() {
        return height;
    }

    /**
     * The maximum number of vertices in the scene.
     *
     * @return The maximum number of vertices.
     */
    public int getMaxverts() {
        return maxverts;
    }

    /**
     * The filename for the output picture of the scene.
     *
     * @return The output picture filename.
     */
    public String getPictureFileName() {
        return pictureFileName;
    }

    /**
     * The camera used in the scene.
     *
     * @return The camera object.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * The ambient color of the scene.
     *
     * @return The ambient color.
     */
    public Color getAmbientColors() {
        return ambientColors = new Color(0, 0, 0);
    }

    /**
     * The diffuse color of the scene.
     *
     * @return The diffuse color.
     */
    public Color getDiffuseColors() {
        return diffuseColors;
    }

    /**
     * The specular color of the scene.
     *
     * @return The specular color.
     */
    public Color getSpecularColors() {
        return specularColors;
    }

    /**
     * The shininess value of the scene.
     *
     * @return The shininess value.
     */
    public int getShininessValues() {
        return shininessValues;
    }

    /**
     * The list of lights in the scene.
     *
     * @return A list of lights.
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * The list of point lights in the scene.
     *
     * @return A list of point lights.
     */
    public List<PointLight> getPointsLight() {
        return pointsLight;
    }

    /**
     * The list of points in the scene.
     *
     * @return A list of points.
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * The list of triangles in the scene.
     *
     * @return A list of triangles.
     */
    public List<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * The list of spheres in the scene.
     *
     * @return A list of spheres.
     */
    public List<Sphere> getSpheres() {
        return spheres;
    }

    /**
     * The list of planes in the scene.
     *
     * @return A list of planes.
     */
    public List<Plane> getPlanes() {
        return planes;
    }
	
	/**
     * Parses a text-format scene file and constructs a 3D scene based on its content.
     *
     * @param text The text-format scene file to be parsed.
     * @throws FileNotFoundException If the specified file is not found.
     */

	public void read(File text) throws FileNotFoundException {
		
		//(code for reading and parsing the file)
		
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
									Double.parseDouble(parts[3]), ambientColors),
							new Point(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6]), ambientColors),
							new Vector(Double.parseDouble(parts[7]), Double.parseDouble(parts[8]),
									Double.parseDouble(parts[9])),
							Integer.parseInt(parts[10]));
					break;
				case "ambient":
					ambientColors = new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]));
					diffuseColors = ambientColors;
					break;
				case "diffuse":
					diffuseColors = new Color(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]));
					if (ambientColors.getTrip().getX() + diffuseColors.getTrip().getX() <= 1) {
						if (ambientColors.getTrip().getY() + diffuseColors.getTrip().getY() <= 1) {
							if (ambientColors.getTrip().getZ() + diffuseColors.getTrip().getZ() <= 1) {
								break;
							} else
								System.err.println("entrée incorrecte ");
						} else
							System.err.println("entrée incorrecte ");
					} else
						System.err.println("entrée incorrecte ");

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
					lights.add(new PointLight(
							new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3]), ambientColors),
							new Color(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
									Double.parseDouble(parts[6]))));
					break;
				case "maxverts":
					maxverts = Integer.parseInt(parts[1]);
					break;
				case "vertex":
					points.add(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
							Double.parseDouble(parts[3]), ambientColors));
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
					spheres.add(new Sphere(
							new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3]), ambientColors),
							diffuseColors, Double.parseDouble(parts[4])));
					break;
				case "plane":
					planes.add(new Plane(
							new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3]), ambientColors),
							new Vector(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
									Double.parseDouble(parts[3])),
							diffuseColors));
					break;
				case "shadow":
					if (parts[1].equals("true")) {
						this.shadow=true;
					}
				default:
					break;
				}
			}
		}
	}

	/**
     * Constructs an instance of the Scene class using the information extracted from the scene file.
     *
     * @return An instance of the Scene class representing the 3D scene.
     */
	
	public Scene constructScene() {
		
		//(code for building the scene)
		
		SceneBuilder sceneBuild = SceneBuilder.newInstance();
		sceneBuild.setImageHeight(height);
		sceneBuild.setImageWidth(width);
		sceneBuild.setOutputFileName(pictureFileName);
		sceneBuild.setCamera(camera);
		sceneBuild.setShadow(shadow);
		for (int i = 0; i < lights.size(); i++) {
			sceneBuild.addLight(lights.get(i));
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
