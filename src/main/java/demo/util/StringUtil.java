package demo.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringUtil {

    private static final Logger LOGGER = Logger.getLogger(StringUtil.class.getName());

    public static String getContentFromInputStream(InputStream inputStream) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                contentBuilder.append((char) c);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, String.format("Error %s", e.getMessage()));
        }
        return contentBuilder.toString();
    }
}
