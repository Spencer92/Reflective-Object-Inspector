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
//		System.out.println(obj.getClass().getName() + "\n end");
		
		
		
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
	
	
	/*
	 * Class Name	:		printClassInfo
	 * 
	 * Purpose   	:		prints the class name
	 * 
	 * 
	 */		
	
	
	private void printClassInfo(ClassInformation info, Class<?> classObject)
	{
		info.setFields(classObject.getFields());
		System.out.println("\n---------------");
		System.out.println(info.getClassName());
		System.out.println("---------------");
		info.printFields();
		
	}
	
	/*
	 * Class Name	:		printMethodInfo
	 * 
	 * Purpose   	:		Prints the name of a method, as well as its parameters,
	 * 						exceptions, modifiers, and return type
	 * 
	 */	
	
	
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

	/*
	 * Class Name	:		printConstructorInfo
	 * 
	 * Purpose   	:		Print the constructor names, as well as their modifiers
	 * 						and parameter types.
	 * 
	 * 
	 */		
	
	private void printConstructorInfo(ConstructorInformation[] info, Class<?> objectClass)
	{
		info = new ConstructorInformation[objectClass.getConstructors().length];
		System.out.println(objectClass.getConstructors().length + " constructors in this class\n");
		for(int i = 0; i < objectClass.getConstructors().length; i++)
		{
			info[i] = new ConstructorInformation();
			info[i].setModifiers(objectClass.getConstructors()[i].getModifiers());
			info[i].setName(objectClass.getConstructors()[i]);
//			info[i].setParameterTypes(objectClass.getConstructors()[i].getParameterTypes());
			info[i].print();
		}
	}
	
}
