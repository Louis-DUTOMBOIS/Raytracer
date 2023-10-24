package fr.univartois.butinfo.sae301;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Il n'y a pas de fichier");
            System.exit(1);
        }

        File file = new File(args[0]) ;
        
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






