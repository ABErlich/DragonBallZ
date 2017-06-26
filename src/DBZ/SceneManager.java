package DBZ;

import java.io.IOException;

import DBZ.view.VistaInicialController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SceneManager {

    private Stage stage;

    public SceneManager(MainApp mainApp){

    }

    public void start(Stage vista){
    	this.stage = vista;
    	this.stage.setTitle("Dragon Ball: El juego");

    	Scene escenaInicio = this.EscenaInicio();

        stage.setScene(escenaInicio);
        stage.show();

    }

    private Scene EscenaInicio() {
    	Scene escenaInicio = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/vistaInicial.fxml"));
			AnchorPane vistaInicial = (AnchorPane) loader.load();
			escenaInicio = new Scene(vistaInicial);

	        VistaInicialController controller = loader.getController();
	        controller.setSceneManager(this);

		} catch (IOException e) {

		}
        return escenaInicio;
	}

	public Stage getStage() {
		return stage;
	}

	public void cambiarEscena(Scene escena){
    	this.stage.setScene(escena);
    	this.stage.show();
    }

	public void show(String message) {
		final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(this.stage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(message));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
	}

}
