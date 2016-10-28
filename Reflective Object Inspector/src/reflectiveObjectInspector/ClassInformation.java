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
	

	public String getClassName()
	{
		objectClass = (Class<?>) this.ob;
		return objectClass.getName();
	}

	public Class<?>[] getClassInterfaces()
	{
		objectClass = (Class<?>) this.ob;
		System.out.println(objectClass.getInterfaces());
		String[] interfaceNames = new String[objectClass.getInterfaces().length];
///		for(int i = 0; i < objectClass.getInterfaces().length; i++)
//		{
//			interfaceNames[i] = objectClass.getInterfaces()[i].getName();
//		}
		return objectClass.getInterfaces();
	}
	
	
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

	
	public String[] getFields() {
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