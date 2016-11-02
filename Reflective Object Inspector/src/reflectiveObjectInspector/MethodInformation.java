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
	private Object ob;
	private int position;



	
	
	public MethodInformation(Object ob, int position)
	{
		setOb(ob);
		setPosition(position);
		
	}
	

	
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
	public void setExceptions() 
	{
		int exceptionsAmount;
		if((exceptionsAmount = this.ob.getClass().getMethods()[position].getExceptionTypes().length) > 0)
		{
			this.exceptions = new String[exceptionsAmount];
			for(int i = 0; i < exceptionsAmount; i++)
			{
				this.exceptions[i] = this.ob.getClass().getMethods()[position].getExceptionTypes()[i].getName();
			}

		}
		
		
	}
	public String[] getParameters() {
		return parameters;
	}

	public void setParameters() {
		
		int parametersAmount;
		if((parametersAmount = this.ob.getClass().getMethods()[position].getParameterTypes().length) > 0)
		{
			this.parameters = new String[parametersAmount];
			for(int i = 0; i < parametersAmount; i++)
			{
				this.parameters[i] = this.ob.getClass().getMethods()[position].getParameterTypes()[i].getName();
			}
			
		}

	}
	
	
	
	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public Object getOb() {
		return ob;
	}


	public void setOb(Object ob) {
		this.ob = ob;
	}

	
	
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType() {
		this.returnType = this.ob.getClass().getMethods()[position].getReturnType().getName();
	}
	public String getModifiers() {
		return modifiers;
	}
	public void setModifiers() {
		this.modifiers = Integer.toString(this.ob.getClass().getMethods()[position].getModifiers());
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = this.ob.getClass().getMethods()[position].getName();
	}
	
	
}
