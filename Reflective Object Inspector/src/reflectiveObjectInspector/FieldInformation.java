package reflectiveObjectInspector;

import java.lang.reflect.Field;

public class FieldInformation 
{
	private Object ob;
	private String fields;
	private String modifiers;
	private int position;
	
	public FieldInformation(Object ob, int position)
	{
		setOb(ob);
	}

	
	
	public void setField() {
		if(this.ob.getClass().getFields().length > 0)
		{
				if(this.ob.getClass().getFields()[position].isAccessible())
				{
					this.fields = "Accessible " + this.ob.getClass().getFields()[position].getName();
				}
				else
				{
					this.fields = "inaccessible " + this.ob.getClass().getFields()[position].getName();
				}
		}
	}
	
	
	public void printField()
	{
		System.out.println("Field: " + this.fields);
		System.out.println("Modifiers: " + this.modifiers);
	}
	
	
	public void setModifiers()
	{
		this.modifiers = Integer.toString(this.ob.getClass().getFields()[position].getModifiers());
	}
	
	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
	
}
