package profiler.electrical.grid.core;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Interface extends Applet implements ActionListener {

	Button browse = new Button("Browse...");
	Button execute = new Button("Execute");
	Frame dialog = new Frame("Profiler 0.1"); 
	TextField pathField= new TextField("Write here the path");
	
	public void createMainDialog() {
		// TODO Auto-generated method stub
		dialog.setLayout(new FlowLayout());
		dialog.add(new Label("Profiled XML"));
		dialog.add(pathField);
		dialog.add(browse);
		dialog.add(execute);
		dialog.setSize(400,60); 
		dialog.setVisible(true);
		
		browse.addActionListener(this);
		execute.addActionListener(this);
		
	    dialog.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	         // Main.handlerDialog(Main.EXIT);
	        }
	      });
	    dialog.setResizable(false);
	}
	
	public String saveFileDialog() {
		FileDialog fileSave = new FileDialog (dialog, "Save model", FileDialog.SAVE);
		fileSave.setVisible (true);
		if(fileSave.getDirectory().equals("") || fileSave.getFile().equals(""))
			return "";
		return fileSave.getDirectory() + fileSave.getFile();
	}
	
	public String openFileDialog() {
		FileDialog fileOpen = new FileDialog (dialog, "Select profiled file to proccess", FileDialog.LOAD);
		fileOpen.setVisible (true);
		if((fileOpen.getDirectory() == null) || (fileOpen.getFile() == null))
			return "";
		return fileOpen.getDirectory() + fileOpen.getFile();
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		//if (evt.getSource() == browse)
		//	Main.handlerDialog(Main.EVENTBROWSE);
		//if (evt.getSource() == execute)
		//	Main.handlerDialog(Main.EVENTEXECUTE);
	}
}
