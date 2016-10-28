package reflectiveObjectInspector;
import java.lang.reflect.*;

public class ClassInformation extends InformationFinder
{
	Class cl;
	Object ob;
	String[] interfaceNames;
	
	public ClassInformation(Class cl, Object ob)
	{
		setCl(cl);
		setOb(ob);
	}
	
	@Override
	public void getInformation() 
	{

		this.cl.getName();
	}

	public String getClassName()
	{
		Class<?> objectClass = (Class<?>) this.ob;
		return objectClass.getName();
	}

	public void getClassInterfaceName()
	{
		Class<?> objectClass = (Class<?>) this.ob;
		System.out.println(objectClass.getInterfaces());
		String[] interfaceNames = new String[objectClass.getInterfaces().length];
		for(int i = 0; i < objectClass.getInterfaces().length; i++)
		{
			interfaceNames[i] = objectClass.getInterfaces()[i].getName();
		}
	}
	
	
	
	public String getSuperclassName()
	{
		Class<?> objectClass = (Class<?>) this.ob;
		return objectClass.getSuperclass().getName();
	}
	
	public Class getCl()
	{
		return this.cl;
	}
	private void setCl(Class cl)
	{
		this.cl = cl;
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