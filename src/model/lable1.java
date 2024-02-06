package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class lable1 extends Label {
	public final static String FONT_PATH = "src/model/resource/kenvector_future.ttf";

	public final static String BACKGROUND_IMAGE = "model/resource/yellow_button13.png";

	public lable1(String txt) {
		setPrefWidth(380);
		setPrefHeight(49);
		setText(txt);
		setWrapText(true);
		setLableFont();
		setAlignment(Pos.CENTER);

		BackgroundImage backgroundimage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT
				, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundimage));
	}

	private void setLableFont() {
		// TODO Auto-generated method stub
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
	}
}
