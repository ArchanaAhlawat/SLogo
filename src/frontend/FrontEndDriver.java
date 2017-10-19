package frontend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.sun.javafx.collections.ChangeHelper;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
    
	private ImageView turtleImage;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	
	private static final int VBOX_SPACING = 7;
	private static final int width = 1000;
	private static final int height = 800;
	private static final int button_width = 200;
	private static final int button_height = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons";
	private static final int LAYOUTCONSTANT = 50;
	private static final int POPUPWINDOWSIZE = 300;
	private static final int TURTLESIZE = 50;
	
	private static final Paint background = Color.WHITE;



	
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		root = new Group();
		
		
		Scene startScene= new Scene(root, width, height,background);
		//call turtle
		
		root.getChildren().add(layout);
		addAllButtons(layout);
		
		addTurtleImage();
		
	
		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	}



	public void addTurtleImage() {
		turtleImage=new ImageView();
		turtleImage.setFitHeight(TURTLESIZE);
		turtleImage.setFitWidth(TURTLESIZE);
	
		root.getChildren().add(turtleImage);
	}
	
     

	public void addAllButtons(HBox layout) {
		Button b1=turtleImageButton();
		Button b2=backgroundButton();
		Button b3=penColorButton();
		ChoiceBox b4=setUpLanguage();
		Button b5=helpButton();
		layout.getChildren().addAll(b1,b2,b3,b4,b5);
	}
	
	private ChoiceBox setUpLanguage() {
		ChoiceBox<String> cb=makeChoiceBox();
		cb.setPrefWidth(button_width);
		cb.setPrefHeight(button_height);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		        String language=cb.getItems().get((Integer) number2);
		      }
		    });
		
        return cb;
		
	} 
	
	
	private Button turtleImageButton() {
		
		Button b=makeButton(myResources.getString("SetImage"));
		
		b.setOnAction(e ->{
			
			
			 FileChooser fileChooser = new FileChooser();
	            
	            //Set extension filter
	            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	             
	            //Show open file dialog
	            File file = fileChooser.showOpenDialog(null);
	                      
	            try {
	                BufferedImage bufferedImage = ImageIO.read(file);
	                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	                turtleImage.setImage(image);
	            } catch (IOException ex) {
	                Logger.getLogger(FrontEndDriver.class.getName()).log(Level.SEVERE, null, ex);
	            }

			
			
			
			/*
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(myResources.getString("SetImage"));
			File k=fileChooser.showOpenDialog(window);
			*/
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
	
	/*
	
	private Button languageButton() {
		Button b=makeButton(myResources.getString("setlanguage"));
		b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(window);
                Group root=new Group();
                ChoiceBox<String> cb=makeChoiceBox();
                Button submit = new Button("Submit");
               
                root.getChildren().addAll(cb,submit);
                
               
                Scene dialogScene = new Scene(root, POPUPWINDOWSIZE,POPUPWINDOWSIZE);
             
                cb.setTranslateX(POPUPWINDOWSIZE/2-LAYOUTCONSTANT);
                cb.setTranslateY(POPUPWINDOWSIZE/3);
                submit.setTranslateX(cb.getTranslateX()+LAYOUTCONSTANT/2);
                submit.setTranslateY(cb.getTranslateY()+LAYOUTCONSTANT*2);
                
                dialog.setScene(dialogScene);
                dialog.show();
                
                System.out.println(cb.getSelectionModel().getSelectedItem());
            }
         });
				
	
		return b;
	}
	
	*/
	
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
