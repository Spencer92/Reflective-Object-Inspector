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
		FindMethodName name = new FindMethodName(null, ob);
		name.getConstructors();
	}
}
