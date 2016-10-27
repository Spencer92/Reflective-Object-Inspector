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
		Class<?>c2;
		Object ob2 = cl;
		c2 = (Class<?>) ob2;
//		System.out.println(c2.getClass().getName().toString());
//		System.out.println(ob2);
		FindMethodName name = new FindMethodName(null, ob);
//		FindClassName name2 = new FindClassName(cl,ob2);
//		name.getMethods();
//		name.getMethods2();
		name.getConstructors();
		name.getMethods();
//		System.out.println(name.getConstructors3());
//		name.getConstructors();
//		name2.getClassInterfaceName3();
		
	}
}
