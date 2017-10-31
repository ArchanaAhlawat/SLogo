package frontend;





import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ResumeButton extends Button {
	
	public ResumeButton(String label,double width,double height) {
		super(label);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
	}
	
	protected void resume(SaveButton saveButton) {
		SaveUI saveUI=saveButton.getSaveUI();
		Color c=Color.web(saveUI.getBack("BackgroundColor"));
		File f=new File(saveUI.getBack("TurtleImage"));
		String language=saveUI.getBack("Language");
		
		SaveDriver FEDriver=new SaveDriver();
			Stage t = new Stage();
			try {
				FEDriver.set(c,f,language);
		
				
				FEDriver.start(t);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	}
	
	

}
