package testReflectiveObjectInspector;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import asst2_test_driver.*;

import org.junit.Test;

import reflectiveObjectInspector.*;

class TestClass1{}
class TestClass2 implements InterfaceA {

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
class TestClass3{}


public class TestFindClassName 
{
	@Test
	public void testTestClass1() throws ReflectiveOperationException
	{
		Class cl = Class.forName("testReflectiveObjectInspector.TestClass1");
		FindClassName name = new FindClassName(cl, null);
		assertEquals("testReflectiveObjectInspector.TestClass1",name.getClName());
	}
	
	@Test
	public void testTestClass2() throws ReflectiveOperationException
	{
		Class cl = Class.forName("testReflectiveObjectInspector.TestClass2");
		FindClassName name = new FindClassName(cl,null);
		assertArrayEquals(new String[]{"asst2_test_driver.InterfaceA"},name.getClInterfaceName());
	}
}
