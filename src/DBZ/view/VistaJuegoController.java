package DBZ.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import DBZ.SceneManager;
import DBZ.modelo.juego.Juego;
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
	@FXML
	Label lblJugadorZ;
	@FXML
	Label lblJugadorVillano;

	String nombrePersonajeSeleccionado;
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

    public VistaJuegoController(Juego juego) {
    	this.juego = juego;
    }

    @FXML
    private void initialize() {

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

		juego.comenzarJuego();
	}

    @FXML
    private void handleSeleccionPersonaje(MouseEvent event){
    	Node elemento = (Node) event.getTarget();

    	if(PanelPersonajeSeleccionado == null){
    		// si se clickeo un persojae lo seleccioino
    		if(elemento == pGoku || elemento == pGohan || elemento == pPiccolo || elemento == pFreezer || elemento == pCell || elemento == pMajinboo){
    			elemento.getStyleClass().add("seleccionado");
    			this.PanelPersonajeSeleccionado = (Pane) elemento;
    			String pj = elemento.getStyleClass().get(0);
    			if(pj == "gokuNormal"){
    	    		this.personajeSeleccionado = goku;
    	    	}else if(pj == "gohanNormal"){
    	    		this.personajeSeleccionado = gohan;
    	    	}else if (pj == "piccoloNormal"){
    	    		this.personajeSeleccionado = piccolo;
    	    	}else if (pj == "freezerNormal"){
    	    		this.personajeSeleccionado = freezer;
    	    	}else if (pj == "cellNormal"){
    	    		this.personajeSeleccionado = cell;
    	    	}else if (pj == "majinbooNormal"){
    	    		this.personajeSeleccionado = majinboo;
    	    	}
    		}else{
    			this.PanelPersonajeSeleccionado = null;
    		}
    	}else{
    		this.ejecutarAccion(event);
    	}

    }

    private void ejecutarAccion(MouseEvent event){
    	Node elemento = (Node) event.getTarget();

    	if(elemento == pGoku || elemento == pGohan || elemento == pPiccolo || elemento == pFreezer
				|| elemento == pCell || elemento == pMajinboo){
    		// Ataco
			IPersonaje objetivo = null;
			String pj = elemento.getStyleClass().get(0);
			if(pj == "gokuNormal"){
				objetivo = (Goku) goku;
	    	}else if(pj == "gohanNormal"){
	    		objetivo = (Gohan) gohan;
	    	}else if (pj == "piccoloNormal"){
	    		objetivo = (Piccolo) piccolo;
	    	}else if (pj == "freezerNormal"){
	    		objetivo = (Freezer) freezer;
	    	}else if (pj == "cellNormal"){
	    		objetivo = (Cell) cell;
	    	}else if (pj == "majinbooNormal"){
	    		objetivo = (MajinBoo) majinboo;
	    	}
			try{
				juego.atacarPersonaje(this.personajeSeleccionado, objetivo);
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
		    	juego.moverPersonaje(personajeSeleccionado, new Coordenada(destinoX, destinoY));

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
    private void handleLimpiarSeleccion(){
    	// limpio la seleccion del personaje anterior
		String estilo = this.PanelPersonajeSeleccionado.getStyleClass().get(0);
		PanelPersonajeSeleccionado.getStyleClass().clear();
		PanelPersonajeSeleccionado.getStyleClass().add(estilo);
    	this.PanelPersonajeSeleccionado = null;
    }

    @FXML
    private void handleTerminarTurno(){
    	try{
    		juego.terminarTurno();
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
	    	}else{
	    		this.personajeSeleccionado.transformar();
	    	}
	    	sceneManager.show("El personaje se transformo correctamente");
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
    }


}