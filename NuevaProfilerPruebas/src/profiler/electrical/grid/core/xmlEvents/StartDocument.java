package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

public class StartDocument extends EventHandler {

	@Override
	public int handle(BsxParser bsxParserEvent){
		try {
			bsxParserEvent.writeStartDocument();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
