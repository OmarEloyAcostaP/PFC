package profiler.electrical.grid.core;

import java.util.ArrayList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public abstract class Plugin {

	protected static Node newNode(Document document, String nodeName){
		return document.createElement(nodeName);
	}
	
	protected static void setAttribute (Document document, Node node, String attributeName, String value){
		NamedNodeMap nodeAtributtes = node.getAttributes();	
		Attr attribute = document.createAttribute(attributeName);
		attribute.setValue(value);
		nodeAtributtes.setNamedItem(attribute);
	}
	
	protected static void setChildOfNode(Document document, Node parentNode, Node child){
		if (child == null)
			return;
		parentNode.appendChild(child);
	}
	
	protected static String getAttribute(Node node, String attribute){
		NamedNodeMap attributes =  node.getAttributes();
		for(int i=0; i<attributes.getLength();i++){
			if(attributes.item(i).getNodeName().equals(attribute)||attributes.item(i).getNodeName().equals(attribute)){
				return attributes.item(i).getNodeValue();
			}
		}
		return "";
	}
	
	protected static String getParentAttribute(Node node, String attribute){
		NamedNodeMap parentAttributes =  node.getParentNode().getAttributes();
		for(int i=0; i<parentAttributes.getLength();i++){
			if(parentAttributes.item(i).getNodeName().equals(attribute)||parentAttributes.item(i).getNodeName().equals(attribute)){
				return parentAttributes.item(i).getNodeValue();
			}
		}
		return "";
	}
	
	protected static void changeProfilerForNode (Node substituteNode, Node nodeProfiler){
		Node parent = nodeProfiler.getParentNode();
		parent.replaceChild(substituteNode, nodeProfiler);
	}
	
	protected static double strToDouble (String string){
		if (string.equals(""))
			return Double.NaN;
		return Double.valueOf(string).doubleValue();
	}

	protected static int strToInt (String string){
		if (string.equals(""))
			return Integer.MAX_VALUE;
		return Integer.valueOf(string).intValue();
	}
	
	protected static String numberToStr (double number){
		return "" + number;
	}

	protected static String numberToStr (int number){
		return "" + number;
	}	
	
	public static int randomInRangeInt(int min, int max){
		return (int) (Math.round(Math.random()*(max-min))+min);		
	}
	public static double randomInRangeDouble(double min, double max) {
		return (Math.random()*(max-min))+min;	
	}
	
	public static Node getBehavior (Document document, String behavior){
		Node behaviorNode = null;
		if (!behavior.equals("")){
			behaviorNode = newNode(document, "behavior");
			String[] behaviorName = behavior.split("@");
			if (behaviorName.length > 2){
				setAttribute(document, behaviorNode, "name", behaviorName[0]);
				setAttribute(document, behaviorNode, "release", behaviorName[1]);
				setAttribute(document, behaviorNode, "step", behaviorName[2]);
			}
			else if (behaviorName.length > 1){
				setAttribute(document, behaviorNode, "name", behaviorName[0]);
				setAttribute(document, behaviorNode, "release", behaviorName[1]);
			}
			else{
				setAttribute(document, behaviorNode, "name", behaviorName[0]);
				setAttribute(document, behaviorNode, "release", "");
			}
		}
		return behaviorNode;
	}
	
	public static void setConnection(Document document, String connectionType, String sourceId, String destinationId){
		NodeList nodes = document.getDocumentElement().getChildNodes();
		
		Node topology = null;
		for(int i=0; i<nodes.getLength(); i++){
			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE)
				if (nodes.item(i).getNodeName().equals("topology")){
					topology = nodes.item(i);
					break;
				}
		}
		if (topology == null){
			Console.out("connection not set: topology clausule not found");
			return;
		}
		
		Node connectionNode = newNode(document, connectionType);
		setAttribute(document, connectionNode, "source", sourceId);
		setAttribute(document, connectionNode, "destination", destinationId);
		setAttribute(document, connectionNode, "id", sourceId + ";" + destinationId);
		
		setChildOfNode(document, topology, connectionNode);
	}
	

	public ArrayList<Node> searchNodes(NodeList nodeXml, String nodeToSearch) {
		ArrayList<Node> nodesFound = new ArrayList <Node> ();
		for(int i=0; i<nodeXml.getLength(); i++){
			Node node = nodeXml.item(i);
			String nodeName = node.getNodeName().toLowerCase();
			short nodeType = node.getNodeType();
			if((nodeType==Node.ELEMENT_NODE) && (nodeName.equals(nodeToSearch.toLowerCase())))
				nodesFound.add(node);
			if (node.hasChildNodes())
				for (Node nodeFound : searchNodes(node.getChildNodes(), nodeToSearch))
					nodesFound.add(nodeFound);
		}
		return nodesFound;
	}
}
