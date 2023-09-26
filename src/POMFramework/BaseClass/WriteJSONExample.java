package POMFramework.BaseClass;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.minidev.json.parser.JSONParser;

public class WriteJSONExample 
{
	static String JSONfilePathName = System.getProperty("user.dir")+"//output//JSONEmployee.json";
	 	@SuppressWarnings("unchecked")
	    public static void main( String[] args )
	    {
	 		
	 		
	 				
	 		 JSONObject employeeDetails = new JSONObject();
	 		 employeeDetails.put("firstName","Manikandan");
	 		 employeeDetails.put("lastName","Ravi");
	 		 employeeDetails.put("website","meanmodemani.in");
	 		 employeeDetails.put("temp","temp value");
	 		 
	 		 JSONObject employeeObject = new JSONObject();
	 		 employeeObject.put("employee", employeeDetails);
	 		 
	 		JSONObject employeeDetails2 = new JSONObject();
	 		 employeeDetails2.put("firstName","Priyadharshini");
	 		 employeeDetails2.put("lastName","M");
	 		 employeeDetails2.put("website","meanmodepriya.in");
	 		 employeeDetails2.put("temp","temp value");
	 		 
	 		 JSONObject employeeObject2 = new JSONObject();
	 		employeeObject2.put("employee", employeeDetails2);
	 		 
	 		JSONArray employeeArray=new JSONArray();
	 		 employeeArray.add(employeeObject);
	 		 employeeArray.add(employeeObject2);
	 		 
	 		 
	 		 try(FileWriter fileWriter=new FileWriter(JSONfilePathName))
	 		 {
	 			 fileWriter.write(employeeArray.toJSONString());
	 			 fileWriter.flush();
	 		 }catch(Exception e)
	 		 {
	 			 System.out.println(e.toString());
	 		 }
	 		 
	 		readJSON();
	 		 
	    }
	 	
	 	//Reading
	 	@SuppressWarnings("unchecked")
		public static void readJSON()
	 	{
	 		
			JSONParser jParser=new JSONParser(JSONParser.MODE_JSON_SIMPLE);
	 		

	 		 try(FileReader fileReader=new FileReader(JSONfilePathName))
	 		 {
	 			 //Read JSON file
	             Object obj = jParser.parse(fileReader);

	             JSONArray employeeList = new JSONArray();
	             employeeList.add(obj);
	             System.out.println(employeeList);
	             
	             //Advanced Java
	             employeeList.forEach(emp -> parseEmployeeObject((JSONObject)emp));
 
	 		 }catch(Exception e)
	 		 {
	 			 System.out.println(e.toString());
	 		 }
	 		
	 		
	 	}
	 	
	 	 private static void parseEmployeeObject(JSONObject employee) 
	     {
	 		 
	 		 //Get employee object within list
	         JSONObject employeeObject = (JSONObject) employee.get("employee");
	          
	         //Get employee first name
	         String firstName = (String) employeeObject.get("firstName");    
	         System.out.println(firstName);
	          
	         //Get employee last name
	         String lastName = (String) employeeObject.get("lastName");  
	         System.out.println(lastName);
	          
	         //Get employee website name
	         String website = (String) employeeObject.get("website");    
	         System.out.println(website);
	 		 
	     }
	 	
	
}
