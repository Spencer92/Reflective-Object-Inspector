package reflectiveObjectInspector;

import java.lang.reflect.Constructor;

public class ConstructorInformation 
{
	private String[] parameterTypes = null;
	private String modifiers;
	private String name;
	

	/*
	 * Class Name	:		print
	 * 
	 * Purpose   	:		Prints out the constructor, the paramters if they exist, and the modifiers
	 * 
	 * 
	 */	
	
	public void print()
	{
		System.out.println("Constructor name: " + name);

		if(parameterTypes != null)
		{
			System.out.print("Parameter Types: " + parameterTypes[0]);
			for(int i = 1; i < parameterTypes.length; i++)
			{
				System.out.print(", " +parameterTypes[i]);
			}
			System.out.println();
		}
		else
		{
			System.out.println("Parameter Types: none");
		}
		
		System.out.println("Modifiers: " + modifiers);
	}
	
	
	
	
	//Getters and setters
	
	
	public String[] getParameterTypes() {
		return parameterTypes;
	}
	
	public void setParameterTypes(Object parameterTypes, int position) {
		
		if(parameterTypes.getClass().getConstructors()[position].getParameterTypes().length > 0)
		{
			this.parameterTypes = new String[parameterTypes.getClass().getConstructors()[position].getParameterTypes().length];
			for(int i = 0; i < parameterTypes.getClass().getConstructors()[position].getParameterTypes().length; i++)
			{
				this.parameterTypes[i] = parameterTypes.getClass().getConstructors()[position].getParameterTypes()[i].getName();
			}
		}
	}
	
	
	
	public String getModifiers() {
		return modifiers;
	}
	public void setModifiers(Object modifiers) {
		this.modifiers = Integer.toString(modifiers.getClass().getModifiers());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(Object name)
	{
		this.name = name.getClass().getName();
	}
}
