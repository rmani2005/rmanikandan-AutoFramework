package javaProgramPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class serailizaion 
{
	/*
	1. Why Java Serialization?
			Serialization is a mechanism for storing an object’s states into a persistent storage like disk files, databases, or sending object’s states over the network. The process of retrieval and construction of objects from disk files, databases and network is called de-serialization.
			Here are some examples of using serialization:
			- Storing data in an object-oriented way to files on disk, e.g. storing a list of Student objects.

			- Saving program’s states on disk, e.g. saving state of a game.

			- Sending data over the network in form objects, e.g. sending messages as objects in chat application.
			
			
			Serializable is a marker interface (contains no methods) that tell the Java Virtual Machine (JVM) 
			that the objects of this class is ready for being written to and read from a persistent storage or over the network.

			This requires serialization for use cases such as:
			
			Adding key/value objects to a map
			Putting items into a queue, set, or list
			Sending a lambda functions to another server
			Processing an entry within a map
			Locking an object
			Sending a message to a topic


			+++++++++++More about Java Serialization++++++
			There’s some important information with regard to serialization you should know:
			When an object is serialized, all other objects it refers to, are serialized as well, and so on, until the complete objects tree is serialized.
			If a super class implements Serializable, then its sub classes do automatically.
			When an instance of a serializable class is deserialized, the constructor doesn’t run.
			If a super class doesn’t implement Serializable, then when a subclass object is deserialized, the super class constructor will run.
			Static variables are not serialized because they are not part of the object itself.
			If you serialize a collection or an array, every element must be serializable. A single non-serializable element will cause the serialization to fail (NotSerializableException).
			Serializable classes in JDK include primitive wrappers (Integer, Long, Double, etc), String, Date, collection classes… For other classes, consult relevant Javadoc to know if they are serializable.
			
			When you are transferring information from one system to another in a network, the information is transmitted in bytes. 
			In order for you transfer some information say an object that you have developed to pass from one system to another 
			it must be broken down into packets in your system and recreated in the target. 
			This process of breaking a single object into numerous packets is achieved using serialization.
			
*/
	
	static String currDir=System.getProperty("user.dir");
	String driverPath=currDir+"/src/POMFramework/Drivers/";
	String stackFileName = currDir + "/output/NASDAXStack.txt";
	String reportFolder =currDir+"/src/report/";
	static String stackFilePath = currDir + "/output/";
	
	public static void main(String args[])
	{
		String filePath = stackFilePath + "data.ser";
		String message = "Java Serialization is Cool";
		 
		//>>>>>>>>>>>>>>>>>>>>>>>Serialization
		
		try (
		    FileOutputStream fos = new FileOutputStream(filePath);
		    ObjectOutputStream outputStream = new ObjectOutputStream(fos);
		) {
		 
		    outputStream.writeObject(message);
		 
		} catch (IOException ex) {
		    System.err.println(ex);
		}
	
	
		//De-Serialization<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//String filePath = filePath;
		 
		try (
		    FileInputStream fis = new FileInputStream(filePath);
		    ObjectInputStream inputStream = new ObjectInputStream(fis);
		) {
			 String message1 = (String) inputStream.readObject();
			 
			    System.out.println("Message: " + message1);
		   // System.out.println(student);
		 
		} catch (ClassNotFoundException ex) {
		    System.err.println("Class not found: " + ex);
		} catch (IOException ex) {
		    System.err.println("IO error: " + ex);
		}
}
}
