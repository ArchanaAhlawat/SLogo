package frontend;

import javafx.scene.control.Button;

public class SubmitButton extends Button {

	public SubmitButton(String label, double width, double height) {
		super(label);
		this.setPrefSize(width, height);
	}
	
}
