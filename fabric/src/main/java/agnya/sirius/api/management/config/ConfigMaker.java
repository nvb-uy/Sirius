package agnya.sirius.api.management.config;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import agnya.sirius.api.management.Parser;

public class ConfigMaker {
    
    public static final Logger LOGGER = LoggerFactory.getLogger("sirius-api");
    
    public static void setup(String folder) {
        /* Setups a folder for configs.
         */

        if (!new File("./config/%s", folder).exists()) {
            new File(String.format("./config/%s", folder)).mkdirs();
        }
    }

    public static void create(String folder, String filename, String extension) {
        /* Creates a new config file.
         */
        if (!new File(String.format("./config/%s/%s.%s", folder, filename, extension)).exists()) {
            try {
                new File(String.format("./config/%s/%s.%s", folder, filename, extension)).createNewFile();
            } catch (IOException exception) {
                LOGGER.error(String.format("Failed to create file %s", filename), exception);
            }
        }
    }

    public static String[] readLines(String folder, String filename, String extension) {
        /* Returns an array with every line of the file as an element.
        *  This can be used to read every line as a block id to use autoregistering.
            
        // While using AddonMaker in a mod, you must check for comments in your files.
        //  Example when checking in a for loop:
        //      if (lines[i] == "$comment") continue;
        */
        
        return Parser.Data.getData(folder, filename, extension);
    }

    public static String findKey(String line, String[] lines) {
        /* Finds a specific line
        */
        
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].startsWith("$comment") &&
                lines[i].contains(line)) {
                
                return lines[i];
            }
        }
        return null;
    }
}
