package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

@SuppressWarnings("restriction")
public class Attribute extends EventHandler {

	@Override
	public int handle(BsxParser bsxParserEvent) {
		try {
			for (int i = 0; i < bsxParserEvent.getAttributeCount(); i++)
				bsxParserEvent.writeAttribute(
						bsxParserEvent.getAttributeLocalName(i),
						bsxParserEvent.getAttributeValue(i));
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
