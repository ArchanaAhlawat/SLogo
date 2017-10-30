package frontend;


import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class SaveButton extends Button {
	SaveUI saveUI=new SaveUI();


	public SaveButton(String label,double width,double height) {
		super(label);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
	
	}
	
	public SaveUI getSaveUI() {
		return saveUI;
	}
	
	protected void save(LanguageChooser languageChooser,BackgroundPicker backgroundPicker,TurtleImageButton turtleImageButton) {
		saveUI.save(languageChooser,backgroundPicker,turtleImageButton);
		
		
	
	
		
		
		
		
	}

}
