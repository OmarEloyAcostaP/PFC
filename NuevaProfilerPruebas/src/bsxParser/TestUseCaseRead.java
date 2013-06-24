package bsxParser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.junit.Test;

public class TestUseCaseRead {
	private static String INPUTFILE = "inputFile.xml";
	private static String OUTPUTFILE = "outputFile.xml";
	
	@Test
	public void test() {

		try {
			init();
			testReadText();
			testReadAttribute();
			testAttributeValue();
			testGetNumberOfAttributes();
			testReadProccessingInstructionDestination();
			testReadProccessingInstructionContain();			
			testReadElementName();
			new File(INPUTFILE).createNewFile();
			new File(OUTPUTFILE).createNewFile();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws XMLStreamException, IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();		
		Writer writer = new FileWriter(INPUTFILE);
		XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance()
				.createXMLStreamWriter(writer);
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeProcessingInstruction("destination", "value");
		xmlStreamWriter.writeStartElement("element");
		xmlStreamWriter.writeAttribute("someAttribute", "attributeValue");
		xmlStreamWriter.writeCharacters("some text");
		xmlStreamWriter.writeEndElement();
		xmlStreamWriter.writeEndDocument();
		xmlStreamWriter.close();
		writer.close();
	}

	private void testReadProccessingInstructionContain() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		assertEquals(bsxParser.getPIData(),"value");
		bsxParser.close();
	}

	private void testReadText() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getText(),"some text");
		bsxParser.close();
	}

	private void testReadProccessingInstructionDestination() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		assertEquals(bsxParser.getPITarget(),"destination");
		bsxParser.close();	
	}

	private void testGetNumberOfAttributes() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getAttributeCount(),1);
		bsxParser.close();		
	}

	private void testAttributeValue() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getAttributeValue(0),"attributeValue");
		bsxParser.close();			
	}

	private void testReadAttribute() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getAttributeLocalName(0),"someAttribute");
		bsxParser.close();			
	}

	private void testReadElementName() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);	
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getLocalName(),"element");
		bsxParser.close();		
	}
}
