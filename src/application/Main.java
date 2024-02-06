package application;

import Scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SceneManager manager = new SceneManager();
			primaryStage = manager.getMainStage();
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("298852_puzzle_icon.png")));
			primaryStage.setTitle("Puzzle");

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
