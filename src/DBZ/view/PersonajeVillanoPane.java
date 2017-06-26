package DBZ.view;

import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Pane;

public class PersonajeVillanoPane extends Pane {

	private ObjectProperty<IPersonajeEquipoVillano> person = new SimpleObjectProperty<IPersonajeEquipoVillano>( this, "personajeVillano" );



}
