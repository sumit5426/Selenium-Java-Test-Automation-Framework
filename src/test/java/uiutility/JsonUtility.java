package uiutility;

import Constants.Env;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import uipojo.Config;
import uipojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {

    public static Environment readJSON(Env env)  {
        Gson gson=new Gson();
        File jsonfFle=new File(System.getProperty("user.dir") + "//config//config.json");
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(jsonfFle);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // deserlization json to java
        // Converts the JSON data into a Config object.
        Config config=gson.fromJson(fileReader, Config.class);
        // Get specific environment
        Environment environment=config.getEnvironments().get(env.name());
        return environment;

    }
}
