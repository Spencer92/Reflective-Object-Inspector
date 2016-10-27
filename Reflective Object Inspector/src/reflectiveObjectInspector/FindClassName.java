package reflectiveObjectInspector;
import java.lang.reflect.*;

public class FindClassName extends InformationFinder
{
	Class cl;
	Object ob;
	String[] interfaceNames;
	
	public FindClassName(Class cl, Object ob)
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
		return this.cl.getName();
	}

	public String[] getClassInterfaceName()
	{
		Class<?> objectClass = (Class<?>) this.ob;
		System.out.println(objectClass.getInterfaces());
		String[] interfaceNames = new String[objectClass.getInterfaces().length];
		for(int i = 0; i < objectClass.getInterfaces().length; i++)
		{
			interfaceNames[i] = objectClass.getInterfaces()[i].getName();
		}
		return interfaceNames;
	}
	
	public String[] getClassInterfaceName2()
	{
		interfaceNames = new String[this.ob.getClass().getInterfaces().length];
		for(int i = 0; i < this.ob.getClass().getInterfaces().length; i++)
		{
			interfaceNames[i] = this.ob.getClass().getInterfaces()[i].getName();
			System.out.println(interfaceNames[i]);
		}
		return interfaceNames;
	}
	
	public String[] getClassInterfaceName3()
	{
		Class<?> newClass = this.ob.getClass();
		String name = this.ob.getClass().getName();
		interfaceNames = new String[newClass.getInterfaces().length];
		for(int i = 0; i < newClass.getInterfaces().length; i++)
		{
			interfaceNames[i] = newClass.getInterfaces()[i].getName();
			System.out.println(interfaceNames[i]);
		}
		return interfaceNames;
	}
	
	
	public String getSuperclassName()
	{
		return this.cl.getSuperclass().getName();
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