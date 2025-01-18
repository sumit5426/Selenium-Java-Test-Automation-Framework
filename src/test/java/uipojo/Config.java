package uipojo;

import java.util.Map;
//Config class represents the root structure of the JSON file.
public class Config {
    Map<String, Environment> environments;

    //Key (String): The environment name (e.g., "QA", "PROD").
    //Value (Environment): The configuration details for that environment.

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Environment> environments) {
        this.environments = environments;
    }
}
