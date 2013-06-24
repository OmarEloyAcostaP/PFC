package tafat.engine.result;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import tafat.engine.DateParser;

@Root
public class Export {
	@Attribute
	private String filename;

	@Attribute (required=false)
	private String template;
	
	@Attribute (required=false)
	private String from;
	
	@Attribute (required=false)
	private String to;
	
	@Attribute (required=false)
	private String step;
	
	@Attribute (required=false)
	private String type;	
	
	@ElementList (inline=true)
	private List<Select> selectList = new ArrayList<Select> ();
	
	public String getFilename(){
		return filename;
	}
	
	public String getTemplate(){
		return template;
	}
	
	public Date getFrom(){
		if (from == null)
			return null;
		
		try {
			return DateParser.parseDateAndTime(from);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Date getTo(){
		if (to == null)
			return null;
		
		try {
			return DateParser.parseDateAndTime(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getStep(){
		try{
			return Integer.parseInt(step);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return 1;
	}
	
	public String getType(){
		if (type == null)
			return "punctual";
		else
			return type;
	}
	
	public List<Select> getSelectList(){
		return selectList;
	}
}
