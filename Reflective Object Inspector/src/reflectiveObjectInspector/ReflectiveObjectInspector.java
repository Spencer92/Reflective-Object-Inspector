package reflectiveObjectInspector;
import java.lang.reflect.*;
import testReflectiveObjectInspector.*;
import asst2_test_driver.*;

public class ReflectiveObjectInspector 
{
	public static void main(String [] args) throws Exception
	{
		ClassA object1 = new ClassA();
		ClassB object2 = new ClassB();
		ClassC object3 = new ClassB();
		ClassD object4 = new ClassD();
		
		System.out.println(object1.getClass().getName());
		
		Inspector inspector = new Inspector();
		
		inspector.inspect(object1, true);
		inspector.inspect(object2, true);
		inspector.inspect(object3, true);
		inspector.inspect(object4, true);
		
		
	}
}
