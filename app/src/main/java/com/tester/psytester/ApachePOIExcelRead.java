package com.tester.psytester;

import android.os.Environment;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ApachePOIExcelRead {
    private static final String FILE_NAME =  Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Aa.xlsx";

    public static String main() {
        String result="";
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new HSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                   // if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        result+=currentCell.getStringCellValue() + "\n";
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        result+=currentCell.getNumericCellValue() + "\n";
//                    }

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
