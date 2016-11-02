/* 
 * Name:       Spencer Maslen
 * Email:      spencer.maslen2@ucalgary.ca
 * Course:     CPSC 501
 * Due Date:   October 28, 2016
 *
 * Source File: Inspector.java
 *
 * Purpose: To take classes and find out what methods, fields, and constructors
 * 			are in the class. 
 *
 *
 ******************************************************************************/

package reflectiveObjectInspector;

import java.util.ArrayList;

public class Inspector 
{
	ArrayList<String> saved = new ArrayList<String>();
	
	/*
	 * Class Name	:		inspect
	 * 
	 * Purpose   	:		Take a particular class, and find out everything associated with
	 * 						that class. If recursive is set to true, then find out everything
	 * 						about the related classes as well
	 * 
	 * Method Notes	:		In order to prevent looking at the same class multiple times, 
	 * 						a list of all the classes that have been already looked at are
	 * 						stored, and if it turns out there is already a match then the method
	 * 						stops, otherwise it prints out the related information.
	 * 
	 * 
	 * 
	 */	
	
	public void inspect(Object obj, boolean recursive)
	{
		Class<?> objectClass;
		ClassInformation classInfo;
		MethodInformation[] methodInfo = null;
		ConstructorInformation[] constructorInfo = null;
		FieldInformation[] fieldInfo = null;
//		System.out.println(obj.getClass().getName() + "\n end");
		
		
		if(obj == null)
		{
			return;
		}
		classInfo = new ClassInformation(obj);
		String classType = obj.toString();
		if(!saved.contains(classType))
		{
			saved.add(classType);
		}
		else
		{
			return;
		}
		printClassInfo(classInfo,obj);
		printFieldInfo(fieldInfo,obj);
		printMethodInfo(methodInfo,obj);
		printConstructorInfo(constructorInfo,obj);
		
		if(recursive)
		{
			inspect(classInfo.getSuperclass(),recursive);
			for(int i = 0; i < classInfo.getClassInterfaces().length; i++)
			{
				inspect(classInfo.getClassInterfaces()[i],recursive);
			}
			for(int i = 0; i < classInfo.getClasses().length; i++)
			{
				inspect(classInfo.getClasses()[i],recursive);
			}
		}
		
		
	}
	
	
	
	
	private void printFieldInfo(FieldInformation[] info, Object objectClass)
	{
		info = new FieldInformation[objectClass.getClass().getFields().length];
		System.out.println(objectClass.getClass().getFields().length + " fields in this class");
		for(int i = 0; i < objectClass.getClass().getFields().length; i++)
		{
			info[i] = new FieldInformation(objectClass,i);
			info[i].printField();
		}
		
	}
	
	
	
	/*
	 * Class Name	:		printClassInfo
	 * 
	 * Purpose   	:		prints the class name
	 * 
	 * 
	 */		
	
	
	private void printClassInfo(ClassInformation info, Object objectClass)
	{
		System.out.println("\n---------------");
		System.out.println(info.getClassName());
		System.out.println("---------------");
		
	}
	
	/*
	 * Class Name	:		printMethodInfo
	 * 
	 * Purpose   	:		Prints the name of a method, as well as its parameters,
	 * 						exceptions, modifiers, and return type
	 * 
	 */	
	
	
	private void printMethodInfo(MethodInformation[] info, Object objectClass)
	{
		info = new MethodInformation[objectClass.getClass().getMethods().length];
		System.out.println(objectClass.getClass().getMethods().length + " methods in this class\n");
		for(int i = 0; i < objectClass.getClass().getMethods().length; i++)
		{
			info[i] = new MethodInformation(objectClass, i);
			info[i].setName();
			info[i].setExceptions();
			info[i].setParameters();
			info[i].setModifiers();
			info[i].setReturnType();
			info[i].print();
		}
	}

	/*
	 * Class Name	:		printConstructorInfo
	 * 
	 * Purpose   	:		Print the constructor names, as well as their modifiers
	 * 						and parameter types.
	 * 
	 * 
	 */		
	
	private void printConstructorInfo(ConstructorInformation[] info, Object objectClass)
	{
		info = new ConstructorInformation[objectClass.getClass().getConstructors().length];
		System.out.println(objectClass.getClass().getConstructors().length + " constructors in this class\n");
		for(int i = 0; i < objectClass.getClass().getConstructors().length; i++)
		{
			info[i] = new ConstructorInformation(objectClass, i);
			info[i].setModifiers();
			info[i].setName();
			info[i].setParameterTypes();
			info[i].print();
		}
	}
	
}
