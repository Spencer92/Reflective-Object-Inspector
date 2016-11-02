package testReflectiveObjectInspector;
import static org.junit.Assert.*;
import java.lang.reflect.*;

import org.junit.Assert;
import org.junit.Test;

import asst2_test_driver.*;
import reflectiveObjectInspector.ConstructorInformation;



class TestConstructor1
{
	public TestConstructor1(int i, String j, boolean k)
	{
		
	}
}

class TestConstructor2 extends TestConstructor1
{

	public TestConstructor2(int i, String j, boolean k) {
		super(i, j, k);
		// TODO Auto-generated constructor stub
	}

	
}



public class TestConstructorInformation 
{
	@Test
	public void testTestConstructor1() throws ClassNotFoundException
	{
		TestConstructor1 classObject = new TestConstructor1(0, "Test", false);
		
		
		ConstructorInformation[] info = new ConstructorInformation[classObject.getClass().getConstructors().length];
		
		
		for(int i = 0; i < info.length; i++)
		{
			info[i] = new ConstructorInformation();
			info[i].setModifiers(classObject);
			info[i].setName(classObject);
			info[i].setParameterTypes(classObject,i);
			info[i].print();
		}

		assertArrayEquals(new String[]{"int", "java.lang.String","boolean"}, info[0].getParameterTypes());
		assertEquals("0",info[0].getModifiers());
		assertEquals("testReflectiveObjectInspector.TestConstructor1",info[0].getName());
	}
	
	@Test
	public void testTestConstructor2() throws ClassNotFoundException
	{
		Class<?> classObject = Class.forName("testReflectiveObjectInspector.TestConstructor2");
		ConstructorInformation[] info = new ConstructorInformation[classObject.getConstructors().length];
		for(int i = 0; i < classObject.getConstructors().length; i++)
		{
			info[i] = new ConstructorInformation();
			info[i].setModifiers(classObject.getConstructors()[i].getModifiers());
			info[i].setName(classObject.getConstructors()[i]);
//			info[i].setParameterTypes(classObject.getConstructors()[i].getParameterTypes());
			info[i].print();
		}
		assertArrayEquals(new String[]{"int", "java.lang.String","boolean"}, info[0].getParameterTypes());
		assertEquals("1",info[0].getModifiers());
		assertEquals("testReflectiveObjectInspector.TestConstructor2",info[0].getName());
		
		
	}
}








