package bsxParser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;

public class TestUseCaseWriter {
	private static String INPUTFILE = "inputFile.xml";
	private static String OUTPUTFILE = "outputFile.xml";

	@Test
	public void test() {

		try {
			init();
			testWriteCharacters();
			testWriteAttribute();
			testReadProccessingInstructionDestination();
			testReadElementName();
			testStartElement();
			testEndElement();
			testEndDocument();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() throws XMLStreamException, IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		bsxParser.writeStartDocument();
		bsxParser.writeProcessingInstruction("destination", "value");
		bsxParser.writeStartElement("element");
		bsxParser.writeAttribute("someAttribute", "attributeValue");
		bsxParser.writeCharacters("some text");
		bsxParser.writeEndElement();
		bsxParser.writeEndDocument();
		bsxParser.close();
	}

	private void testWriteCharacters() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getText(), "some text");
		bsxParser.close();
	}

	private void testReadProccessingInstructionDestination()
			throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		assertEquals(bsxParser.getPITarget(), "destination");
		assertEquals(bsxParser.getPIData(), "value");
		bsxParser.close();
	}

	private void testWriteAttribute() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getAttributeValue(0), "attributeValue");
		assertEquals(bsxParser.getAttributeCount(), 1);
		assertEquals(bsxParser.getAttributeLocalName(0), "someAttribute");
		bsxParser.close();
	}

	private void testReadElementName() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.getLocalName(), "element");
		bsxParser.close();
	}

	private void testStartElement() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		assertEquals(bsxParser.next(), 1);
		bsxParser.close();
	}

	private void testEndElement() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.next(), 2);
		bsxParser.close();
	}

	// assertEquals(bsxParser.next(),1);
	private void testEndDocument() throws XMLStreamException {
		BsxParser bsxParser = new BsxParser(OUTPUTFILE, INPUTFILE);
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		assertEquals(bsxParser.next(), 8);
		bsxParser.close();
	}

}
