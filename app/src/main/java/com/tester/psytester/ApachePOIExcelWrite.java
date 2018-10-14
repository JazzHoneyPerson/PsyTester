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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static android.os.Environment.DIRECTORY_DOCUMENTS;

public class ApachePOIExcelWrite {
    private static Map<String, Integer> hashMap;

    public static int getIndex(String str){
        if(hashMap==null) {
            hashMap = new HashMap<>();
            hashMap.put("Реакция на цвет", 1);
            hashMap.put("Реакция на звук", 3);
            hashMap.put("Реакция на цвет в области экрана", 5);
            hashMap.put("Распознавние четных чисел", 7);
            hashMap.put("Распознавание цвета", 9);
            hashMap.put("Сосредоточенность внимания", 11);
        }
        return hashMap.get(str);
    }
    public static int countRowNum(Iterator<Row> iterator,String Name){
        int rowNum = 0;
        String currName="#";
        while (iterator.hasNext()&&!currName.equals(Name)||rowNum==0) {
            Row currentRow = iterator.next();
            Cell cell=currentRow.getCell(0);
            if(cell!=null)
                currName=cell.getStringCellValue();
            if(currName.equals(Name))
                rowNum--;
            rowNum++;
        }
        return rowNum;
    }

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
        String Name=Worker.Companion.getName();
        if(Name=="") Name="Аноним";
        int rowNum = countRowNum(sheet.iterator(),Worker.Companion.getName());
        Row row=sheet.getRow(rowNum);
        if(row==null)
             row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(Worker.Companion.getName());
        for (Control datatype : Worker.Companion.getControles()) {
            int colNum = 1;
            int index =getIndex(datatype.getNameTest());
            row.createCell(index).setCellValue(datatype.getTime());
            row.createCell(index+1).setCellValue(datatype.getCountOfMistakes());
            if(datatype.getNameTest().equals("Сосредоточенность внимания"))
                row.createCell(index+2).setCellValue(datatype.getCountOfMissed());
        }


    FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
    workbook.write(outputStream);
    workbook.close();



}}
