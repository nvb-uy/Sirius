package agnya.sirius.api.management;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parser {
    public static final Logger LOGGER = LoggerFactory.getLogger("sirius-api");
    
    public static final String COMMENT = "#";

    public class Data {
        private static String[] parse(File file, String filename, String[] data) {
            try {
                data = Files.readAllLines(file.toPath()).toArray(new String[0]);
            } catch (IOException exception) {
                LOGGER.error(String.format("Failed to read file '%s'", filename), exception);
            }

            // This will allow comments in files using #.
            for (int i = 0; i < data.length; i++) {
                if (data[i].startsWith(COMMENT)) {
                    data[i] = "$comment";
                }
            }

            return data;
        }
        
        public static String[] getData(String folder, String filename, String extension) {
            /* Returns an array with every line of the file as an element.
             *  This can be used to read every line as a block id to use autoregistering.
             *  Or to make quick configs using the startsWith method.
                
                // While using AddonMaker in a mod, you must check for comments in your files.
                //  Example when checking in a for loop:
                //      if (lines[i] == "$comment") continue;
             */

            File file = new File(String.format("./%s/%s.%s", folder, filename, extension));
            String[] lines = new String[0];
            
            return parse(file, filename, lines);
        }
    }

}
