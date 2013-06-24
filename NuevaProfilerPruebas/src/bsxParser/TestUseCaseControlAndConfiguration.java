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

public class TestUseCaseControlAndConfiguration {

	private static String INPUTFILE = "inputFile.xml";
	private static String OUTPUTFILE = "outputFile.xml";
	private BsxParser bsxParser;

	@Test
	public void test() {
		try {
			testSetInputDocument();
			testSetOutputDocument();
			testNexEvent();
			testObservateWhetherMoreEvents();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private void testObservateWhetherMoreEvents() throws IOException,
			XMLStreamException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();

		Writer writer = new FileWriter(INPUTFILE);
		XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance()
				.createXMLStreamWriter(writer);
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeEmptyElement("test");
		xmlStreamWriter.writeEndDocument();
		xmlStreamWriter.close();
		writer.close();

		bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		assertTrue(bsxParser.hasNext());
		bsxParser.next();
		bsxParser.next();
		bsxParser.next();
		assertFalse(bsxParser.hasNext());
		new File(INPUTFILE).delete();
		new File(OUTPUTFILE).delete();
	}

	private void testNexEvent() throws IOException, XMLStreamException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();

		Writer writer = new FileWriter(INPUTFILE);
		XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance()
				.createXMLStreamWriter(writer);
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeEmptyElement("test");
		xmlStreamWriter.writeEndDocument();
		xmlStreamWriter.close();
		writer.close();

		bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		assertTrue(bsxParser.hasNext());
		assertEquals(bsxParser.next(), 1);
		assertEquals(bsxParser.next(), 2);
		assertEquals(bsxParser.next(), 8);
		assertFalse(bsxParser.hasNext());
		new File(INPUTFILE).delete();
		new File(OUTPUTFILE).delete();
	}

	private void testSetOutputDocument() throws IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		assertNotNull(bsxParser);
		new File(INPUTFILE).delete();
		new File(OUTPUTFILE).delete();
	}

	private void testSetInputDocument() throws IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		assertNotNull(bsxParser);
		new File(INPUTFILE).delete();
		new File(OUTPUTFILE).delete();
	}

}
