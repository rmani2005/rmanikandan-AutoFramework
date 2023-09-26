package javaProgramPackage;
import java.io.*;
/**
 * Copy one file to another using low level byte streams,
 * read and write a whole.at once.
 * @author Manikandan Ravi
 */
public class CopyFilesOne {
    public static void main(String[] args) {
 
       /* if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        } */
        
        String currDir = System.getProperty("user.dir");
		String filePath=currDir+"/output/";
		String fileName = "textfile.txt";
		String fileNameTarget = "textfile-target.txt";
		String fileSource=filePath+fileName;
		String fileTarget=filePath+fileNameTarget;
		
        String inputFile = fileSource;
        String outputFile = fileTarget;
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) 
        {
        	
            long fileSize = new File(inputFile).length(); //File size identifing 
            byte[] allBytes = new byte[(int) fileSize]; //byte is used to copy the file
 
            int bytesRead = inputStream.read(allBytes);
 
            outputStream.write(allBytes, 0, bytesRead);
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally
        {
        	System.out.println("Finally Block");
        }
    }
}