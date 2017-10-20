package frontend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FrontEndDriver extends Application {
	

	private static final int HISTORY_WIDTH = 300;
	private static final int HISTORY_Y = 70;
	private static final int HISTORY_X = 600;
	private static final int HBOX_SPACING = 20;
	private static final int SUBMIT_BUTTON_WIDTH = 80;
	private static final int SUBMIT_BUTTON_HEIGHT = 40;
	private static final int COMMANDWIDTH = 350;
	private static final int COMMANDHEIGHT = 40;
	private static final int TURTLEAREA_TEXTFILED_SPACE = 50;
	private static final Color DEFAULTBACKGROUND = Color.ALICEBLUE;
	private static final double GRID_X1 = 50;	//this should be the left-most line coordinate of the turtle grid
	private static final double GRID_X2 = 500;	//this should be the right-most line coordinate of the turtle grid
	private static final double GRID_Y1 = 70;	//this should be the top-most line coordinate of the turtle grid
	private static final double GRID_Y2 = 500;	//this should be the bottom-most line coordinate of the turtle grid

    private Pane turtleArea;
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
	private static final int TURTLESIZE = 50;
	
	public static final double ORIGIN_X = (GRID_X1 + GRID_X2)/2;
	public static final double ORIGIN_Y = (GRID_Y1 + GRID_Y2)/2;
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		root = new Group();
		
		
		Scene startScene= new Scene(root, width, height);
		//call turtle
		
		root.getChildren().add(layout);
		addAllButtons(layout);
		
		addTurtleImage();
		addTurtleArea();
		addCommandLine();
		addHistory();
		
		
	
		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	}
	
	private void addCommandLine() {
		
		TextField command = new TextField ();
		command.setPromptText(myResources.getString("Prompt"));
		command.setPrefHeight(COMMANDHEIGHT);
		command.setPrefWidth(COMMANDWIDTH);
		
		Button b = new Button(myResources.getString("Submit"));
		b.setPrefSize(SUBMIT_BUTTON_WIDTH, SUBMIT_BUTTON_HEIGHT);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(command,b);
		hb.setSpacing(HBOX_SPACING);
		hb.setTranslateX(GRID_X1);
		hb.setTranslateY(GRID_Y2+TURTLEAREA_TEXTFILED_SPACE);
		root.getChildren().add(hb);
		
	}
	
	private void addHistory() {
		Pane history=addPane(HISTORY_X, HISTORY_Y,HISTORY_WIDTH,(GRID_Y2-GRID_Y1));

		Label history_label=new Label("History:");
	
		history_label.setTranslateX(HISTORY_X);
		history_label.setTranslateY(HISTORY_Y);
		history.getChildren().add(history_label);
		
		
		root.getChildren().add(history_label);
		
		
	}
	
	
	
	private void addTurtleArea() {
	    turtleArea=addPane(GRID_X1,GRID_Y1,(GRID_X2-GRID_X1),(GRID_Y2-GRID_Y1));
		//turtleImage.setTranslateX(ORIGIN_X);
		//turtleImage.setTranslateY(ORIGIN_Y);
		turtleImage.relocate(ORIGIN_X, ORIGIN_Y);
		turtleArea.setStyle("-fx-background-color: honeydew");
		turtleArea.getChildren().add(turtleImage);
		
		
	}
	
	private Pane addPane(double X, double Y,double width,double height) {
		Pane bp=new Pane();
		bp.setTranslateX(X);
		bp.setTranslateY(Y);
		bp.setPrefWidth(width);
		bp.setPrefHeight(height);
		bp.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		root.getChildren().add(bp);
		return bp;
		
	}
	



	public void addTurtleImage() {
		File file = new File("src/resources/turtle.png");
        Image image = new Image(file.toURI().toString());
        turtleImage= new ImageView(image);
		turtleImage.setFitHeight(TURTLESIZE);
		turtleImage.setFitWidth(TURTLESIZE);
		
	
		root.getChildren().add(turtleImage);
	}
	
     

	public void addAllButtons(HBox layout) {
		Button b1=turtleImageButton();
		
		final ColorPicker b2 = backgroundButton();
		final ColorPicker b3=penColorButton();
		ChoiceBox b4=setUpLanguage();
		Hyperlink b5=helpButton();
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

			
			
		
		});
		
		return b;
		
	}
	
	
	private ColorPicker backgroundButton() {
		final ColorPicker colorPicker = new ColorPicker();
		colorPicker.setPrefWidth(button_width);
		colorPicker.setPrefHeight(button_height);	
	    colorPicker.setValue(Color.WHITE);
	    colorPicker.setOnAction(new EventHandler<ActionEvent>() {
	    	  @Override
	        public void handle(ActionEvent t) {
	                //turtleArea.setFill(colorPicker.getValue());
	    		       Paint fill = colorPicker.getValue();

	            	   
	            	    
	        }
	    });
			
		
		return colorPicker;
	}
	
	private ColorPicker penColorButton() {
		final ColorPicker colorPicker = new ColorPicker();
		colorPicker.setPrefWidth(button_width);
		colorPicker.setPrefHeight(button_height);	
	    colorPicker.setValue(Color.WHITE);
	   
	    colorPicker.setOnAction(new EventHandler<ActionEvent>() {
	    	
	         @Override
	        public void handle(ActionEvent t) {
	                //text.setFill(colorPicker.getValue());
	            	   
	            	    
	        }
	    });
			
		
		return colorPicker;
	}
	
	
	private ChoiceBox<String> makeChoiceBox() {
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.setItems(FXCollections.observableArrayList(
				"Chinese","English","French","German","Italian","Portuguese","Russian","Spanish")
		);
		
		cb.setValue("English");
		return cb;
		
	}
	
	private Hyperlink helpButton() {
		
		final Hyperlink help = new Hyperlink(myResources.getString("Help"));
		help.setPrefHeight(button_height);
		help.setPrefWidth(button_width);
		help.setAlignment(Pos.CENTER);
		 help.setOnAction(new EventHandler<ActionEvent>() {

			 @Override
		        public void handle(ActionEvent e) {
		   
		            try {
		            	   getHostServices().showDocument(myResources.getString("HelpPage"));

		            } catch (final Exception exc) {
		                System.out.println("Error: the following link could not be open:" + help.getText());
		            }
		        }});
		 
		return help;
	}
	
	private Button makeButton(String message) {
		Button b = new Button(message);
		b.setPrefSize(button_width, button_height);
		b.setAlignment(Pos.CENTER_LEFT);

		return b;
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
