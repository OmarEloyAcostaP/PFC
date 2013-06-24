package tafat.engine.result;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class Filter_Value {
	@Attribute
	private String attribute;

	@Attribute
	private String operator;
	
	@Attribute
	private String value;
	
	public String getAttribute(){
		return attribute;
	}
	
	public String getOperator(){
		return operator;
	}
	
	public String getValue(){
		return value;
	}
}
