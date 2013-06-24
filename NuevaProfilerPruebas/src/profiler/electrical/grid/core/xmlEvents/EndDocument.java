package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

public class EndDocument extends EventHandler {

	@Override
	public int handle(BsxParser bsxParserEvent) {
		try {
			bsxParserEvent.writeEndDocument();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
