package reflectiveObjectInspector;
import java.lang.reflect.*;
import testReflectiveObjectInspector.*;

public class FindMethodName
{
	private Class cl;
	private Object ob;
	private String[] getExceptions;
	private String[] getParameterTypes;
	private String[] getReturnTypes;
	
	


	public FindMethodName(Class cl, Object ob)
	{
		setCl(cl);
		setOb(ob);
	}
	
	public MethodInformation getMethods()
	{
		Class<?> classObject = (Class<?>) this.ob;
		MethodInformation[] info = new MethodInformation[classObject.getMethods().length];
		String[] methods = new String[classObject.getMethods().length];
		classObject.getFields()[0].getModifiers();
		for(int i = 0; i < classObject.getMethods().length; i++)
		{
			methods[i] = classObject.getMethods()[i].getParameterTypes()[i].getName();
			System.out.println(methods[i]);
		}
		return null;
	}
	
	
	public String[] getConstructors() throws NoSuchMethodException, SecurityException
	{
		Class<?> parameterTypes = (Class<?>) ob;
		String[] constructors = new String[parameterTypes.getConstructors().length];
		for(int i = 0; i < parameterTypes.getConstructors().length; i++)
		{
			constructors[i] = parameterTypes.getConstructors()[i].getName();
			System.out.println(constructors[i]);
		}
		return constructors;
	}
	
	
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


}
