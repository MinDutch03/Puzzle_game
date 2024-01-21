package Scene;


import java.util.ArrayList;
import java.util.List;

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

public class SceneManager {
	private final static int HEIGHT=768;
	private final static int WIDTH=1024;
	
	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private PuzzleSubscene creditscene;
	private PuzzleSubscene helpscene;
	private PuzzleSubscene scorescene;
	private PuzzleSubscene loadImagescene;
	
	private final static int NEW_BUTTON_START_X =100;
	private final static int NEW_BUTTON_START_Y =340;
	
	private PuzzleSubscene sceneToHide;
	
	List<PuzzleButton> buttonlist;
	
	public SceneManager() {
		buttonlist = new ArrayList<>();
		
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		
		createSubscene();
		createButton();
		createBackground();
		createTitle();
		
//		PuzzleSubscene subscene = new PuzzleSubscene();
//		subscene.setLayoutX(200);
//		subscene.setLayoutY(100);
//		mainPane.getChildren().add(subscene);
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
		createScoreSubscene();
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
		loadImagescene.getPane().getChildren().add(createSheepGameButton());
		loadImagescene.getPane().getChildren().add(createCelticButton());
	}

	private void createButton() {
		createStartButton();
		//createScoreButton();
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
				showSubscene(loadImagescene);
			}
			
		});
	}
	
	

	private void createScoreButton() {
		// TODO Auto-generated method stub
		PuzzleButton ScoreButton = new PuzzleButton("SCORE");
		addMenuButton(ScoreButton);
		
		ScoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				showSubscene(scorescene);
			}
			
		});
		
	}
	private void createScoreSubscene() {
		scorescene = new PuzzleSubscene();
		mainPane.getChildren().add(scorescene);
		lable score = new lable("<<<< Scores >>>>");
		score.setLayoutX(115);
		score.setLayoutY(20);
		VBox scoreContainer = new VBox();
		scoreContainer.setLayoutX(120);
		scoreContainer.setLayoutY(120);
		
		lable scoreHeading = new lable("     Time			Score   ");
		scoreHeading.setUnderline(true);
		lable score1 = new lable("  0:00	              100");
		scoreHeading.setFont(Font.font("Verdana",20));
		score1.setFont(Font.font("Verdana",20));
		scoreContainer.setBackground(new Background(new BackgroundFill(Color.MEDIUMAQUAMARINE, new CornerRadii(20), new Insets(-20,-20,-20,-20))));
		scoreContainer.getChildren().addAll(scoreHeading, score1);
		
		scorescene.getPane().getChildren().addAll(score, scoreContainer);//, score1, score2, score3);		
		
	}
	
//	private void createHelpButton() {
//		// TODO Auto-generated method stub
//		PuzzleButton HelpButton = new PuzzleButton("HELP");
//		addMenuButton(HelpButton);
//		
//		HelpButton.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				showSubscene(helpscene);
//			}
//			
//		});
//	}
	
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
		
		lable credits = new lable("  <<< Credits >>>");
		credits.setLayoutX(120);
		credits.setLayoutY(20);
		lable credit0 = new lable("Nguyen Minh Duc - ");
		lable credit1 = new lable("Luong Duc Huy - ");
		lable credit2 = new lable("Lam Thanh Tue - ");
		
//		String[]link    = new String[6];
//				link[0] = "https://www.youtube.com/playlist?list=PL4wcbt63yAbdtY-GOeuRjIePfUsukSJZ9";
//				link[1] = "https://freesound.org/";
//				link[2] = "http://soundbible.com/";
//				link[3] = "https://www.freesoundslibrary.com/";
//				link[4] = "https://kenney.nl/";
//				link[5] = "https://dhakalkumar.github.io/";
//				
//		Hyperlink link0, link1, link2, link3, link4, link5;
//		link0 = new Hyperlink(link[0]);
//		link1 = new Hyperlink(link[1]);
//		link2 = new Hyperlink(link[2]);
//		link3 = new Hyperlink(link[3]);
//		link4 = new Hyperlink(link[4]);
//		link5 = new Hyperlink(link[5]);
//				
		VBox creditsBox = new VBox(10, credit0, credit1, credit2);
//		
		creditsBox.setLayoutX(50);
		creditsBox.setLayoutY(80);
		creditscene.getPane().getChildren().addAll(credits, creditsBox);
//		
//		Application app = new Application() {@Override public void start(Stage primaryStage) throws Exception{}};
//		HostServices services = app.getHostServices();
//		
//		link0.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[0]);
//			}
//		});
//		link1.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[1]);
//			}
//		});
//		link2.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[2]);
//			}
//		});
//		link3.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[3]);
//			}
//		});
//		link4.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[4]);
//			}
//		});
//		link5.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				services.showDocument(link[5]);
//			}
//		});
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
	private GameButton createSheepGameButton() {
		GameButton game1Button = new GameButton("Sheep");
		game1Button.setLayoutX(100);
		game1Button.setLayoutY(180);
		
//		double buttonWidth = 230;
//	    double buttonHeight = 47;
//	    loadButton.setPrefWidth(buttonWidth);
//	    loadButton.setPrefHeight(buttonHeight);
		
		game1Button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				 //TODO Auto-generated method stub
				Puzzle puzzle = new Puzzle();
			}
			
		});
		return game1Button;
	}
	
	private GameButton createCelticButton() {
		GameButton game2Button = new GameButton("Celtic");
		game2Button.setLayoutX(330);
		game2Button.setLayoutY(180);
		
//		double buttonWidth = 230;
//	    double buttonHeight = 47;
//	    loadButton.setPrefWidth(buttonWidth);
//	    loadButton.setPrefHeight(buttonHeight);
		
		game2Button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				 //TODO Auto-generated method stub
				
			}
			
		});
		return game2Button;
	}

	private void createBackground() {
		Image backgroundImage = new Image ("Scene/resource/backgroundColorForest.png", 256, 800, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createTitle() {
		ImageView title = new ImageView("Scene/resource/Design-Studio-2024-01-20 (1).png");
		
		title.setLayoutX(-310);
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
