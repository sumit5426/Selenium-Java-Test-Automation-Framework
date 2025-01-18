package uiutility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uipojo.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<Object[]> readExcelFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "//TestData//" + fileName);
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        List<User> userList = new ArrayList<>();
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginDataSheet");
        Iterator<Row> rowIterator = xssfSheet.iterator();
        rowIterator.next();//skipping 1st row
        Row row;
        Cell emaillAddressCell;
        Cell passwordCell;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            emaillAddressCell = row.getCell(0);
            passwordCell = row.getCell(1);
            //if it is numeric
            double num =passwordCell.getNumericCellValue();
            // Create User object with the string values
            User user = new User(emaillAddressCell.toString(), passwordCell.toString());
            // Store the username and password in an array
            // userList.add(new String[]{username, password}); then test arugment will be string
            userList.add(user);

        }
        try {
            xssfWorkbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Object[]> userToObject = new ArrayList<>();
        for (User userDetails : userList) {
            userToObject.add(new Object[]{userDetails});
        }

        return userToObject.iterator();


    }
}
