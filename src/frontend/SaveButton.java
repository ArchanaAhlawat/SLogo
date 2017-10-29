package frontend;

import controller.Controller;
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
	
	protected void save(Controller myController) {
		saveUI.save(myController);
		
		
	
	
		
		
		
		
	}

}
