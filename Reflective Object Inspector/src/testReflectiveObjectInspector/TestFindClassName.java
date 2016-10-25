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
class TestClass3 extends TestClass1{}


public class TestFindClassName 
{
	@Test
	public void testTestClass1() throws ReflectiveOperationException
	{
		Class cl = Class.forName("testReflectiveObjectInspector.TestClass1");
		FindClassName name = new FindClassName(cl, null);
		assertEquals("testReflectiveObjectInspector.TestClass1",name.getClassName());
	}
	
	@Test
	public void testTestClass2() throws ReflectiveOperationException
	{
		Class cl = Class.forName("testReflectiveObjectInspector.TestClass2");
		FindClassName name = new FindClassName(cl,null);
		assertArrayEquals(new String[]{"asst2_test_driver.InterfaceA"},name.getClassInterfaceName());
	}
	
	@Test
	public void testTestClass3() throws ReflectiveOperationException
	{
		Class cl = Class.forName("testReflectiveObjectInspector.TestClass3");
		FindClassName name = new FindClassName(cl,null);
		assertEquals("testReflectiveObjectInspector.TestClass1", name.getSuperclassName());
	}
	
	
}
