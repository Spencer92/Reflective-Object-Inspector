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

	/*
	 * Class Name	:		setField
	 * 
	 * Purpose   	:		Takes any public fields, and converts the name to a string
	 * 						to be displayed
	 * 
	 * 
	 */	
	
	
	public void setField() {

		this.fields = Arrays.toString(this.ob.getClass().getFields());
	}
	
	
	/*
	 * Class Name	:		printField
	 * 
	 * Purpose   	:		Prints the field and the number of modifiers associated with it.
	 * 
	 * 
	 */	
	
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
