package uilisteners;

import Constants.Env;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import uiutility.JsonUtility;
import uiutility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUM_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUM_OF_ATTEMPTS"));
   // private static final int MAX_NUM_OF_ATTEMPTS = JsonUtility.readJSON(Env.QA).getMAX_NUM_OF_ATTEMPTS();
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt < MAX_NUM_OF_ATTEMPTS) {
            currentAttempt++;
            return true;
        }

        return false;
    }
}
