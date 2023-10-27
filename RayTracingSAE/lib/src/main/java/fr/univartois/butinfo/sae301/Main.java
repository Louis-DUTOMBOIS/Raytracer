package fr.univartois.butinfo.sae301;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The `Main` class is the entry point for the application that reads a scene description file, constructs a 3D scene,
 * and generates an image based on the scene description.
 *
 * @author Theo, Louis, Hugo, Alex
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No file provided.");
            System.exit(1);
        }

        File file = new File(args[0]);

        Parser parser = new Parser();

        try {
            parser.read(file);
            Scene s = parser.constructScene();
            CreatePicture picture = new CreatePicture(s);
            picture.getMyImage();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
            System.exit(1);
        }
    }
}
