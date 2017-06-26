package DBZ.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

import DBZ.MainApp;
import DBZ.SceneManager;
import DBZ.modelo.juego.Juego;
import DBZ.modelo.juego.Jugador;

public class VistaSeleccionEquipoController {

	SceneManager sceneManager;
	Juego juego;
	AnchorPane vistaJuego;
	String equipoSeleccionado = null;
	String equipoJugador1 = null;
	String equipoJugador2 = null;

	@FXML
	Button btnSeleccionar;
	@FXML
	Button btnComenzar;
	@FXML
	AnchorPane equipoVillano;
	@FXML
	AnchorPane equipoZ;
	@FXML
	TextField txtApodo;

	public VistaSeleccionEquipoController() {
		this.juego = new Juego(6);
    }

    @FXML
    private void initialize() {
    	btnComenzar.setVisible(false);
    	btnComenzar.setManaged(false);
    }

    @FXML
    private void handleComenzarJuego(){

    	Jugador jugador = new Jugador(txtApodo.getText());
    	if(equipoJugador1.equals("equipoZ")){
    		juego.agregarJugadorVillano(jugador);
    	} else {
    		juego.agregarJugadorZ(jugador);
    	}


    	if(this.equipoJugador1 != null){
	    	try {

		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("view/vistaJuego.fxml"));
		        vistaJuego = (AnchorPane) loader.load();

	   	        Scene EscenaJuego = new Scene(vistaJuego);

	            sceneManager.cambiarEscena(EscenaJuego);

		        VistaJuegoController controller = loader.getController();
		        controller.setSceneManager(sceneManager);
		        controller.setUpJuego(juego);

		    } catch (IOException e) {

		    }
    	}
    }

    @FXML
    private void handleClickEquipo(MouseEvent event){
    	if(equipoJugador1 == null){
    		AnchorPane elemento = (AnchorPane) event.getTarget();
    		String equipo = elemento.getId().toString();

    		if(this.equipoSeleccionado == null){
    			this.equipoSeleccionado = equipo;
    			elemento.getStyleClass().add("seleccionado");
    		}else{
    			if(this.equipoSeleccionado.equals(equipo)){
    				// no hago nada
    			}else if(equipo.equals("equipoZ")){
    				equipoVillano.getStyleClass().clear();
    				equipoVillano.getStyleClass().addAll("equipoVillano");
    				elemento.getStyleClass().add("seleccionado");
    				this.equipoSeleccionado = equipo;
    			}else if(equipo.equals("equipoVillano")){
    				equipoZ.getStyleClass().clear();
    				equipoZ.getStyleClass().addAll("equipoZ");
    				elemento.getStyleClass().add("seleccionado");
    				this.equipoSeleccionado = equipo;
    			}
    		}
    	}

    }

    @FXML
    private void handleSeleccionEquipo(){
    	if(this.equipoSeleccionado != null) {
			this.equipoJugador1 = this.equipoSeleccionado;

			Jugador jugador = new Jugador(txtApodo.getText());

			txtApodo.setText("");

			if (equipoSeleccionado.equals("equipoZ")) {
				this.juego.agregarJugadorZ(jugador);
				this.equipoJugador2 = "equipoVillano";
				equipoVillano.getStyleClass().add("seleccionado");
				equipoZ.getStyleClass().clear();
			} else {
				this.juego.agregarJugadorVillano(jugador);
				this.equipoJugador2 = "equipoZ";
				equipoZ.getStyleClass().add("seleccionado");
				equipoVillano.getStyleClass().clear();
			}
			Label titulo = (Label) sceneManager.getStage().getScene().lookup("#lblTitulo");
			titulo.setText("Ingrese apodo para el jugador 2:");

			btnSeleccionar.setVisible(false);
			btnSeleccionar.setManaged(false);

			btnComenzar.setVisible(true);
			btnComenzar.setManaged(true);
		}else{
    		sceneManager.show("Seleccione un equipo.");
		}
    }

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

}