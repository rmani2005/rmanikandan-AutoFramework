package javaProgramPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelCreationLinux 
{

	public static void main(String[] args) throws IOException 
	{
		
		createExcel();
		
	}
	
	public static void createExcel() throws IOException 
	{
		
	String currDir=System.getProperty("user.dir");
	String stackFileName = currDir + "/output/";
	
	//Creating output stream to empty file
	FileOutputStream fos;
	try {
		File file = File.createTempFile(stackFileName + "/excelTemplate", ".XLS");
		HSSFWorkbook workbook = null;
		fos = new FileOutputStream(file);
		workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Sheet 1");
		workbook.write(fos);
		fos.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    

	

	//HSSFRow row[] = (HSSFRow) firstSheet.createRow(0);

	//row[0] = createHeaderRow(firstSheet.createRow(0));

	//row[0].createCell(0).setCellValue("test value");

	
	}
}
