package frontend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class TurtleImageButton extends Button{
	private FileChooser fileChooser;

	public TurtleImageButton(String label, double width, double height) {
		super(label);
		this.setPrefSize(width, height);
		buildFileChooser();
		// TODO Auto-generated constructor stub
	}
	
	private void buildFileChooser() {
		fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	}

	protected Image chooseTurtleImage(DisplayTurtle currentDisplayTurtle) {
		Image currentImage = currentDisplayTurtle.getImage();
		File file = fileChooser.showOpenDialog(null);
		if(file == null) {
			return currentImage;
		}
		else {
            try {
            	BufferedImage bufferedImage = ImageIO.read(file);
            	Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            	return image;
            }
            catch(IOException e) {
            	Alert a = new Alert(AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.showAndWait(); 
                return currentImage;
            }
		}
	}
}
