package javaProgramPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class fileReadings 
{

	public static void main(String args[]) throws IOException,FileNotFoundException
	{
		
		
		//Reading and writing from console
		
		System.out.println("Enter Some text to find in Search:");
		Scanner scan=new Scanner(System.in);
		String strfromConsole= scan.nextLine();
		
		System.out.println("Output of the Console:" +  strfromConsole);
		
		//Reading and Writing txt files
		///media/rocky/81e509c3-f680-4aca-ae97-4b9ba8161528/Workspace-SeleniumKarate/BasicAutomationFramework/output

		///===========Continue block check===========
		System.out.println("Enter continue to continue to next validation:");
		scan=new Scanner(System.in);
		String scanTerminator= scan.nextLine();
		//(!scan.equals(strfromConsole))->{System.exit(0):System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>")};		
		if(!scanTerminator.equals("continue"))
			System.exit(0);
		System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>");
		///===========Continue block check===========
		
		String currDir = System.getProperty("user.dir");
		String filePath=currDir+"/output/";
		String fileName = "textfile.txt";
		String fileSource=filePath+fileName;
		//File fileRead = new File(filePath+fileName);
		//Character Encoding and Charset
		//Type 1:
		System.out.println("XXXXXXXXXXXXXXxType 1-FileReader & Writer xXXXXXXXXXXXXXXXX");
		try (FileReader reader = new FileReader(fileSource)) {
		int checkEOF; 	
		
		//using while, read the file
		while((checkEOF=reader.read())!=-1) {
			System.out.print((char)checkEOF);
		}
		reader.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		FileFilter sizeFilter = new FileFilter() {
		    public boolean accept(File file) {
		        if (file.isFile() && file.length() > 3*1024*1024) {
		            // filters files whose size greater than 3MB
		            return true;
		        } else {
		            return false;
		        }
		    }
		};
		
		String dirPath = filePath;
		File dir = new File(dirPath);
		File[] files = dir.listFiles(sizeFilter);
		if (files.length == 0) {
		    System.out.println("There is no files bigger than 3MB");
		} else {
		    for (File aFile : files) {
		        System.out.println(aFile.getName() + " - " + aFile.length());
		    }
		}
		
		/*
		try (FileWriter outReader = new FileWriter(fileSource)) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		///===========Continue block check===========
				System.out.println("Enter continue to continue to next validation:");
				scan=new Scanner(System.in);
				scanTerminator= scan.nextLine();
				//(!scan.equals(strfromConsole))->{System.exit(0):System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>")};		
				if(!scanTerminator.equals("continue"))
					System.exit(0);
				System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>");
				///===========Continue block check===========
		System.out.println("XXXXXXXXXXXXXXxType 2-FileInputStream xXXXXXXXXXXXXXXXX");
		//Type 2:
		InputStreamReader reader = null;
		try {
			FileInputStream FIS = new FileInputStream(fileSource);
			reader = new InputStreamReader(FIS);
			int intChar;
			
			while((intChar=reader.read())!= -1) {
				System.out.println((char)intChar);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader.close();
			
		
		///===========Continue block check===========
		System.out.println("Enter continue to continue to next validation:");
		scan=new Scanner(System.in);
		scanTerminator= scan.nextLine();
		//(!scan.equals(strfromConsole))->{System.exit(0):System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>")};		
		if(!scanTerminator.equals("continue"))
			System.exit(0);
		System.out.println(">>>>>>>>Continuing to next validation block>>>>>>>>");
		///===========Continue block check===========
		System.out.println("XXXXXXXXXXXXXXxType 3-BufferedReaderxXXXXXXXXXXXXXXXX");

		
		
		try
		{
			FileReader reader2=new FileReader(fileSource);
			BufferedReader buffer=new BufferedReader(reader2);
			
			String line;
			
			while((line=buffer.readLine())!= null)
			{
				System.out.println(line);
			}
			reader2.close();
		}catch(IOException e) {
            e.printStackTrace();
		}
		
		//writing the text files
		//Note that, a writer uses default character encoding of the operating system by default. 
		//It also creates a new file if not exits, or overwrites the existing one. 
		//If you want to append text to an existing file, pass a boolean flag of true to constructor of the writer class:
		//Type 1 Writing
		try {
			FileWriter writer=new FileWriter(fileSource,true);
			writer.append("Search Phrase:" + scan);
			writer.write("Hello World");
			writer.write("\r\n");   // write new line
			writer.write("Good Bye!");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		//Type 2 Writing
		FileWriter writer =new FileWriter(fileSource,true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write("Hello World");
        bufferedWriter.newLine();
        bufferedWriter.write("See You Again!");
        
        System.out.println(bufferedWriter.hashCode());
        
        bufferedWriter.close();
        
		//Final Type
		//NOTE: From Java 7, you can use try-with-resources statement to simplify the code of opening and closing the reader/writer. For example:
		
		try (FileReader reader3 = new FileReader("MyFile.txt")) {
		    int character;
		 
		    while ((character = reader3.read()) != -1) {
		        System.out.print((char) character);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		//Reading and writing excel files
		
		
		
		//Reading and writing XML files
		
		
		
		
		//Reading 
		
		
		
		
		
		/*
		
		
		-Exceptions list:
			* FileNotFoundException
			* IOException
			* UnSupportedEncodingFormat
			* NumberformatException
		
		-Throws can have multiple exceptions
		
		*/
	}


	
	
}
