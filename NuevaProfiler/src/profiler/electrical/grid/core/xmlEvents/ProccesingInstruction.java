package profiler.electrical.grid.core.xmlEvents;

import javax.xml.stream.XMLStreamException;

import bsxParser.BsxParser;

@SuppressWarnings("restriction")
public class ProccesingInstruction extends EventHandler {

	@Override
	public int handle(BsxParser bsxParserEvent){
		try {
			bsxParserEvent.writeProcessingInstruction(bsxParserEvent.getPITarget(),
					bsxParserEvent.getPIData());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
