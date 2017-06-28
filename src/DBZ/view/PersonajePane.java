package DBZ.view;

import DBZ.modelo.personajes.interfaces.IPersonaje;
import javafx.scene.layout.Pane;

public class PersonajePane extends Pane {

	IPersonaje personaje;

	IPersonaje getPersonaje(){
		return this.personaje;
	}

}
