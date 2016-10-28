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
	public void setParameterTypes(Class<?>[] parameterTypes) {
		
		if(parameterTypes.length > 0)
		{
			this.parameterTypes = new String[parameterTypes.length];
			for(int i = 0; i < parameterTypes.length; i++)
			{
				this.parameterTypes[i] = parameterTypes[i].getName();
			}
		}
	}
	
	
	
	public String getModifiers() {
		return modifiers;
	}
	public void setModifiers(int modifiers) {
		this.modifiers = Integer.toString(modifiers);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(Constructor<?> name)
	{
		this.name = name.getName();
	}
}
