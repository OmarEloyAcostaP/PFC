package profiler.electrical.grid.core;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import bsxParser.BsxParser;
public abstract class Plugin {	
	
	private PluginFactory pluginFactory;	
	
	public Plugin(PluginFactory pluginFactory){
		this.pluginFactory = pluginFactory;
	}
	
	public void invoke(BsxParser bsxParser){
		Plugin plugin = pluginFactory.getPlugin(bsxParser.getRegisterValue("localName"));
		plugin.execute(bsxParser);
	}

	public abstract void execute(BsxParser bsxParserEvent);
	
	public static int randomInRangeInt(int min, int max){
		return (int) (Math.round(Math.random()*(max-min))+min);		
	}
	
	public static String getDOMAttribute(Node node, String attribute){
		NamedNodeMap attributes =  node.getAttributes();
		for(int i=0; i<attributes.getLength();i++){
			if(attributes.item(i).getNodeName().equals(attribute)||attributes.item(i).getNodeName().equals(attribute)){
				return attributes.item(i).getNodeValue();
			}
		}
		return "";
	}
	
	protected static double strToDouble (String string){
		if (string.equals(""))
			return Double.NaN;
		return Double.valueOf(string).doubleValue();
	}
	
	public static double randomInRangeDouble(double min, double max) {
		return (Math.random()*(max-min))+min;	
	}
	
	public int getCount(Node appliance) {
		String countString = getUndefinedParameter(appliance, "count");
		if (!countString.equals(""))
			return Integer.parseInt(countString);
		return 1;
	}

	public void writeTwoEndElements(BsxParser bsxParserEvent) throws XMLStreamException {
		bsxParserEvent.writeEndElement();
		bsxParserEvent.writeEndElement();
	}

	public void writeNameReleaseStep(BsxParser bsxParserEvent,
			String[] attr) throws XMLStreamException {
		bsxParserEvent.writeAttribute("name", attr[0]);
		if (attr.length > 2) {
			bsxParserEvent.writeAttribute("release", attr[1]);
			bsxParserEvent.writeAttribute("step", attr[2]);

		} else if (attr.length > 2) {
			bsxParserEvent.writeAttribute("release", attr[1]);
		} else {
			bsxParserEvent.writeAttribute("release", "");
		}
	}
	
	public String getUndefinedParameter(Node appliance, String parameter) {
		String count = getDOMAttribute(appliance, parameter);
		if (!count.equals("")) {
			String[] amountPercentages = count.split("@");
			if (amountPercentages.length > 1) {
				double random = Math.random() * 100;
				double randomAmount = 0;
				for (String amountPercentage : amountPercentages) {
					String[] splited = amountPercentage.split("-");
					String amount = splited[0];
					String percentage = splited[1];
					if ((random > randomAmount)
							&& (random < (randomAmount + Double
									.parseDouble(percentage))))
						return amount;
					else
						randomAmount += Double.parseDouble(percentage);
				}
			} else
				return count;
		}
		return "";
	}
}
