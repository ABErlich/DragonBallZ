package DBZ.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import DBZ.MainApp;
import DBZ.SceneManager;

public class VistaInicialController {

	private SceneManager sceneManager;

    public VistaInicialController() {
    }

    @FXML
    private void initialize() {
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void handleIniciar(){
    	try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/VistaSeleccionEquipos.fxml"));
            AnchorPane vistaSeleccionEquipos = (AnchorPane) loader.load();

   	        Scene EscenaSeleccionEquipo = new Scene(vistaSeleccionEquipos);
	        VistaSeleccionEquipoController controller = loader.getController();

	        controller.setSceneManager(sceneManager);

	        sceneManager.cambiarEscena(EscenaSeleccionEquipo);

	    } catch (IOException e) {

	    }
    }

}