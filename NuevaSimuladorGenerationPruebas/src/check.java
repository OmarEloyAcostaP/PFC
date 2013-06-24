import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import tafat.engine.Scene;
import tafat.engine.Topology;
import tafat.engine.result.Result_Handler;

import org.junit.Test;

public class check{
	
	public static Scene scene = new Scene();
	public static Topology topology = new Topology();
	public static Result_Handler result_Handler = null;
	
	@Test
	public void test() throws IOException, ParseException {
		System.out.println("------------------>Starting");
		
		scene = null;
		topology = null;
		scene = new Scene();
		topology = new Topology();

        try {
    		FileReader reader = null;
    		XMLStreamReader parserReader = null;
			reader = new FileReader("Pruebas.xml");
			parserReader = XMLInputFactory.newInstance().createXMLStreamReader(reader);
            int level=0;
            
			while (parserReader.hasNext())
            {
                parserReader.next();
                if (parserReader.isEndElement()){
                	System.out.println("</" + parserReader.getLocalName()+ "> " + level);
                	level--;
                }
                if (parserReader.isStartElement()){ 
                	level++;	
                	if (parserReader.getLocalName().toLowerCase().equals("scene")){
                		//level = scene.newLoad2(parserReader,level);
                	}if (parserReader.getLocalName().toLowerCase().equals("topology")){
                		System.out.println(parserReader.getLocalName());
                		//level = topology.newLoad2(parserReader,level);
                	}if (parserReader.getLocalName().toLowerCase().equals("result")){
                		
                	}            
                }
            }           
			reader.close();    
           	parserReader.close();  
           
   			System.out.println("------------------------>End");
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}           			
	}
	/*
	public int newLoad (XMLStreamReader parserReader, int level) throws XMLStreamException{
		while(level>1){
			parserReader.nextTag();
			level++;
			if(parserReader.isStartElement()){
				System.out.println("<"+parserReader.getLocalName()+">: "+ level);
				level = newLoad(parserReader,level);
			}				
			else if(parserReader.isEndElement()){
				level--;
				System.out.println("</"+ parserReader.getLocalName() +">: "+ level);
				level--;
			}
		}
		return level;
	}
	
	public void loadResults(XMLStreamReader parserReader, int level){
		
	}*/
}
