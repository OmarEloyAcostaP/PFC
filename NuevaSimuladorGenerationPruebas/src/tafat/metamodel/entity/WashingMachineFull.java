/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
 *****/
package tafat.metamodel.entity;

import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;

public class WashingMachineFull extends WashingMachine {

	public enum Labelling {
		AAAA(0), AAA(1), AA(2), A(3), B(4), C(5), D(6), E(7), F(8), G(9);
		private double value;

		Labelling(double val) {
			value = val;
		}

		public double getValue() {
			return value;
		}
	}

	public enum PhasesSystem {
		SINGLE_PHASE_AND_NEUTRAL(0), THREE_PHASE_WITHOUT_NEUTRAL(1), THREE_PHASE_AND_NEUTRAL(
				2);
		private double value;

		PhasesSystem(double val) {
			value = val;
		}

		public double getValue() {
			return value;
		}
	}

	public enum VoltageLevel {
		LOW(0), MEDIUM(1), HIGH(2);
		private double value;

		VoltageLevel(double val) {
			value = val;
		}

		public double getValue() {
			return value;
		}
	}

	public enum Mode {
		OFF(0), ON40(1), ON60(2), ON95(3);
		private double value;

		Mode(double val) {
			value = val;
		}

		public double getValue() {
			return value;
		}
	}

	// Features
	public Labelling labelling;
	public double load;// ( kg )
	public PhasesSystem phasesSystem;// ( kg )
	public VoltageLevel voltageLevel;// ( kg )

	// Variables
	public Mode mode;
	public double powerFactor;

	public WashingMachineFull() {

	}

	public void setDefaultValues() throws ParseException {
		super.setDefaultValues();
		labelling = Labelling.A;
		load = 6;
		phasesSystem = PhasesSystem.SINGLE_PHASE_AND_NEUTRAL;
		voltageLevel = VoltageLevel.LOW;
		powerFactor = 0.0;

	}

	public void loadAttribute(String name, String value) throws ParseException {
		if (name.equals("labelling"))
			labelling = Labelling.valueOf(value.toUpperCase());
		else if (name.equals("load"))
			load = UnitConversor.parse(value, "kg");
		else if (name.equals("phasesSystem"))
			phasesSystem = PhasesSystem.valueOf(value.toUpperCase());
		else if (name.equals("voltageLevel"))
			voltageLevel = VoltageLevel.valueOf(value.toUpperCase());
		else if (name.equals("mode"))
			mode = Mode.valueOf(value.toUpperCase());
		else if (name.equals("powerFactor"))
			powerFactor = Double.parseDouble(value);
		else
			super.loadAttribute(name, value);
	}

	public String toString() {
		String result = "";
		result += "<feature name=\"labelling\" value=\"" + labelling.toString()
				+ "\"/>\n";
		result += "<feature name=\"load\" value=\"" + load + "\"/>\n";
		result += "<feature name=\"phasesSystem\" value=\""
				+ phasesSystem.toString() + "\"/>\n";
		result += "<feature name=\"voltageLevel\" value=\""
				+ voltageLevel.toString() + "\"/>\n";
		result += "<feature name=\"mode\" value=\"" + mode.toString()
				+ "\"/>\n";
		result += "<feature name=\"powerFactor\" value=\"" + powerFactor
				+ "\"/>\n";
		return result;

	}

}
