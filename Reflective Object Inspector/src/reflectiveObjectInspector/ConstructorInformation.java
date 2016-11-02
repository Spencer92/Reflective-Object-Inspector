package reflectiveObjectInspector;

import java.lang.reflect.Constructor;

public class ConstructorInformation 
{
	private String[] parameterTypes = null;
	private String modifierss;
	private String name;
	private String[] parameterValues = null;
	private Object ob;
	private int position;
	

	/*
	 * Class Name	:		print
	 * 
	 * Purpose   	:		Prints out the constructor, the paramters if they exist, and the modifiers
	 * 
	 * 
	 */	
	
	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public ConstructorInformation(Object ob, int position)
	{
		setOb(ob);
		setPosition(position);
	}
	
	
	public Object getOb() {
		return ob;
	}


	public void setOb(Object ob) {
		this.ob = ob;
	}


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
		
		System.out.println("Modifiers: " + modifierss);
	}
	
	
	
	//Getters and setters
	
	
	public String[] getParameterTypes() {
		return parameterTypes;
	}
	
	public void setParameterTypes() {
		
		if(ob.getClass().getConstructors()[position].getParameterTypes().length > 0)
		{
			this.parameterTypes = new String[ob.getClass().getConstructors()[position].getParameterTypes().length];
			for(int i = 0; i < ob.getClass().getConstructors()[position].getParameterTypes().length; i++)
			{
				this.parameterTypes[i] = ob.getClass().getConstructors()[position].getParameterTypes()[i].getName();
			}
		}
	}
	
	
	
	public String getModifiers() {
		return modifierss;
	}
	public void setModifiers() {
		this.modifierss = Integer.toString(ob.getClass().getModifiers());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName()
	{
		this.name = ob.getClass().getName();
	}
}
