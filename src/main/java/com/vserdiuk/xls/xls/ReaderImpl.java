package com.vserdiuk.xls.xls;

import com.vserdiuk.xls.entity.Company;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vserdiuk on 7/20/2016.
 */
public class ReaderImpl implements Reader {

    public List<Company> getCompanyList(String filePath) {
        List<Company> companies = new ArrayList<Company>();
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(new File(filePath));

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (filePath.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();

            //loop through each of the sheets
            for (int i = 0; i < numberOfSheets; i++) {

                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);

                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    String name = "";
                    String email = "";

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        //Get the Cell object
                        Cell cell = cellIterator.next();

                        //check the cell type and process accordingly
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                if (name.equalsIgnoreCase("")) {
                                    name = cell.getStringCellValue().trim();
                                } else if (email.equalsIgnoreCase("")) {
                                    //2nd column
                                    email = cell.getStringCellValue().trim();
                                }
                                break;
                        }
                    } //end of cell iterator
                    Company company = new Company();
                    company.setName(name);
                    company.setEmail(email);
                    companies.add(company);
                } //end of rows iterator


            } //end of sheets for loop

            //close file input stream
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel file have read successfuly");
        return companies;
    }

}
