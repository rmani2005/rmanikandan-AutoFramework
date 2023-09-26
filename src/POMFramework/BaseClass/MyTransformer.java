package POMFramework.BaseClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.ITest;

public class MyTransformer implements IAnnotationTransformer 

{

	@Override
	public void transform(ITest annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		// TODO Auto-generated method stub
		
		if ("invoke".equals(testMethod.getName())) 
		{
		     // annotation.setInvocationCount(5);
		}

		
	}
	
	
}

