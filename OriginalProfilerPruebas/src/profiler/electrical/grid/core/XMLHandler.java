package profiler.electrical.grid.core;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLHandler {
	
	public static void saveDocument(String path, Document document) {
		TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
		try {
			transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(path);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
//	public static void saveDocument(String path, Document document) {
//		Writer out = null;
//		try {
//		OutputFormat format = new OutputFormat(document);
//		format.setLineWidth(65);
//		format.setIndenting(true);
//		format.setIndent(2);
//		out = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
//		XMLSerializer serializer = new XMLSerializer (out, format);
//		
//			serializer.serialize(document);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		TransformerFactory tFactory = TransformerFactory.newInstance();
//        Transformer transformer = null;
//		try {
//			transformer = tFactory.newTransformer();
//		} catch (TransformerConfigurationException e) {
//			e.printStackTrace();
//		}
//
//        DOMSource source = new DOMSource(document);
//        StreamResult result = new StreamResult(out);
//        try {
//			transformer.transform(source, result);
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static Document openDocument(String path) {
		DocumentBuilder builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			Console.out("Loading document...");
			builder = factory.newDocumentBuilder();
			return builder.parse(path);
		}
		catch (SAXException se){}
		catch (ParserConfigurationException pce){} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
