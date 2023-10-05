package com.epam.mjc.nio;

import java.io.*;
import java.util.logging.Logger;
public class FileReader {

    public Profile getDataFromFile(File file) {
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Profile profile = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder textSB = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textSB.append(line).append(" ");
            }
            String text = textSB.toString();
            String[] parts = text.split(" ");
            profile = new Profile(parts[1], Integer.valueOf(parts[3]), parts[5], Long.valueOf(parts[7]));
        } catch (IOException e) {
            log.info(e.toString());
        }
        return profile;
    }
}
