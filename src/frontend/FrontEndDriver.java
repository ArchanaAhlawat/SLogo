package frontend;

import java.io.File;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FrontEndDriver extends Application {
	
	private static final double GRID_X1 = 100;	//this should be the left-most line coordinate of the turtle grid
	private static final double GRID_X2 = 200;	//this should be the right-most line coordinate of the turtle grid
	private static final double GRID_Y1 = 120;	//this should be the top-most line coordinate of the turtle grid
	private static final double GRID_Y2 = 220;	//this should be the bottom-most line coordinate of the turtle grid
    
	private static final int POPUPWINDOWSIZE = 300;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	
	private static final int VBOX_SPACING = 7;
	private static final int width = 1000;
	private static final int height = 800;
	private static final int button_width = 200;
	private static final int button_height = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons";
	
	public static final double ORIGIN_X = (GRID_X1 + GRID_X2)/2;
	public static final double ORIGIN_Y = (GRID_Y1 + GRID_Y2)/2;
	
	private static final Paint background = Color.WHITE;



	
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		root = new Group();
		
		
		Scene startScene= new Scene(root, width, height,background);
		
		
		root.getChildren().add(layout);
		addAllButtons(layout);
	
		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	}

	public void addAllButtons(HBox layout) {
		Button b1=turtleImageButton();
		Button b2=backgroundButton();
		Button b3=penColorButton();
		Button b4=languageButton();
		Button b5=helpButton();
		layout.getChildren().addAll(b1,b2,b3,b4,b5);
	}
	
	
	private Button turtleImageButton() {
		
		Button b=makeButton(myResources.getString("SetImage"));
		
		b.setOnAction(e ->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(myResources.getString("SetImage"));
			File k=fileChooser.showOpenDialog(window);
		});
		
		return b;
		
	}
	
	
	private Button backgroundButton() {
		Button b=makeButton(myResources.getString("SetBackground"));
		b.setOnAction(e ->{
			final ColorPicker colorPicker = new ColorPicker();
	        colorPicker.setValue(Color.CORAL);
	        colorPicker.setOnAction(new EventHandler() {
	            public void handle(Event t) {
	                //text.setFill(colorPicker.getValue());
	            	   
	            	    
	            }
	        });
			
		});
		return b;
	}
	
	private Button penColorButton() {
		Button b=makeButton(myResources.getString("SetPenColor"));
		b.setOnAction(e ->{
			
		});
		return b;
	}
	
	private Button languageButton() {
		Button b=makeButton("setlanguage");
		b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(window);
                VBox dialogVbox = new VBox(VBOX_SPACING);
                ChoiceBox<String> cb=makeChoiceBox();
               
                dialogVbox.getChildren().add(cb);
                Scene dialogScene = new Scene(dialogVbox, POPUPWINDOWSIZE,POPUPWINDOWSIZE);
                cb.setTranslateX(dialogVbox.getTranslateX()/2);
                cb.setTranslateY(dialogVbox.getTranslateY()/2);
                dialog.setScene(dialogScene);
                dialog.show();
            }
         });
				
	
		return b;
	}
	
	private ChoiceBox<String> makeChoiceBox() {
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.setItems(FXCollections.observableArrayList(
				"Chinese","English","French","German","Italian","Portuguese","Russian","Spanish")
		);
		
		cb.setValue("English");
		return cb;
		
	}
	
	private Button helpButton() {
		Button b=makeButton("help");
		b.setOnAction(e ->{
			
		});
		return b;
	}
	
	private Button makeButton(String message) {
		Button b = new Button(message);
		b.setPrefSize(button_width, button_height);

		return b;
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
