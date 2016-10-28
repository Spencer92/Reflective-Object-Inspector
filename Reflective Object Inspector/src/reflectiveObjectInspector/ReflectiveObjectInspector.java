package reflectiveObjectInspector;
import java.lang.reflect.*;
import testReflectiveObjectInspector.*;
import asst2_test_driver.*;

public class ReflectiveObjectInspector 
{
	public static void main(String [] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException
	{
		Object ob = Class.forName("testReflectiveObjectInspector.TestMethod1");
		Class cl = Class.forName("testReflectiveObjectInspector.TestMethod1");
		Object ob3 = Class.forName("asst2_test_driver.ClassA");
		Object ob4 = Class.forName("asst2_test_driver.ObjectInspector");
		Class<?>c2;
		Object ob2 = cl;
		c2 = (Class<?>) ob2;
		Inspector inspector = new Inspector();
		
		inspector.inspect(ob,true);
		
	}
}
