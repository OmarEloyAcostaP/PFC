package tafat.engine.result;

import java.io.File;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Result_Handler {
	Result result;
	ArrayList<Export_Handler> export_HandlerList = new ArrayList<Export_Handler> ();

	public Result_Handler(String fileXmlPath){
		Serializer serializer = new Persister();
		File source = new File(fileXmlPath);
		try {
			result = serializer.read(Result.class, source);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for (Export export: result.getExportList())
			export_HandlerList.add(new Export_Handler(export));
	}

	public void terminate() {
		for (Export_Handler export: export_HandlerList)
			export.terminate();
	}

	public void tick() {
		for (Export_Handler export: export_HandlerList)
			export.tick();
	}
}
