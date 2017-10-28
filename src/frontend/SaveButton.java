package frontend;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class SaveButton extends Button {
	public SaveButton(String label,double width,double height) {
		super(label);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
	}
	
	protected void save(Application FEDriver) {
		
		
	}

}
