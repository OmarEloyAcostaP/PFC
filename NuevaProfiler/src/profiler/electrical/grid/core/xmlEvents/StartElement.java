package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;
import bsxParser.BsxParser;

@SuppressWarnings("restriction")
public class StartElement extends EventHandler {

	@Override
	public int handle(BsxParser bsxParser) {
		try {
			if (isProfilerNode(bsxParser.getLocalName())) {
				bsxParser.addRegister("localName", bsxParser.getLocalName());
				for (int index = 0; index < bsxParser.getAttributeCount(); index++) {
					bsxParser.addRegister(
							bsxParser.getAttributeLocalName(index),
							bsxParser.getAttributeValue(index));
				}
				return 1;
			} else {
				handlerNoProfilerElement(bsxParser);
				return 0;
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private void handlerNoProfilerElement(BsxParser bsxParserEvent)
			throws XMLStreamException {
		bsxParserEvent.writeStartElement(bsxParserEvent.getLocalName());
		for (int i = 0; i < bsxParserEvent.getAttributeCount(); i++)
			bsxParserEvent.writeAttribute(
					bsxParserEvent.getAttributeLocalName(i),
					bsxParserEvent.getAttributeValue(i));
	}
}
