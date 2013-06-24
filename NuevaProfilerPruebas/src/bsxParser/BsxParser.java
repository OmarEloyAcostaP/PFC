package bsxParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class BsxParser {
	private Writer writer;
	private XMLStreamWriter xmlStreamWriter;
	private Reader reader;
	private XMLStreamReader xmlStreamReader;
	private Attributes attributes;

	public BsxParser(String input, String output) {
		try {
			this.reader = new FileReader(input);
			this.xmlStreamReader = XMLInputFactory.newInstance()
					.createXMLStreamReader(reader);
			this.writer = new FileWriter(output);
			this.xmlStreamWriter = XMLOutputFactory.newInstance()
					.createXMLStreamWriter(writer);
			this.attributes = new Attributes();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.xmlStreamReader.close();
			this.reader.close();
			this.xmlStreamWriter.flush();
			this.xmlStreamWriter.close();
			this.writer.flush();
			this.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	// ----------------------------------------------------------

	public boolean hasNext() {
		try {
			return this.xmlStreamReader.hasNext();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int next(){
		try {
			return this.xmlStreamReader.next();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getLocalName() {
		return this.xmlStreamReader.getLocalName();
	}

	public String getText() {
		return this.xmlStreamReader.getText();
	}

	public String getAttributeLocalName(int index) {
		return this.xmlStreamReader.getAttributeLocalName(index);
	}

	public String getPITarget() {
		return this.xmlStreamReader.getPITarget();
	}

	public String getPIData() {
		return this.xmlStreamReader.getPIData();
	}

	public int getAttributeCount() {
		return this.xmlStreamReader.getAttributeCount();
	}

	public String getAttributeValue(int index) {
		return this.xmlStreamReader.getAttributeValue(index);
	}
	
	public int getIndex(String name){
		for (int index = 0 ; index < getAttributeCount(); index++){
			if (getAttributeLocalName(index).equals(name))
				return index;
		}
		return -1;
	}

	// ----------------------------------------------------------
	
	public void addRegister(String name, String value) {
		this.attributes.put(new Name(name), value);
	}

	public void removeRegister(String name) {
		this.attributes.remove(new Name(name));
	}

	public String getRegisterValue(String name) {
		return this.attributes.getValue(new Name(name));
	}

	// ----------------------------------------------------------

	public void writeCharacters(String text) throws XMLStreamException {
		this.xmlStreamWriter.writeCharacters(text);
	}

	public void writeStartElement(String localName) throws XMLStreamException {
		this.xmlStreamWriter.writeStartElement(localName);
	}

	public void writeComment(String comment) throws XMLStreamException {
		this.xmlStreamWriter.writeComment(comment);
	}

	public void writeAttribute(String localName, String value)
			throws XMLStreamException {
		this.xmlStreamWriter.writeAttribute(localName, value);
	}

	public void writeProcessingInstruction(String piTarget, String piData)
			throws XMLStreamException {
		this.xmlStreamWriter.writeProcessingInstruction(piTarget, piData);
	}

	public void writeEndDocument() throws XMLStreamException {
		this.xmlStreamWriter.writeEndDocument();
	}

	public void writeStartDocument() throws XMLStreamException {
		this.xmlStreamWriter.writeStartDocument();
	}

	public void writeEndElement() throws XMLStreamException {
		this.xmlStreamWriter.writeEndElement();
	}
}
