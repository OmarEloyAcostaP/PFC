package profiler.electrical.grid.core;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Profiler {
	
	PluginFactory pluginFactory = new PluginFactory();
	
	public void execute(Document document){
		NodeList nodeXml = document.getDocumentElement().getChildNodes();
		searchProfiler(nodeXml, document);
	}

	private void searchProfiler(NodeList nodeXml, Document document) {
		for(int i=0; i<nodeXml.getLength(); i++){
			Node node = nodeXml.item(i);
			String nodeName = node.getNodeName().toLowerCase();
			short nodeType = node.getNodeType();
			if((nodeType==Node.ELEMENT_NODE) && (nodeName.regionMatches(0, "profiler-", 0, 9))){
				Console.out("Profiler found, type: " + nodeName.substring(9));
				if (pluginFactory.create(document, node)){
					i=-1;
					continue;
				}
			}
			if (node.hasChildNodes())
				searchProfiler(node.getChildNodes(),document);
		}
		
	}
}
