package reflectiveObjectInspector;
import java.lang.reflect.*;

public class FindMethodName extends InformationFinder
{
	private Class cl;
	private Object ob;
	
	
	public Class getCl() {
		return cl;
	}

	public void setCl(Class cl) {
		this.cl = cl;
	}

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}

	public FindMethodName(Class cl, Object ob)
	{
		setCl(cl);
		setOb(ob);
	}
	
	public String[] getMethods()
	{
		String[] methods = new String[this.ob.getClass().getDeclaredMethods().length];
		for(int i = 0; i < this.ob.getClass().getDeclaredMethods().length; i++)
		{
			methods[i] = this.ob.getClass().getDeclaredMethods()[i].toString();
			System.out.println(methods[i]);
		}
		return methods;
	}
	
	public String[] getMethods2()
	{
		String[] methods = new String[this.cl.getDeclaredMethods().length];
		for(int i = 0; i < this.cl.getMethods().length; i++)
		{
			methods[i] = this.cl.getDeclaredMethods()[i].toString();
			System.out.println(methods[i]);
		}
		return methods;
	}
	
	@Override
	public void getInformation() {
		// TODO Auto-generated method stub
		
	}

}
