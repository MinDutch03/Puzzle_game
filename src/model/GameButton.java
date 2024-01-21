package model;

import java.io.FileNotFoundException;
import java.io.FileInputStream;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class GameButton extends Button{
	private final String FONT_PATH= "src/model/resource/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE= "-fx-background-color: transparent; -fx-background-image: url('/model/resource/green_button03.png');";
	private final String BUTTON_FREE_STYLE= "-fx-background-color: transparent; -fx-background-image: url('/model/resource/green_button04.png');";
	
	public GameButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(47);
		setStyle(BUTTON_FREE_STYLE);
		initializedButtonListener ();
	}

	private void setButtonFont() {
		// TODO Auto-generated method stub
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(43);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(47);
		setLayoutY(getLayoutY() - 4);
	}
	private void initializedButtonListener () {
		setOnMousePressed(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
			
		});
		
		setOnMouseReleased(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}
			
		});
		
		setOnMouseEntered(new EventHandler <MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setEffect(new DropShadow());
			}
			
		});
		setOnMouseExited(new EventHandler <MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setEffect(null);
			}
			
		});
	}
}
