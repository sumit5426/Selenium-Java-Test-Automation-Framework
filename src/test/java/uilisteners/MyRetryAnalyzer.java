package uilisteners;

import Constants.Env;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import uiutility.JsonUtility;
import uiutility.LoggerUtility;
import uiutility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final int MAX_NUM_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUM_OF_ATTEMPTS"));
   // private static final int MAX_NUM_OF_ATTEMPTS = JsonUtility.readJSON(Env.QA).getMAX_NUM_OF_ATTEMPTS();
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult result) {
        logger.info("Test Case is going to enter in reTry analyzer");
        logger.info("Retry Analyzer: Test Case - " + result.getMethod().getMethodName());

        if (currentAttempt < MAX_NUM_OF_ATTEMPTS) {
            logger.info("Attempt no in the retry Analyser is "+currentAttempt);
            currentAttempt++;
            return true;
        }
        logger.warn("Maximum no of retry limit is existed :"+ result.getMethod().getMethodName());

        return false;
    }
}
