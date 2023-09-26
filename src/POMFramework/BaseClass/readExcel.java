package POMFramework.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.common.primitives.Booleans;

public class readExcel extends baseClass
{

	
	//Files details

	String currDir=System.getProperty("user.dir");
	String inputFilePath = currDir + "/output/";
	String outputFilePath = currDir + "/output/";	
	String fileName="";
	String inputFilePathName=inputFilePath+"excelfile.xls";
	String outputFilePathName=outputFilePath+"excelfile.xls";
	//File file=new File(filePathName);
	
	//Initilizer
	Workbook workbook = null;
	
	public List<String> getListOfData(String fileName, String SheetName)
	{
		List<String> countriesList = new ArrayList<String>();
		
		workbook = ReadExcel(fileName);
		
		//Get the number of sheets in the xlsx file
		int numberOfSheets = workbook.getNumberOfSheets();
		
		//loop through each of the sheets
		for(int i=0; i < numberOfSheets; i++){
			//Get the nth sheet from the workbook
			Sheet sheet = (Sheet) workbook.getSheet(SheetName); //"input"
			
			//every sheet has rows, iterate over them
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
	        {
				String name = "";
				String shortCode = "";
				
				//Get the row object
				Row row = rowIterator.next();
				
				//Every row has columns, get the column iterator and iterate over them
				Iterator<Cell> cellIterator = row.cellIterator();
			
				while (cellIterator.hasNext()) 
	            {
	            	//Get the Cell object
	            	Cell cell = cellIterator.next();
	            	
	            	//check the cell type and process accordingly
	            	switch(cell.getCellType()){
	            	case STRING:
	            		if(shortCode.equalsIgnoreCase("")){
	            			shortCode = cell.getStringCellValue().trim();
	            		}else if(name.equalsIgnoreCase("")){
	            			//2nd column
	            			name = cell.getStringCellValue().trim();
	            		}else{
	            			//random data, leave it
	            			System.out.println("Random data::"+cell.getStringCellValue());
	            		}
	            		break;
	            	case NUMERIC:
	            		System.out.println("Random data::"+cell.getNumericCellValue());
					default:
						break;
	            	}
	            } //end of cell iterator
			
		}
		
		
		
		
		
		}	
		return countriesList;
			
		
	}
	
	public void WriteListOfData(String fileName, String SheetName, ArrayList<String> listOfStr)
	{
		List<String> StockList = listOfStr;
		
		workbook = ReadExcel(fileName);
		
		//Get the number of sheets in the xlsx file
		int numberOfSheets = workbook.getNumberOfSheets();
		
		//loop through each of the sheets
		for(int i=0; i < numberOfSheets; i++){
			//Get the nth sheet from the workbook
			Sheet sheet = (Sheet) workbook.getSheet(SheetName); //"input"
			int rowNum = ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum() + 1;
			
			for (String str :listOfStr) 
			{
				Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowNum++);
				Cell cell = row.createCell(rowNum++);
		        if (str instanceof String)
		            cell.setCellValue((String) str);
		      /*  else if (str instanceof Integer)
		            cell.setCellValue((Integer) obj); */
			}	
		}

	

		try {
			//lets write the excel data to file now
			FileOutputStream fos = new FileOutputStream(fileName);
			workbook.write(fos);
			fos.close();
			System.out.println(fileName + " written successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}	
		
	
	
	public Workbook ReadExcel(String fileName)
	{
		try(FileInputStream fis = new FileInputStream(new File(fileName)))
		{
			//Create Workbook instance for xlsx/xls file input stream
			
			if(fileName.toLowerCase().endsWith("xlsx")){
				//workbook = new Workbook(fis);
			}else if(fileName.toLowerCase().endsWith("xls")){
				workbook = new HSSFWorkbook(fis);
			}	
		}catch(Exception e)
		{
			System.out.println("Exception in Excel file finding and reading");
		}
		finally
		{
			System.out.println("Always Final Block");
		}
		return workbook;
	
	}
}

