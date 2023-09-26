package POMFramework.BaseClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class wrappermethods 
{

	//Site reachable check
	
	public static boolean isAccessable(String url,int timout) throws MalformedURLException, IOException
	{

		HttpURLConnection conn=null;
		//try catch block can run even Catch block is not there
		try {
			
			conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setConnectTimeout(timout);
			conn.setReadTimeout(timout);
			conn.setRequestMethod("HEAD");
			int responseCode=conn.getResponseCode();
			if(responseCode!=200)
			{
				return false;
			}
		}catch(Exception e1)
		{
			System.out.println("Exception-" + e1.toString());
			return false;
		}
		finally
		{
			//conn.disconnect();
		}
		return true;
		
		
	}
	
}
