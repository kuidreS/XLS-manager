package com.vserdiuk.xls.xls;

import com.vserdiuk.xls.entity.Company;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by vserdiuk on 30.07.16.
 */
public class WriterImpl implements Writer {

    public void createXLS(List<Company> companies) throws FileNotFoundException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        Row row = sheet.createRow(0);

        Cell name = row.createCell(0);
        name.setCellValue("Company name");

        Cell email = row.createCell(1);
        email.setCellValue("Email");

        Cell domain = row.createCell(2);
        domain.setCellValue("Web page");

        Cell isFreeEmailDomain = row.createCell(3);
        isFreeEmailDomain.setCellValue("Is free email domain");

        Cell isEmailValid = row.createCell(4);
        isEmailValid.setCellValue("Is email valid");

        Cell isInterior = row.createCell(5);
        isInterior.setCellValue("Is interior");

        Cell isBuilding = row.createCell(6);
        isBuilding.setCellValue("Is building");

        Cell isFurniture = row.createCell(7);
        isFurniture.setCellValue("Is furniture");

        Cell isArchitecture = row.createCell(8);
        isArchitecture.setCellValue("Is architecture");

        int rowNumb = 1;
        for (Company company : companies) {
            row = sheet.createRow(rowNumb++);
            name = row.createCell(0);
            name.setCellValue(company.getName());

            email = row.createCell(1);
            email.setCellValue(company.getEmail());

            domain = row.createCell(2);
            String webPage;
            if (company.getWebPage().equals("Not available")) {
                webPage = company.getWebPage();
            } else {
                webPage = "http://" + company.getWebPage();
            }
            domain.setCellValue(webPage);

            isFreeEmailDomain = row.createCell(3);
            isFreeEmailDomain.setCellValue(company.isFreeEmailDomain());

            isEmailValid = row.createCell(4);
            isEmailValid.setCellValue(company.isEmailValid());

            isInterior = row.createCell(5);
            isInterior.setCellValue(company.isInterior());

            isBuilding = row.createCell(6);
            isBuilding.setCellValue(company.isBuilding());

            isFurniture = row.createCell(7);
            isFurniture.setCellValue(company.isFurniture());

            isArchitecture = row.createCell(8);
            isArchitecture.setCellValue(company.isArchitecture());
        }
        sheet.autoSizeColumn(1);

        try {
            String path = System.getProperty("user.home") + "/Desktop/result.xls";
            book.write(new FileOutputStream(path));
            System.out.println("Excel file have written successfuly");
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
