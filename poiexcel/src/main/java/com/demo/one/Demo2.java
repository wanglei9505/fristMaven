package com.demo.one;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Excel文件读取
 * Created by WL on 2017/9/17.
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream=new FileInputStream("D:\\poi_1.xls");
            POIFSFileSystem sf=new POIFSFileSystem(inputStream);
            HSSFWorkbook workbook=new HSSFWorkbook(sf);
            //获取sheet页
            HSSFSheet sheet=workbook.getSheetAt(0);
            if (sheet == null){
                return;
            }
            //遍历行
            for (int rowNum=0;rowNum<=sheet.getLastRowNum();rowNum++){
                HSSFRow row=sheet.getRow(rowNum);
                if (row == null ){
                    continue;
                }
                //遍历列
                for (int cellNum=0;cellNum<=row.getLastCellNum();cellNum++){
                    HSSFCell cell=row.getCell(cellNum);
                    if (cell==null){
                        continue;
                    }
                    System.out.print(" "+getCellValue(cell));
                }
                System.out.println();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellValue(HSSFCell hssfCell){
        if (hssfCell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(hssfCell.getBooleanCellValue());
        }else if (hssfCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
            return String.valueOf(hssfCell.getNumericCellValue());
        }else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
