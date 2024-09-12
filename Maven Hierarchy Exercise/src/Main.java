import Domain.*;
import Exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    private static Logger logger;
    public static void main(String[] args) {
        logger = LogManager.getLogger(Main.class);
        File file = new File("resources/text.txt");
        try{
            String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("Text of the file: " + string);
            // Using countMatches (LESS ROBUST)
            System.out.println("(countMatches method) \nFile has " + (1 + StringUtils.countMatches(string, " ")) + " words.");

            // Using split (ROBUST)
            String[] words = StringUtils.split(string);
            System.out.println("(split method) \nFile has " + words.length + " words.");

        } catch(IOException e){
            logger.error("An IOException occurred while reading the file: " + file.getAbsolutePath(), e);
        }
    }
}

