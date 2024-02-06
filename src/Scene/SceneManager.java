package Scene;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.GameButton;
import model.PuzzleButton;
import model.PuzzleSubscene;
import model.lable;
import model.lable1;

public class SceneManager {
	private final static int HEIGHT=768;
	private final static int WIDTH=1024;


	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private PuzzleSubscene creditscene;
	private PuzzleSubscene helpscene;
	private PuzzleSubscene loadImagescene;

	private final static int NEW_BUTTON_START_X =100;
	private final static int NEW_BUTTON_START_Y =270;

	private PuzzleSubscene sceneToHide;

	List<PuzzleButton> buttonlist;

	public SceneManager() {
		buttonlist = new ArrayList<>();

		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);

		gameMusic music = new gameMusic("/Scene/resource/periwinkle.wav");

		createSubscene();
		createButton();
		createBackground();
		createTitle();


//		PuzzleSubscene subscene = new PuzzleSubscene();
//		subscene.setLayoutX(200);
//		subscene.setLayoutY(100);
//		mainPane.getChildren().add(subscene);
		music.play();
		music.loop();
	}

	private void showSubscene(PuzzleSubscene Subscene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubscene();
		}
		Subscene.moveSubscene();
		sceneToHide = Subscene;
	}


	public Stage getMainStage() {
		// Disable full-screen mode for the mainPane
		Stage mainStage = (Stage) mainPane.getScene().getWindow();
		mainStage.setFullScreenExitHint("");
		mainStage.setFullScreen(false);
		mainStage.setResizable(false);
		return mainStage;
	}

	public void createSubscene() {
		creditscene = new PuzzleSubscene();
		mainPane.getChildren().add(creditscene);

		helpscene = new PuzzleSubscene();
		mainPane.getChildren().add(helpscene);

//		scorescene = new PuzzleSubscene();
//		mainPane.getChildren().add(scorescene);

		loadImagescene = new PuzzleSubscene();
		mainPane.getChildren().add(loadImagescene);

		createImageBrowseScene();
		createHelpSubscene();
		createCreditsSubscene();
	}

	private void createImageBrowseScene() {
		// TODO Auto-generated method stub
		loadImagescene = new PuzzleSubscene();
		mainPane.getChildren().add(loadImagescene);


		lable browseImage = new lable("CHOOSE YOUR IMAGE");
		browseImage.setLayoutX(110);
		browseImage.setLayoutY(25);

		loadImagescene.getPane().getChildren().add(browseImage);

	}

	private void createButton() {
		createStartButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();

//		PuzzleButton button = new PuzzleButton("Play");
//		mainPane.getChildren().add(button);
//
//		button.setLayoutX(200);
//		button.setLayoutY(200);
	}
	private void addMenuButton(PuzzleButton Button) {
		// TODO Auto-generated method stub

		Button.setLayoutX(NEW_BUTTON_START_X);
		Button.setLayoutY(NEW_BUTTON_START_Y + buttonlist.size() * 100);
		buttonlist.add(Button);
		mainPane.getChildren().add(Button);

	}

	private void createStartButton() {
		// TODO Auto-generated method stub
		PuzzleButton StartButton = new PuzzleButton("START");
		addMenuButton(StartButton);

		StartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Puzzle puzzle = new Puzzle();
			}

		});
	}



	private void createHelpButton() {
		// TODO Auto-generated method stub
		PuzzleButton HelpButton = new PuzzleButton("Help");
		addMenuButton(HelpButton);

		HelpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				showSubscene(helpscene);
			}

		});

	}
	private void createHelpSubscene() {
		helpscene = new PuzzleSubscene();
		mainPane.getChildren().add(helpscene);

		lable1 help = new lable1("  <<< How To Play >>>  ");
		help.setLayoutX(120);
		help.setLayoutY(20);
		lable help0 = new lable("1. Select the grid size (4, 9, ..)");
		lable help1 = new lable("2. Match all the edges with the neighboring");
		lable help11 = new lable ("pieces.");
		lable help2 = new lable("3. When click on a piece, it is indicated");
		lable help21 = new lable ("with a thick red line.");
		lable help3 = new lable("4. Each piece can be rotated and switched.");
		lable help4 = new lable("5. All pieces should be placed correctly");
		lable help41 = new lable("and should be deselected to complete");
		lable help42 = new lable("the puzzle");

		VBox helpBox = new VBox(10, help0, help1, help11, help2, help21, help3, help4, help41, help42);

		helpBox.setLayoutX(30);
		helpBox.setLayoutY(80);
		helpscene.getPane().getChildren().addAll(help, helpBox);

	}


	private void createCreditsButton() {
		// TODO Auto-generated method stub
		PuzzleButton CreditButton = new PuzzleButton("CREDIT");
		addMenuButton(CreditButton);

		CreditButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				showSubscene(creditscene);
			}

		});
	}
	private void createCreditsSubscene() {
		creditscene = new PuzzleSubscene();
		mainPane.getChildren().add(creditscene);

		lable1 credits = new lable1("  <<< Credits >>>");
		credits.setLayoutX(120);
		credits.setLayoutY(20);
		lable1 credit0 = new lable1("   Nguyen Minh Duc ");
		lable1 credit1 = new lable1("   Luong Duc Huy ");
		lable1 credit2 = new lable1("   Lam Thanh Tue ");

		VBox creditsBox = new VBox(10, credit0, credit1, credit2);

		creditsBox.setLayoutX(120);
		creditsBox.setLayoutY(120);
		creditscene.getPane().getChildren().addAll(credits, creditsBox);

	}


	private void createExitButton() {
		// TODO Auto-generated method stub
		PuzzleButton ExitButton = new PuzzleButton("EXIT");
		addMenuButton(ExitButton);

		ExitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mainStage.close();
			}

		});

	}


	private void createBackground() {
		Image backgroundImage = new Image ("Scene/resource/backgroundColorForest.png", 256, 800, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	private void createTitle() {
		ImageView title = new ImageView("Scene/resource/Design-Studio-2024-02-04 (1).png");

		title.setLayoutX(-290);
		title.setLayoutY(-420);

		title.setOnMouseEntered(new EventHandler <MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				title.setEffect(new DropShadow());
			}

		});

		title.setOnMouseExited(new EventHandler <MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				title.setEffect(null);
			}

		});

		mainPane.getChildren().add(title);
	}

}
