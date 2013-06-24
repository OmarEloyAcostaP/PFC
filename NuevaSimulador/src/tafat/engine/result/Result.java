package tafat.engine.result;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Result {
	@ElementList (inline=true)
	private List<Export> exportList;
	
	public List<Export> getExportList(){
		return exportList;
	}
}
