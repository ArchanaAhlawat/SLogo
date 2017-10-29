package frontend;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewWorkSpaceButton extends Button {
	
	public NewWorkSpaceButton(String label, double width, double height) {
		super(label);
		this.setPrefSize(width, height);
	}
	
	protected void createNewWorkSpace() {
		    FrontEndDriver FEDriver=new FrontEndDriver();
			Stage t = new Stage();
			try {
				FEDriver.start(t);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	}

}
