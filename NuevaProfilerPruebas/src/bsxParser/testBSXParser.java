package bsxParser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class testBSXParser {

	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		TestUseCaseBackUp.class,
		TestUseCaseControlAndConfiguration.class,
		TestUseCaseRead.class,
		TestUseCaseWriter.class
	})
	
	public class BSXParserTest{}

}
