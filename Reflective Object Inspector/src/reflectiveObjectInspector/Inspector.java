package reflectiveObjectInspector;

import java.util.ArrayList;

public class Inspector 
{
	ArrayList<String> saved = new ArrayList<String>();
	
	public void inspect(Object obj, boolean recursive)
	{
		Class<?> objectClass;
		objectClass = (Class<?>) obj;
		if(!saved.contains(objectClass.toString()))
		{
			saved.add(objectClass.toString());
		}
		else
		{
			return;
		}
		
		
		
	}
	
}
