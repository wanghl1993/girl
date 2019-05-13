package com.imooc.utils.demo;


import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.service.spi.ServiceException;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    public static void main(String[] args) {
        File test = new File("D:\\test.xlsx");
        List<String> list = new ArrayList<String>();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(test));
//            SXSSFWorkbook workbook = new SXSSFWorkbook(wb);
            Sheet sheet = wb.getSheetAt(0);
            for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = wb.getSheetAt(numSheet);

                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow == null) {
                        continue;
                    }
                    if (xssfRow.getCell(0) == null) {
                        continue;
                    }
                    xssfRow.getCell(0).setCellType(xssfRow.getCell(0).CELL_TYPE_STRING);

                    if(StringUtils.isNotBlank(xssfRow.getCell(0).getStringCellValue().trim())){

                        list.add(xssfRow.getCell(0).getStringCellValue().trim());
                    }

                }

            }

//            for (int i = 0; i <= 5; i++) {
//                Row row = sheet.getRow(i);
//                System.out.println("第" + i + "行" + "row值为==>" + row);
//                if (row == null) {
//                    System.out.println(i + ":null");
//                }
//            }
        } catch (Exception e) {
            throw new ServiceException(":",e);
        }
    }


}
