package com.demo.one;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by WL on 2017/9/17.
 */
public class Demo3 {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream=new FileInputStream("D:\\poi_1.xls");
        POIFSFileSystem sf=new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook=new HSSFWorkbook(sf);

        ExcelExtractor excelExtractor=new ExcelExtractor(workbook);
        excelExtractor.setIncludeSheetNames(false);
        System.out.println(excelExtractor.getText());
    }
}
