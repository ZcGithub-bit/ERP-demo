package com.example.springBootDemo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCsv{
	
	/**
	 * 替换CSV文件内容中的英文逗号
	 * @param path
	 */
	public static void readCSV(String path) {
        String charset = "GBK" ;
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), charset))).build()) {
            Iterator<String[]> iterator = csvReader.iterator();
            while (iterator.hasNext()) {
                Arrays.stream(iterator.next()).forEach(System.out::print);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/**
	  * @param srcPath  csv文件路径
	  */
	 private static void readCSVFileData(String srcPath) {
	        BufferedReader reader = null;
	        String line = null;
	        try {
	            reader = new BufferedReader(new FileReader(srcPath));
	        } catch (FileNotFoundException e) {
//	            logger.error("[读取CSV文件，插入数据时，读取文件异常]");
	            e.printStackTrace();
	        }
	        String[] fieldsArr = null;
	        int lineNum = 0;
	        int insertResult = 0;
	        try {
	            List listField;
	            while ((line = reader.readLine()) != null) {
	                if (lineNum == 0) {
	                    //表头信息
	                    fieldsArr = line.split(",");
	                } else {
	                    //数据信息
	                    listField = new ArrayList<>();
	                    String str;
	                    line += ",";               
	                    Pattern pCells = Pattern
	                            .compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");
	                    Matcher mCells = pCells.matcher(line);
	                    List cells = new LinkedList();//每行记录一个list
	                    //读取每个单元格
	                    while (mCells.find()) {
	                        str = mCells.group();
	                        str = str.replaceAll(
	                                ",", "，");
	                        str = str.replaceAll("(?sm)(\"(\"))", "$2");
	                        cells.add(str);
	                    }
	                    //从第2行起的数据信息list
	                    listField.add(cells);
	                }
	                lineNum++;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();    
	        }
	    }

	public static void main(String[] args) {
		readCSVFileData("/data/files/test.csv");
	}
		
}
