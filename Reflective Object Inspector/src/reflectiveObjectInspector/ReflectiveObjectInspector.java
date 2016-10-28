package reflectiveObjectInspector;
import java.lang.reflect.*;
import testReflectiveObjectInspector.*;
import asst2_test_driver.*;

public class ReflectiveObjectInspector 
{
	public static void main(String [] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException
	{
		Object object1 = Class.forName("asst2_test_driver.ClassA");
		Object object2 = Class.forName("asst2_test_driver.ClassB");
		Object object3 = Class.forName("asst2_test_driver.ClassC");
		Object object4 = Class.forName("asst2_test_driver.ClassD");
		Inspector inspector = new Inspector();
		
		inspector.inspect(object1, true);
		inspector.inspect(object2, true);
		inspector.inspect(object3, true);
		inspector.inspect(object4, true);
		
		
	}
}
