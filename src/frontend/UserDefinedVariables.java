package frontend;


import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserDefinedVariables extends History {
	  private Stage window;
	

	
	
	
	public UserDefinedVariables(String label, int x, int y, int width, int height,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Controller myController,Display turtlePane,Stage window) {
		super(label, x, y, width, height,displayTurtleManager,returnValue,myController,turtlePane);
		// TODO Auto-generated constructor stub
		this.window=window;
	
	

	}
	
	
	
    @Override
	protected void handleMouseClick(MouseEvent e,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Text current,Controller myController,Display turtleArea) {
    	   
    	    
    	    
    	    String currentCommand=current.getText().trim();
    	    String variable=currentCommand.split(":")[0];
    	    popUp(variable);
    	    
    	    System.out.println(currentCommand);
    	    
       

	}
    
    
    private void popUp(String variable) {
      	final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(window);
        VBox dialogVbox = new VBox(20);
        TextField newValue=new TextField();
        Button submit=new Button("Submit");
        submit.setOnAction(e -> handlePopUp(variable,newValue,myController));
        dialogVbox.getChildren().addAll(newValue,submit);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    	
    }
    
    private void handlePopUp(String variable,TextField newValue, Controller myController) {
    	   String newV=newValue.getText().trim();
    	   myController.setCommand("make :"+variable+" "+newV);
    	   
    	
    }
	
}

