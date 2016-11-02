package testReflectiveObjectInspector;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import asst2_test_driver.*;
import reflectiveObjectInspector.*;

import org.junit.Test;

import reflectiveObjectInspector.*;

class TestMethod1
{
	public int f1;
	static int f2;
	protected int f3;
	final int f4 = 0;
	public TestMethod1(int j, int k)
	{
		int i = 7;
		System.out.println(i);
	}
	
	public String m1()
	{
		return "m1";
	}
	
	public int m2()
	{
		return 8;
	}
}
class TestMethod2 implements InterfaceA {

	@Override
	public void func0(int a, boolean c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func1(int a, double b, boolean c, String s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int func2(String s) throws Exception, ArithmeticException, IllegalMonitorStateException {
		// TODO Auto-generated method stub
		return 0;
		
		
	}}
class TestMethod3 extends TestClass1{}



public class TestMethodInformation 
{
	@Test
	public void testTestMethod1() throws ClassNotFoundException
	{
		TestMethod2 objectClass = new TestMethod2();
		MethodInformation[] info = new MethodInformation[objectClass.getClass().getMethods().length];

		for(int i = 0; i < objectClass.getClass().getMethods().length; i++)
		{
			info[i] = new MethodInformation(objectClass,i);
			info[i].setName();
			info[i].setExceptions();
			info[i].setParameters();
			info[i].setModifiers();
			info[i].setReturnType();
			info[i].print();
		}
		
	}
}
