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

	public String getClName()
	{
		return this.cl.getName();
	}

	public String[] getClInterfaceName()
	{
		interfaceNames = new String[this.cl.getInterfaces().length];
		for(int i = 0; i < this.cl.getInterfaces().length; i++)
		{
			interfaceNames[i] = this.cl.getInterfaces()[i].getName();
		}
		return interfaceNames;
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