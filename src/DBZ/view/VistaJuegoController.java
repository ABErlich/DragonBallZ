package DBZ.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.util.Optional;

import DBZ.SceneManager;
import DBZ.modelo.juego.Juego;
import DBZ.modelo.juego.Jugador;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Freezer;
import DBZ.modelo.personajes.Gohan;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.personajes.MajinBoo;
import DBZ.modelo.personajes.Piccolo;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.tablero.Coordenada;

public class VistaJuegoController {

	Juego juego;
	Jugador jugadorActual;

	@FXML
	Label lblJugadorZ;
	@FXML
	Label lblJugadorVillano;
	@FXML
	Pane PanelFlecha;

    Pane PanelPersonajeSeleccionado;
    IPersonaje personajeSeleccionado;

    @FXML
    Label gokuVidaMax;
    @FXML
    Label gohanVidaMax;
    @FXML
    Label piccoloVidaMax;
    @FXML
    Label freezerVidaMax;
    @FXML
    Label cellVidaMax;
    @FXML
    Label majinbooVidaMax;

    @FXML
    Label gokuVida;
    @FXML
    Label gohanVida;
    @FXML
    Label piccoloVida;
    @FXML
    Label freezerVida;
    @FXML
    Label cellVida;
    @FXML
    Label majinbooVida;

    @FXML
    Label gokuKi;
    @FXML
    Label gohanKi;
    @FXML
    Label piccoloKi;
    @FXML
    Label freezerKi;
    @FXML
    Label cellKi;
    @FXML
    Label majinbooKi;

    Goku goku;
    Gohan gohan;
    Piccolo piccolo;
    Freezer freezer;
    Cell cell;
    MajinBoo majinboo;

    @FXML
    Pane pGoku;
    @FXML
    Pane pGohan;
    @FXML
    Pane pPiccolo;
    @FXML
    Pane pFreezer;
    @FXML
    Pane pCell;
    @FXML
    Pane pMajinboo;

    @FXML
    GridPane tablero;
	private SceneManager sceneManager;

    public VistaJuegoController() {
    }

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public void setUpJuego(Juego juego) {
		this.juego = juego;
		goku = juego.getGoku();
		gohan = juego.getGohan();
		piccolo = juego.getPiccolo();
		freezer = juego.getFreezer();
		cell = juego.getCell();
		majinboo = juego.getMajinBoo();

		gokuVidaMax.setText(Integer.toString(goku.getVidaMax()));
		gohanVidaMax.setText(Integer.toString(gohan.getVidaMax()));
		piccoloVidaMax.setText(Integer.toString(piccolo.getVidaMax()));
		freezerVidaMax.setText(Integer.toString(freezer.getVidaMax()));
		cellVidaMax.setText(Integer.toString(cell.getVidaMax()));
		majinbooVidaMax.setText(Integer.toString(majinboo.getVidaMax()));

		gokuVida.setText(Integer.toString(goku.getVida()));
		gohanVida.setText(Integer.toString(gohan.getVida()));
		piccoloVida.setText(Integer.toString(piccolo.getVida()));
		freezerVida.setText(Integer.toString(freezer.getVida()));
		cellVida.setText(Integer.toString(cell.getVida()));
		majinbooVida.setText(Integer.toString(majinboo.getVida()));

		gokuKi.setText(Integer.toString(goku.getKi()));
		gohanKi.setText(Integer.toString(gohan.getKi()));
		piccoloKi.setText(Integer.toString(piccolo.getKi()));
		freezerKi.setText(Integer.toString(freezer.getKi()));
		cellKi.setText(Integer.toString(cell.getKi()));
		majinbooKi.setText(Integer.toString(majinboo.getKi()));

		pGoku.getStyleClass().add("gokuNormal");
		pGohan.getStyleClass().add("gohanNormal");
		pPiccolo.getStyleClass().add("piccoloNormal");
		pFreezer.getStyleClass().add("freezerNormal");
		pCell.getStyleClass().add("cellNormal");
		pMajinboo.getStyleClass().add("majinbooNormal");

		lblJugadorZ.setText(juego.jugadorEquipoZ.getNombre());
		lblJugadorVillano.setText(juego.jugadorEquipoVillano.getNombre());

		jugadorActual = juego.comenzarJuego();
		if(jugadorActual == juego.jugadorEquipoZ){
			PanelFlecha.getStyleClass().add("leftArrow");
		}else{
			PanelFlecha.getStyleClass().add("rightArrow");
		}

	}

    @FXML
    private void handleSeleccionPersonaje(MouseEvent event){
    	if(event.getButton() == MouseButton.PRIMARY){
	    	Node elemento = (Node) event.getTarget();

	    	if(PanelPersonajeSeleccionado == null){
	    		// si se clickeo un persojae lo seleccioino
	    		if(elemento == pGoku || elemento == pGohan || elemento == pPiccolo || elemento == pFreezer || elemento == pCell || elemento == pMajinboo){
	    			elemento.getStyleClass().add("seleccionado");
	    			this.PanelPersonajeSeleccionado =  (Pane) elemento;
	    			String pj = elemento.getStyleClass().get(0);
	    			if(pj == "gokuNormal" || pj.equals("GokuEstadoKaioKen")  || pj.equals("GokuEstadoSuperSayajin") ){
	    	    		this.personajeSeleccionado = goku;
	    	    	}else if(pj.equals("gohanNormal") || pj.equals("GohanEstadoSuperSayajinFase1")|| pj.equals("GohanEstadoSuperSayajinFase2")){
	    	    		this.personajeSeleccionado = gohan;
	    	    	}else if (pj.equals("piccoloNormal") || pj.equals("PiccoloEstadoFortalecido" )|| pj.equals("PiccoloEstadoProtector")){
	    	    		this.personajeSeleccionado = piccolo;
	    	    	}else if (pj.equals("freezerNormal") || pj.equals("FreezerEstadoSegundaForma")  || pj.equals("FreezerEstadoDefinitivo")){
	    	    		this.personajeSeleccionado = freezer;
	    	    	}else if (pj.equals("cellNormal") || pj.equals("CellEstadoSemiPerfecto") || pj.equals("CellEstadoPerfecto")){
	    	    		this.personajeSeleccionado = cell;
	    	    	}else if (pj.equals("majinbooNormal") || pj.equals("MajinBooEstadoBooMalo") || pj.equals("MajinBooEstadoBooOriginal")){
	    	    		this.personajeSeleccionado = majinboo;
	    	    	}
	    		}else{
	    			this.PanelPersonajeSeleccionado = null;
	    		}
	    		if(!jugadorActual.puedeUsarPersonaje(this.personajeSeleccionado)){
	    			this.personajeSeleccionado = null;
	    			String estilo = this.PanelPersonajeSeleccionado.getStyleClass().get(0);
	        		PanelPersonajeSeleccionado.getStyleClass().clear();
	        		PanelPersonajeSeleccionado.getStyleClass().add(estilo);
	        		this.PanelPersonajeSeleccionado = null;
	        		sceneManager.show("No puede utilizar este personaje");
	    		}
	    	}else{
	    		this.ejecutarAccion(event);
	    	}
    	}

    }

    @SuppressWarnings("static-access")
	private void ejecutarAccion(MouseEvent event){
    	Node elemento = (Node) event.getTarget();

    	if(elemento == pGoku || elemento == pGohan || elemento == pPiccolo || elemento == pFreezer
				|| elemento == pCell || elemento == pMajinboo){
    		// Ataco
			IPersonaje objetivo = null;
			String pj = elemento.getStyleClass().get(0);
			if(pj == "gokuNormal" || pj.equals("GokuEstadoKaioKen")  || pj.equals("GokuEstadoSuperSayajin") ){
	    		objetivo = goku;
	    	}else if(pj.equals("gohanNormal") || pj.equals("GohanEstadoSuperSayajinFase1")|| pj.equals("GohanEstadoSuperSayajinFase2")){
	    		objetivo = gohan;
	    	}else if (pj.equals("piccoloNormal") || pj.equals("PiccoloEstadoFortalecido" )|| pj.equals("PiccoloEstadoProtector")){
	    		objetivo = piccolo;
	    	}else if (pj.equals("freezerNormal") || pj.equals("FreezerEstadoSegundaForma")  || pj.equals("FreezerEstadoDefinitivo")){
	    		objetivo = freezer;
	    	}else if (pj.equals("cellNormal") || pj.equals("CellEstadoSemiPerfecto") || pj.equals("CellEstadoPerfecto")){
	    		objetivo = cell;
	    	}else if (pj.equals("majinbooNormal") || pj.equals("MajinBooEstadoBooMalo") || pj.equals("MajinBooEstadoBooOriginal")){
	    		objetivo = majinboo;
	    	}
			try{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Elija una opcion de ataque");
				alert.setContentText("Seleccione:");

				ButtonType botonAtaqueNormal = new ButtonType("ataqueNormal");
				ButtonType botonAtaqueEspecial = new ButtonType("ataqueEspecial");
				ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

				alert.getButtonTypes().setAll(botonAtaqueNormal, botonAtaqueEspecial, buttonTypeCancel);

				Optional<ButtonType> result = alert.showAndWait();

				if(result.get() == botonAtaqueNormal){
					juego.atacarPersonaje(this.personajeSeleccionado, objetivo, jugadorActual);
				}else if(result.get() == botonAtaqueEspecial){
					juego.ataqueEspecialPersonaje(this.personajeSeleccionado, objetivo, jugadorActual);
				}else if (result.get() == buttonTypeCancel){

				}
				if(!objetivo.personajeVivo()){
					// borro el panel del personaje
					Pane panel = this.getPanelde(objetivo);
					Integer panelX = tablero.getRowIndex(panel);
					Integer panelY = tablero.getColumnIndex(panel);
					if(panelX == null){
						panelX = 0;
					}
					if(panelY == null){
						panelY = 0;
					}
					tablero.getChildren().remove(panel);
					//inserto un panel nuevo y vacio
					tablero.add(new Pane(), panelY, panelX);
				}

				this.Actualizar();
			}catch(Exception ex){
				sceneManager.show(ex.getMessage());

			}

		}else{
			//muevo
			Pane origen = this.PanelPersonajeSeleccionado;
			Pane destino = (Pane) elemento;
			Integer origenY = tablero.getColumnIndex(origen);
		    Integer origenX = tablero.getRowIndex(origen);
		    Integer destinoY = tablero.getColumnIndex(destino);
		    Integer destinoX = tablero.getRowIndex(destino);

		    if(origenX == null){
		    	origenX = 0;
		    }
		    if(origenY == null){
		    	origenY = 0;
		    }
		    if(destinoX == null){
		    	destinoX = 0;
		    }
		    if(destinoY == null){
		    	destinoY = 0;
		    }

		    try{
		    	juego.moverPersonaje(personajeSeleccionado, new Coordenada(destinoX, destinoY), jugadorActual);

		    	tablero.getChildren().remove(destino);
    			tablero.getChildren().remove(origen);

    			tablero.add(origen, destinoY, destinoX);
    			tablero.add(destino, origenY, origenX);
		    }catch(Exception ex){
		    	sceneManager.show(ex.getMessage());
		    }

		}
    }

    @FXML
    private void handleLimpiarSeleccion(MouseEvent e){
    	if(e.getButton() == MouseButton.SECONDARY){
    		// limpio la seleccion del personaje anterior
    		String estilo = this.PanelPersonajeSeleccionado.getStyleClass().get(0);
    		PanelPersonajeSeleccionado.getStyleClass().clear();
    		PanelPersonajeSeleccionado.getStyleClass().add(estilo);
        	this.PanelPersonajeSeleccionado = null;
    	}

    }

    @FXML
    private void handleTerminarTurno(){
    	try{
    		jugadorActual = juego.terminarTurno();
    		this.personajeSeleccionado = null;
    		if(this.PanelPersonajeSeleccionado != null){
    			String estilo = this.PanelPersonajeSeleccionado.getStyleClass().get(0);
        		PanelPersonajeSeleccionado.getStyleClass().clear();
        		PanelPersonajeSeleccionado.getStyleClass().add(estilo);
            	this.PanelPersonajeSeleccionado = null;

    		}
    		if(this.PanelFlecha.getStyleClass().get(0) == "rightArrow"){
        		this.PanelFlecha.getStyleClass().clear();
        		this.PanelFlecha.getStyleClass().add("leftArrow");
        	}else{
        		this.PanelFlecha.getStyleClass().clear();
        		this.PanelFlecha.getStyleClass().add("rightArrow");
        	}
    	}catch(Exception ex){
    		sceneManager.show(ex.getMessage());
    	}
    	this.Actualizar();
    }

    @FXML
    private void handleTransformar(){
    	try{
	    	if(this.personajeSeleccionado == gohan || this.personajeSeleccionado == piccolo){
	    		this.personajeSeleccionado.transformar(juego.jugadorEquipoZ.getEquipo());
	    		String estilo = this.personajeSeleccionado.getNombreEstado();
	    		PanelPersonajeSeleccionado.getStyleClass().clear();
	    		PanelPersonajeSeleccionado.getStyleClass().addAll(estilo,"seleccionado");
	    		this.Actualizar();
	    	}else{
	    		this.personajeSeleccionado.transformar();
	    		String estilo = this.personajeSeleccionado.getNombreEstado();
	    		PanelPersonajeSeleccionado.getStyleClass().clear();
	    		PanelPersonajeSeleccionado.getStyleClass().addAll(estilo, "seleccionado");

	    		this.Actualizar();
	    	}

    	}catch(Exception ex){
    		sceneManager.show(ex.getMessage());
    	}

    }

    private void Actualizar(){
		gokuKi.setText(Integer.toString(goku.getKi()));
		gohanKi.setText(Integer.toString(gohan.getKi()));
		piccoloKi.setText(Integer.toString(piccolo.getKi()));
		freezerKi.setText(Integer.toString(freezer.getKi()));
		cellKi.setText(Integer.toString(cell.getKi()));
		majinbooKi.setText(Integer.toString(majinboo.getKi()));

		gokuVida.setText(Integer.toString(goku.getVida()));
		gohanVida.setText(Integer.toString(gohan.getVida()));
		piccoloVida.setText(Integer.toString(piccolo.getVida()));
		freezerVida.setText(Integer.toString(freezer.getVida()));
		cellVida.setText(Integer.toString(cell.getVida()));
		majinbooVida.setText(Integer.toString(majinboo.getVida()));
    }

    private Pane getPanelde(IPersonaje personaje){
    	if(personaje == goku){
    		return pGoku;
    	}else if(personaje == gohan){
    		return pGohan;
    	}else if(personaje == piccolo){
    		return pPiccolo;
    	}else if(personaje == cell){
    		return pCell;
    	}else if(personaje == freezer){
    		return pFreezer;
    	}else{
    		return pMajinboo;
    	}
    }

}