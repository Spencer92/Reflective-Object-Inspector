package reflectiveObjectInspector;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldInformation 
{
	private Object ob;
	private String fields;
	
	public FieldInformation(Object ob)
	{
		setOb(ob);
	}

	
	
	public void setField() {

		this.fields = Arrays.toString(this.ob.getClass().getFields());
	}
	
	
	public void printField()
	{
		System.out.println("Field: " + this.fields);
	}
	
		
	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
	
}
