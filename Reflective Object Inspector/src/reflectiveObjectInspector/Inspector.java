package reflectiveObjectInspector;

import java.util.ArrayList;

public class Inspector 
{
	ArrayList<String> saved = new ArrayList<String>();
	
	public void inspect(Object obj, boolean recursive)
	{
		Class<?> objectClass;
		ClassInformation classInfo;
		MethodInformation[] methodInfo = null;
		ConstructorInformation[] constructorInfo = null;
		
		objectClass = (Class<?>) obj;
		if(objectClass == null)
		{
			return;
		}
		classInfo = new ClassInformation(obj);
		if(!saved.contains(objectClass.toString()))
		{
			saved.add(objectClass.toString());
		}
		else
		{
			return;
		}
		printClassInfo(classInfo,objectClass);
		printMethodInfo(methodInfo,objectClass);
		printConstructorInfo(constructorInfo,objectClass);
		
		if(recursive)
		{
			inspect(objectClass.getSuperclass(),recursive);
			for(int i = 0; i < objectClass.getInterfaces().length; i++)
			{
				inspect(objectClass.getInterfaces()[i],recursive);
			}
			for(int i = 0; i < objectClass.getClasses().length; i++)
			{
				inspect(objectClass.getClasses()[i],recursive);
			}
		}
		
		
	}
	
	private void printClassInfo(ClassInformation info, Class<?> classObject)
	{
		info.setFields(classObject.getFields());
		System.out.println("\n---------------");
		System.out.println(info.getClassName());
		System.out.println("---------------");
		info.printFields();
		
	}
	
	private void printMethodInfo(MethodInformation[] info, Class<?> objectClass)
	{
		info = new MethodInformation[objectClass.getMethods().length];
		System.out.println(objectClass.getMethods().length + " methods in this class\n");
		for(int i = 0; i < objectClass.getMethods().length; i++)
		{
			info[i] = new MethodInformation();
			info[i].setName(objectClass,i);
			info[i].setExceptions(objectClass.getMethods()[i].getExceptionTypes());
			info[i].setParameters(objectClass.getMethods()[i].getParameterTypes());
			info[i].setModifiers(objectClass.getModifiers());
			info[i].setReturnType(objectClass.getMethods()[i].getReturnType());
			info[i].print();
		}
	}
	
	private void printConstructorInfo(ConstructorInformation[] info, Class<?> objectClass)
	{
		info = new ConstructorInformation[objectClass.getConstructors().length];
		System.out.println(objectClass.getConstructors().length + " constructors in this class\n");
		for(int i = 0; i < objectClass.getConstructors().length; i++)
		{
			info[i] = new ConstructorInformation();
			info[i].setModifiers(objectClass.getConstructors()[i].getModifiers());
			info[i].setName(objectClass.getConstructors()[i]);
			info[i].setParameterTypes(objectClass.getConstructors()[i].getParameterTypes());
			info[i].print();
		}
	}
	
}
