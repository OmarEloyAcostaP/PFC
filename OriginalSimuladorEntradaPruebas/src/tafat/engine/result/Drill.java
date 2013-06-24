package tafat.engine.result;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Drill {
	@Attribute
	private String typeClass;

	@Attribute(required=false)
	private String recursive;
	
	@ElementList (inline=true, required=false)
	private List<Drill> drillList = new ArrayList<Drill> ();
	
	@ElementList (inline=true, required=false)
	private List<Filter_Serie> filter_SerieList = new ArrayList<Filter_Serie> ();
	
	@ElementList (inline=true, required=false)
	private List<Filter_Value> filter_ValueList = new ArrayList<Filter_Value> ();
	
	@ElementList (inline=true, required=false)
	private List<Write_Serie> write_SerieList = new ArrayList<Write_Serie> ();
	
	@ElementList (inline=true, required=false)
	private List<Write_Value> write_ValueList = new ArrayList<Write_Value> ();
	
	public String getTypeClass(){
		return typeClass;
	}
	
	public String getRecursive(){
		if (recursive == null)
			return "false";
		return recursive;
	}
	
	public List<Drill> getDrillList(){
		return drillList;
	}
	
	public List<Filter_Serie> getFilter_Serie(){
		return filter_SerieList;
	}
	
	public List<Filter_Value> getFilter_Value(){
		return filter_ValueList;
	}
	
	public List<Write_Serie> getWrite_Serie(){
		return write_SerieList;
	}
	
	public List<Write_Value> getWrite_Value(){
		return write_ValueList;
	}
}
