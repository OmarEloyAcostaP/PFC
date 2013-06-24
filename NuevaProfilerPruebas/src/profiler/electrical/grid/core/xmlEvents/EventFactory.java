package profiler.electrical.grid.core.xmlEvents;

import java.util.HashMap;
import javax.xml.stream.XMLStreamConstants;

public class EventFactory {

	private EventHandler createAttribute() {
		return new Attribute();
	}

	private EventHandler createCharacters() {
		return new Characters();
	}

	private EventHandler createEndDocument() {
		return new EndDocument();
	}

	private EventHandler createStartElement() {
		return new StartElement();
	}

	private EventHandler createProccesingInstruction() {
		return new ProccesingInstruction();
	}

	private EventHandler createSpace() {
		return new Space();
	}

	private EventHandler createStartDocument() {
		return new StartDocument();
	}

	private EventHandler createEndElement() {
		return new EndElement();
	}

	public HashMap<Integer, EventHandler> createEvents() {
		HashMap<Integer, EventHandler> hashMap = new HashMap<Integer, EventHandler>();
		hashMap.put(XMLStreamConstants.ATTRIBUTE, createAttribute());
		hashMap.put(XMLStreamConstants.CHARACTERS, createCharacters());
		hashMap.put(XMLStreamConstants.END_DOCUMENT, createEndDocument());
		hashMap.put(XMLStreamConstants.END_ELEMENT, createEndElement());
		hashMap.put(XMLStreamConstants.PROCESSING_INSTRUCTION,
				createProccesingInstruction());
		hashMap.put(XMLStreamConstants.SPACE, createSpace());
		hashMap.put(XMLStreamConstants.START_DOCUMENT, createStartDocument());
		hashMap.put(XMLStreamConstants.START_ELEMENT, createStartElement());
		return hashMap;
	}

}
