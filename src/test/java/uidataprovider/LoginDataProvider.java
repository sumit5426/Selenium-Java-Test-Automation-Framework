package uidataprovider;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import uipojo.TestData;
import uipojo.User;
import uiutility.CSVReaderUtility;
import uiutility.ExcelReaderUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {
    @DataProvider(name = "LoginTestDataProvider")
    public static Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson=new Gson();
        File testDataFile=new File(System.getProperty("user.dir") + "\\TestData\\loginData.json");
        FileReader fileReader= new FileReader(testDataFile);
        System.out.println(testDataFile);
        TestData data=gson.fromJson(fileReader, TestData.class); //deserlization
        List<Object[]> dataToReturn=new ArrayList<>();
        for(User user:data.getData()){
            dataToReturn.add(new Object[] {user});

        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<Object[]> loginCSVDataProvider(){
        return CSVReaderUtility.readCSVFile("logindata.csv");
    }
    @DataProvider(name = "loginExcelDataProvider")
    public Iterator<Object[]> loginExcelDataProvider(){

        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }
}
