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
	
	@Override
	public void getInformation() {
		// TODO Auto-generated method stub
		
	}

}
