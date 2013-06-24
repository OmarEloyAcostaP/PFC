package bsxParserTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import bsxParser.BsxParser;

public class TestUseCaseBackUp {
	private static String INPUTFILE = "inputFile.xml";
	private static String OUTPUTFILE = "outputFile.xml";
	
	@Test
	public void test() {
		try {
			testAddRegister();
			testGetRegister();
			testRemoveRegister();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void testRemoveRegister() throws IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		bsxParser.addRegister("name1", "value1");
		bsxParser.removeRegister("name1");
		assertNull(bsxParser.getRegisterValue("name1"));
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
	}

	private void testGetRegister() throws IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		bsxParser.addRegister("name1", "value1");
		assertEquals(bsxParser.getRegisterValue("name1"),"value1");
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
	}

	private void testAddRegister() throws IOException {
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
		BsxParser bsxParser = new BsxParser(INPUTFILE, OUTPUTFILE);
		bsxParser.addRegister("name1", "value1");
		assertEquals(bsxParser.getRegisterValue("name1"),"value1");
		new File(INPUTFILE).createNewFile();
		new File(OUTPUTFILE).createNewFile();
	}
}
