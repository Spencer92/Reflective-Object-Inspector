
package reflectiveObjectInspector;
import java.lang.reflect.*;

public class ClassInformation
{
	Class objectClass;
	Object ob;
	Class<?>[] interfaceNames = new Class<?>[0];
	Class<?>[] relatedClasses = new Class<?>[0];

	
	public ClassInformation(Object ob)
	{
		setOb(ob);
	}


	

	

	
	
	//getters and setters
	
	public String getClassName()
	{
		return this.ob.getClass().getName() + "this";
	}

	public Class<?>[] getClassInterfaces()
	{
		if(this.ob.getClass().getInterfaces().length > 0)
		{
			this.interfaceNames = new Class<?>[this.ob.getClass().getInterfaces().length];
			for(int i = 0; i < this.ob.getClass().getInterfaces().length; i++)
			{
				this.interfaceNames[i] = this.ob.getClass().getInterfaces()[i];
			}
		}
			
		
		
		return this.interfaceNames;
	}
	
	public Class<?>[] getClasses()
	{
		if(this.ob.getClass().getClasses().length > 0)
		{
			this.relatedClasses = new Class<?>[this.ob.getClass().getClasses().length];
			for(int i = 0; i < this.ob.getClass().getClasses().length; i++)
			{
				this.interfaceNames[i] = this.ob.getClass().getClasses()[i];
			}
			
		}
		return this.relatedClasses;
	}

	
	public Class<?> getSuperclass()
	{
		return this.ob.getClass().getSuperclass();
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