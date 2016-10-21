package reflectiveObjectInspector;
import java.lang.reflect.*;

public class FindClassName extends InformationFinder
{
	Class cl;
	Object ob;
	
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



	private Class getCl()
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