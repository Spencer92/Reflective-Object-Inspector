package testReflectiveObjectInspector;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import asst2_test_driver.*;
import reflectiveObjectInspector.*;

import org.junit.Test;

import reflectiveObjectInspector.*;

class TestMethod1
{
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



public class TestFindMethodName 
{
	@Test
	public void testTestMethod1() throws ClassNotFoundException
	{
		Object ob = Class.forName("testReflectiveObjectInspector.TestMethod1");
		FindMethodName finder = new FindMethodName(null, ob);
		assertArrayEquals(new String[]{"m1","m2"},finder.getMethods());
	}
}
