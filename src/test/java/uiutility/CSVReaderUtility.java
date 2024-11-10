package uiutility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import uipojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<Object[]> readCSVFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "//TestData//" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList = null;
        User userData;
        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); //1st column
            userList = new ArrayList<>();


            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        // Convert List<User> to List<Object[]>
        List<Object[]> userToObject = new ArrayList<>();
        for (User userDetail : userList) {
            userToObject.add(new Object[]{userDetail});
        }
        return userToObject.iterator();

    }
}
