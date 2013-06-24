package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

@SuppressWarnings("restriction")
public class Space extends EventHandler {

	@Override
	public int handle(BsxParser bsxParserEvent) {
		try {
			bsxParserEvent.writeCharacters(bsxParserEvent.getText());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
