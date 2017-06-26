package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonStartGame implements EventHandler<ActionEvent>{
	Stage stage;
	Scene escenaSiguiente;

	public BotonStartGame(Stage stage, Scene escenaSiguiente) {
		// TODO Auto-generated constructor stub
		this.stage=stage;
		this.escenaSiguiente=escenaSiguiente;
		
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		stage.setScene(escenaSiguiente);
        stage.setFullScreenExitHint("");
		
	}

}
