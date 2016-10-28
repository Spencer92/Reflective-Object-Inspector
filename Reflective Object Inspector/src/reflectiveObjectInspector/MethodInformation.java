package reflectiveObjectInspector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodInformation 
{
	private String[] exceptions = null;
	private String[] parameters = null;
	private String returnType;
	private String modifiers;
	private String name;

	
	/*
	 * Class Name	:		print
	 * 
	 * Purpose   	:		Print out the method name, return type, and modifiers.
	 * 						If there are parameters or exceptions thrown, then those
	 * 						are displayed as well.
	 * 
	 */	


	public void print()
	{
		System.out.println("Method name: " + name);
		System.out.println("Return type: " + returnType);
		System.out.println("Modifiers: " + modifiers);

		if(exceptions != null)
		{
			System.out.print("Exceptions: " + exceptions[0]);
			for(int i = 1; i < exceptions.length; i++)
			{
				System.out.println(", " + exceptions[i]);
			}
			System.out.println();
		}
		else
		{
			System.out.println("Exceptions: none");
		}

		if(parameters != null)
		{
			System.out.print("Parameters: " + parameters[0]);
			for(int i = 1; i < parameters.length; i++)
			{
				System.out.print(", " + parameters[i]);
			}
			System.out.println();
		}
		else
		{
			System.out.println("Parameters: none");
		}
		
		System.out.println();
	}
	
	
	public String[] getExceptions() {
		return exceptions;
	}
	public void setExceptions(Class<?>[] exceptions) 
	{
		if(exceptions.length > 0)
		{
			this.exceptions = new String[exceptions.length];
			for(int i = 0; i < exceptions.length; i++)
			{
				this.exceptions[i] = exceptions[i].getName();
			}

		}
		
		
	}
	public String[] getParameters() {
		return parameters;
	}
	public void setParameters(Class<?>[] parameters) {
		
		if(parameters.length > 0)
		{
			this.parameters = new String[parameters.length];
			for(int i = 0; i < parameters.length; i++)
			{
				this.parameters[i] = 
						parameters[i].getName();
			}
			
		}

	}
	
/*	public String[] getFields() {
		return fields;
	}


	public void setFields(Field[] fields) {
		if(fields.length > 0)
		{
			this.fields = new String[fields.length];
			this.fieldModifiers = new String[fields.length];
			for(int i = 0; i < fields.length; i++)
			{
				if(fields[i].isAccessible())
				{
					this.fields[i] = "Accessible " + fields[i].getName();
					this.fieldModifiers[i] = Integer.toString(fields[i].getModifiers());
				}
				else
				{
					this.fields[i] = "inaccessible " + fields[i].getName();
					this.fieldModifiers[i] = Integer.toString(fields[i].getModifiers());
				}
			}
		}
	}
*/	
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType.getName();
	}
	public String getModifiers() {
		return modifiers;
	}
	public void setModifiers(int modifiers) {
		this.modifiers = Integer.toString(modifiers);
	}
	public String getName() {
		return name;
	}
	public void setName(Class<?> objectClass, int position) {
		this.name = objectClass.getMethods()[position].getName();
	}
	
	
}
