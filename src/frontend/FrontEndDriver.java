package frontend;

import java.awt.image.BufferedImage;
import backend.Driver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
	private static final int HBOX_SPACING = 20;
	private static final int SUBMIT_BUTTON_WIDTH = 80;
	private static final int SUBMIT_BUTTON_HEIGHT = 40;
	private static final int COMMANDWIDTH = 350;
	private static final int COMMANDHEIGHT = 40;
	private static final int TURTLEAREA_TEXTFILED_SPACE = 50;
	private static final int GRID_X1 = 50;	//this should be the left-most line coordinate of the turtle grid
	private static final int GRID_X2 = 500;	//this should be the right-most line coordinate of the turtle grid
	private static final int GRID_Y1 = 100;	//this should be the top-most line coordinate of the turtle grid
	private static final int GRID_Y2 = 500;	//this should be the bottom-most line coordinate of the turtle grid
	private static final int GRID_WIDTH = GRID_X2 - GRID_X1;
	private static final int GRID_HEIGHT = GRID_Y2 - GRID_Y1;
	private static final int HISTORY_WIDTH = 300;
	private static final int HISTORY_HEIGHT = GRID_Y2-GRID_Y1;
	private static final int RETURN_HEIGHT = 70;
	private static final int RETURN_Y = 530;
	private static final int HISTORY_Y = 100;
	private static final int HISTORY_X = 600;
	private static final int VBOX_SPACING = 7;
	private static final int width = 1000;
	private static final int height = 800;
	private static final int button_width = 200;
	private static final int button_height = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons";
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final int TURTLESIZE = 50;
	private static final Color DEFAULT_TURTLEAREA_COLOR = Color.HONEYDEW;

    private Display turtleArea;
	private DisplayTurtle displayTurtle;
	private TurtlePath turtlePath;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	private TextField command;
	private History commandHistory;
	private ReturnValue returnValue;
	private double commandValue;
	
	private Driver BEdriver = new Driver();
	
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
		
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
		addTurtleImage();
		turtleArea= new Display(displayTurtle,GRID_X1,GRID_Y1,GRID_WIDTH,GRID_HEIGHT);
		addCommandLine();
		commandHistory = new History(myResources.getString("History"),HISTORY_X,HISTORY_Y,HISTORY_WIDTH,HISTORY_HEIGHT);
		returnValue = new ReturnValue(myResources.getString("Return"),HISTORY_X, RETURN_Y,HISTORY_WIDTH,RETURN_HEIGHT);
		
		root.getChildren().addAll(turtlePath,turtleArea,commandHistory,returnValue);
	
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
			if (command.getText().equals(null)) {
				System.out.println("error");
				
			}
			else {
			String currentCommand=command.getText();
			
			try {
				commandValue=BEdriver.setCommand(currentCommand);
				
				
				
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | InstantiationException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			commandHistory.addHistory(currentCommand);
			returnValue.addReturnValue(commandValue);
			command.clear();
			}
		
		
		});
		
		return b;
		
	}
	
	private Label addLabel(String labelName,double X, double Y) {
		Label lb=new Label(myResources.getString(labelName));
		lb.setTranslateX(X);
		lb.setTranslateY(Y);
		
		return lb;
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

	private void addTurtleImage() {
		File file = new File(DEFAULT_TURTLE_DIRECTORY);
        Image image = new Image(file.toURI().toString());
		displayTurtle = new DisplayTurtle(image,ORIGIN_X,ORIGIN_Y,TURTLESIZE);
	}

	private void addAllButtons(HBox layout) {
		
		layout.setTranslateY(BUTTONS_Y);
		Button b1=turtleImageButton();
		
		final ColorChooser b2 = new BackgroundPicker(Color.HONEYDEW,button_width,button_height,turtleArea);
		final ColorPicker b3= new PenPicker(Color.BLACK,button_width,button_height,turtlePath);
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
	            fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
	            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	             
	            //Show open file dialog
	            File file = fileChooser.showOpenDialog(null);
	                      
	            try {
	                BufferedImage bufferedImage = ImageIO.read(file);
	                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	                displayTurtle.setImage(image);
	            } catch (Exception ex) {
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
