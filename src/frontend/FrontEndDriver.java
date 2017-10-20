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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FrontEndDriver extends Application {
	

	private static final int BUTTONS_Y = 30;
	private static final int LABEL_Y = 0;
	private static final int LABEL_X = 5;
	private static final int HISTORY_WIDTH = 300;
	private static final int RETURN_HEIGHT = 70;
	private static final int RETURN_Y = 530;
	private static final int HISTORY_Y = 100;
	private static final int HISTORY_X = 600;
	private static final int HBOX_SPACING = 20;
	private static final int SUBMIT_BUTTON_WIDTH = 80;
	private static final int SUBMIT_BUTTON_HEIGHT = 40;
	private static final int COMMANDWIDTH = 350;
	private static final int COMMANDHEIGHT = 40;
	private static final int TURTLEAREA_TEXTFILED_SPACE = 50;
	private static final double GRID_X1 = 50;	//this should be the left-most line coordinate of the turtle grid
	private static final double GRID_X2 = 500;	//this should be the right-most line coordinate of the turtle grid
	private static final double GRID_Y1 = 100;	//this should be the top-most line coordinate of the turtle grid
	private static final double GRID_Y2 = 500;	//this should be the bottom-most line coordinate of the turtle grid

    private Pane turtleArea;
	private ImageView turtleImage;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	private TextField command;
	private Text allHistory=new Text("");
	private Pane history;
	
	private static final int VBOX_SPACING = 7;
	private static final int width = 1000;
	private static final int height = 800;
	private static final int button_width = 200;
	private static final int button_height = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons";
	private static final int TURTLESIZE = 50;
	
	public static final double ORIGIN_X = (GRID_X2 - GRID_X1 - TURTLESIZE)/2;
	public static final double ORIGIN_Y = (GRID_Y2 - GRID_Y1 - TURTLESIZE)/2;
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		HBox layout2=new HBox(VBOX_SPACING);
		addLabelsForButtons(layout2);
		
		
		root = new Group();
		
		
		Scene startScene= new Scene(root, width, height);
		//call turtle
		
		root.getChildren().addAll(layout,layout2);
		addAllButtons(layout);
		
		addTurtleImage();
		addTurtleArea();
		addCommandLine();
		addHistory();
		addReturn();
		
		
	
		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	}
	
	private void addLabelsForButtons(HBox hb) {
		hb.setTranslateY(5);
		Label l1=addLabelForButton("ImageLabel");	
		Label l2=addLabelForButton("BackgroundLabel");
		Label l3=addLabelForButton("PenLabel");
		Label l4=addLabelForButton("LanguageLabel");

		
		
		hb.getChildren().addAll(l1,l2,l3,l4);
		
		
	}
	
	private Label addLabelForButton(String name) {
		Label l=new Label(myResources.getString(name));
		l.setPrefWidth(button_width);
		return l;
		
		
	}
	
	private void addCommandLine() {
		
		command = new TextField ();
		command.setPromptText(myResources.getString("Prompt"));
		command.setPrefHeight(COMMANDHEIGHT);
		command.setPrefWidth(COMMANDWIDTH);
		
		Button b=addSubmitButton();
		
		HBox hb = new HBox();
		hb.getChildren().addAll(command,b);
		hb.setSpacing(HBOX_SPACING);
		hb.setTranslateX(GRID_X1);
		hb.setTranslateY(GRID_Y2+TURTLEAREA_TEXTFILED_SPACE);
		root.getChildren().add(hb);
		
	}
	
	private Button addSubmitButton() {
		Button b = new Button(myResources.getString("Submit"));
		b.setPrefSize(SUBMIT_BUTTON_WIDTH, SUBMIT_BUTTON_HEIGHT);
		
		b.setOnAction(e ->{
			String currentCommand=command.getText()+"\n";
			String past=allHistory.getText();
			allHistory=new Text(past+currentCommand);
			allHistory.setTranslateY(50);
			allHistory.setTranslateX(5);
			allHistory.wrappingWidthProperty().bind(history.widthProperty());
			history.getChildren().add(allHistory);
			
			
			
			
			
			
			
			
	
		
		});
		
		return b;
		
	}
	
	private void addHistory() {
		/*
		ScrollPane bp = new ScrollPane();
		bp.setTranslateX(HISTORY_WIDTH);
		bp.setTranslateY(GRID_Y2-GRID_Y1);
		bp.setPrefWidth(width);
		bp.setPrefHeight(height);
		bp.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		root.getChildren().add(bp);
		*/
		history=addPane(HISTORY_X, HISTORY_Y,HISTORY_WIDTH,(GRID_Y2-GRID_Y1));
		Label history_label=addLabel("History",LABEL_X,LABEL_Y);
		history.getChildren().add(history_label);
	
		
	}
	
	private Label addLabel(String labelName,double X, double Y) {
		Label lb=new Label(myResources.getString(labelName));
		lb.setTranslateX(X);
		lb.setTranslateY(Y);
		
		return lb;
	}
	
	
	private void addReturn() {
		Pane returnValue=addPane(HISTORY_X, RETURN_Y,HISTORY_WIDTH,RETURN_HEIGHT);
		Label return_label=addLabel("Return",LABEL_X,LABEL_Y);
		returnValue.getChildren().add(return_label);
		
		
	}
	
	
	private void addTurtleArea() {
	    turtleArea=addPane(GRID_X1,GRID_Y1,(GRID_X2-GRID_X1),(GRID_Y2-GRID_Y1));
	    turtleArea.getChildren().add(turtleImage);
		turtleImage.setX(ORIGIN_X);
		turtleImage.setY(ORIGIN_Y);
		turtleArea.setStyle("-fx-background-color: honeydew");
		
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
	}
	
     

	public void addAllButtons(HBox layout) {
		
		layout.setTranslateY(BUTTONS_Y);
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
	            } catch (Exception ex) {
	                
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
	               
	    		       Paint fill = colorPicker.getValue();  
	               BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
	               Background background = new Background(backgroundFill);
	               turtleArea.setBackground(background);

	            	   
	            	    
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
