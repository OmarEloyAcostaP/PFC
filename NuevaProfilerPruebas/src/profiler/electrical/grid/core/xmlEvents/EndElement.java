package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

public class EndElement extends EventHandler{
	
	@Override
	public int handle(BsxParser bsxParserEvent){
		if (!isProfilerNode(bsxParserEvent.getLocalName())){
			try {
				bsxParserEvent.writeEndElement();
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
