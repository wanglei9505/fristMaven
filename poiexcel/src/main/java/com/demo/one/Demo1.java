package com.demo.one;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by WL on 2017/9/17.
 */
public class Demo1 {

    public static void main(String[] args) {
        Workbook workbook=new HSSFWorkbook();//定义一个工作簿
        try {
            FileOutputStream outputStream=new FileOutputStream("d://poi_1.xls");
            //创建sheet
            Sheet sheet=workbook.createSheet("第一个sheet");
            Sheet sheet2=workbook.createSheet("第er个sheet");
            //创建行列
            //创建第一行
            Row row=sheet.createRow(0);
            //创建第一列第一个单元格
            Cell cell=row.createCell(0);
            //给单元格设置值
            cell.setCellValue(1);

            row.createCell(1).setCellValue(1.2);//第二列
            row.createCell(2).setCellValue("第三列");//第三列

            CreationHelper helper=workbook.getCreationHelper();
            CellStyle cellStyle=workbook.createCellStyle();
            cellStyle.setDataFormat(helper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
            Cell cell1=row.createCell(3);
            cell1.setCellValue(new Date());
            cell1.setCellStyle(cellStyle);

            workbook.write(outputStream);
            outputStream.close();
            System.out.println("创建成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
