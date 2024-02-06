package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class lable extends Label {
    public final static String FONT_PATH = "src/model/resource/kenvector_future.ttf";

//	public final static String BACKGROUND_IMAGE = "model/resource/yellow_button13.png";

    public lable(String txt) {
        setPrefWidth(800);
        setPrefHeight(20);
        setText(txt);
        setWrapText(true);
        setLableFont();
//		setAlignment(Pos.CENTER);

    }

    private void setLableFont() {
        // TODO Auto-generated method stub
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 18));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }
}
