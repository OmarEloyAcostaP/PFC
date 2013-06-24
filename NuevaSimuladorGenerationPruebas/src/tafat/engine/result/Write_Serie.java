package tafat.engine.result;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class Write_Serie {
	@Attribute
	private String attribute;
	
	@Attribute (required=false)
	private String type;
	
	public String getAttribute(){
		return attribute;
	}
	
	public String getType(){
		if (type == null)
			return "all";
		return type;
	}
}
