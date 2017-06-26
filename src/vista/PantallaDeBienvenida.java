package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controladores.BotonStartGame;
import controladores.BotonExit;

public class PantallaDeBienvenida extends VBox{
	Stage stage;
	//Constructor
	public PantallaDeBienvenida(Stage stage, Scene EscenaSiguiente){
		 super();
		 
		 this.stage = stage;
		 this.setAlignment(Pos.CENTER);
	     this.setSpacing(20);
	     this.setPadding(new Insets(25));
	     
	     //Visualizar la pantalla de bienvenida
	     Image imagen = new Image("/vista/imagenes/imagenInicio.png");
	     BackgroundSize backgroundSize = new BackgroundSize(1500, 950, true, true, true, false);
	     BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
	     this.setBackground(new Background(imagenDeFondo));
	     //Visualizar los botones
	     //Button botonInicio=new Button("Start Game...");
	     Button botonSalir = new Button("Exit...");
	     Button botonInicio = new Button("Start Game...");
	     botonInicio.setStyle("-fx-font: 30 arial; -fx-base: #6a2125;");
	     botonSalir.setStyle("-fx-font: 30 arial; -fx-base: #6a2125;");
	     
	     BotonStartGame botonStart =new BotonStartGame(stage, EscenaSiguiente);
	     BotonExit botonExit=new BotonExit();
	     
	     botonInicio.setOnAction(botonStart);
	     botonSalir.setOnAction(botonExit);
	     this.getChildren().addAll(botonInicio, botonSalir);

	}

}

