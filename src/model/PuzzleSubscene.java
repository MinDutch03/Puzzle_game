package model;


import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class PuzzleSubscene extends SubScene{
	
	private final static String FONT_PATH = "src/model/resource/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "model/resource/yellow_panel.png";
	private boolean isHidden;
	

	public PuzzleSubscene() {
		super(new AnchorPane(), 600, 400);
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT
				, BackgroundPosition.DEFAULT, null);
		AnchorPane root = (AnchorPane) this.getRoot();
		
		isHidden = true;
		
		root.setBackground(new Background(image));
		setLayoutX(1024);
		setLayoutY(250);
		// TODO Auto-generated constructor stub
	}
	
	public void moveSubscene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		if (isHidden) {
			transition.setToX(-650);
			isHidden=false;
		}
		else {
			transition.setToX(0);
			isHidden=true;
		}
		transition.play();
	}
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

}
