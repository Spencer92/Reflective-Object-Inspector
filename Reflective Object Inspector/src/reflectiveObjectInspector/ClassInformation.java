
package reflectiveObjectInspector;
import java.lang.reflect.*;

public class ClassInformation
{
	Class objectClass;
	Object ob;
	String[] interfaceNames;
	String[] fields = null;
	String[] fieldModifiers = null;
	
	public ClassInformation(Object ob)
	{
		setOb(ob);
	}

	/*
	 * Class Name	:		setFields
	 * 
	 * Purpose   	:		Takes any public fields, and converts the name to a string
	 * 						to be displayed
	 * 
	 * 
	 */	
	
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
	
	/*
	 * Class Name	:		printFields
	 * 
	 * Purpose   	:		Prints the field and the number of modifiers associated with it.
	 * 
	 * 
	 */	
	
	public void printFields()
	{
		if(fields != null)
		{
			System.out.print("Fields: " + fields[0]);
			for(int i = 1; i < fields.length; i++)
			{
				System.out.print(", " + fieldModifiers[i] + " " + fields[i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	//getters and setters
	
	public String getClassName()
	{
		objectClass = (Class<?>) this.ob;
		return objectClass.getName();
	}

	public Class<?>[] getClassInterfaces()
	{
		objectClass = (Class<?>) this.ob;
		return objectClass.getInterfaces();
	}
	
	
	public String[] getFields() {
		return fields;
	}

	
	public Class<?> getSuperclass()
	{
		objectClass = (Class<?>) this.ob;
		return objectClass.getSuperclass();
	}
	
	public Class getCl()
	{
		return this.objectClass;
	}
	private void setCl(Class cl)
	{
		this.objectClass = cl;
	}
	
	private Object getOb()
	{
		return this.ob;
	}
	
	private void setOb(Object ob)
	{
		this.ob = ob;
	}
}