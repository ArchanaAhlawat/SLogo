package frontend;





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
		Color c=saveUI.getBackColor();
		
		SaveDriver FEDriver=new SaveDriver();
			Stage t = new Stage();
			try {
				FEDriver.setColor(c);
				FEDriver.start(t);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	}
	
	

}
