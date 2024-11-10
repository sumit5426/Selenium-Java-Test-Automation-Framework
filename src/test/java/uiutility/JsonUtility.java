package uiutility;

import Constants.Env;
import com.google.gson.Gson;
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
        Config config=gson.fromJson(fileReader, Config.class);
        Environment environment=config.getEnvironments().get("QA");
        return environment;

    }
}
