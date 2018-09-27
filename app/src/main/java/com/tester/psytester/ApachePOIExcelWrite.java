package com.tester.psytester;

import android.os.Environment;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import static android.os.Environment.DIRECTORY_DOCUMENTS;

public class ApachePOIExcelWrite {


    public static void main() throws IOException {
        final String FILE_NAME =  Environment.getExternalStorageDirectory()+ "/Aa.xls";
        FileInputStream excelFile;
        Workbook workbook;
        Sheet sheet;
        try {
            excelFile = new FileInputStream(new File(FILE_NAME));
            workbook = new HSSFWorkbook(excelFile);
            sheet = workbook.getSheetAt(0);
        }
        catch(Exception e)
        {

            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet();
        }


        int rowNum = 0;

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            Cell currentCell = cellIterator.next();
            if(currentCell.getStringCellValue()=="")
                break;
            rowNum++;
        }

        for (Control datatype : Worker.Companion.getControles()) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 1;
            row.createCell(0).setCellValue(Worker.Companion.getName());
            for (String field : datatype.toStringArray()) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(field);
            }
        }


    FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
    workbook.write(outputStream);
    workbook.close();



}}
