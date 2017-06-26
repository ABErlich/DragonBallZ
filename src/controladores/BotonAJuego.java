package controladores;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotonAJuego implements EventHandler<ActionEvent>{
	
	Stage stage;
	Scene EscenaSiguiente;
	private TextField textFieldV;
    private Label labelV;
    private TextField textFieldZ;
    private Label labelZ;
	
	
	/*public static String jugadorVillano;
	public static String jugadorGuerreroZ;
	TextField jugadorV;
	TextField jugadorZ;*/
	public BotonAJuego(Stage stage,TextField textjugadorV,TextField textjugadorZ,Label etiquetaVillano,Label etiquetaZ,Scene EscenaSiguiente){
		this.stage=stage;
		this.EscenaSiguiente=EscenaSiguiente;
		this.textFieldV=textjugadorV;
		this.textFieldZ=textjugadorZ;
		this.labelV=etiquetaVillano;
		this.labelZ=etiquetaZ;
		
		
		
	}
		@Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
	    
		/*JUGADORVILLANO=this.jugadorVillano.getText();
		JUGADORZ=this.jugadorGuerreroZ.getText();*/
			this.labelV.setText("Equipo Villano--->>"+this.textFieldV.getText());
			this.labelV.setFont(Font.font("Tahoma",FontWeight.NORMAL,25));
			this.labelV.setTextFill(Color.web("#FF0000"));
			 this.labelZ.setText("Equipo GuerreroZ--->>"+this.textFieldZ.getText());
			 this.labelZ.setFont(Font.font("Tahoma",FontWeight.NORMAL,25));
			 this.labelZ.setTextFill(Color.web("#1F7B17"));
		//System.out.println(jugadorVillano);
		//System.out.println(jugadorGuerreroZ);
		stage.setScene(EscenaSiguiente);
        stage.setFullScreenExitHint("");
        
		}
		
}