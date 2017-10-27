package frontend;

import javafx.scene.control.Hyperlink;
import javafx.application.Application;
import javafx.geometry.Pos;

public class HelpButton extends Hyperlink {
	
	public HelpButton(String label,double width,double height) {
		super(label);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
	}
	
	protected void GoToHelpPage(String url,Application FEDriver) {
		FEDriver.getHostServices().showDocument(url); 
	}
	
}
