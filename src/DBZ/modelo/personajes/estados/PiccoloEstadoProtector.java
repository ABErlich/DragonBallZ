package DBZ.modelo.personajes.estados;

import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.UltimoEstadoException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;

public class PiccoloEstadoProtector extends PiccoloEstado {

    public PiccoloEstadoProtector(){

		poder = 60;
		distanciaAtaque = 6;
		velocidadMov = 4;

    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public PiccoloEstado transformar(IJugadorEquipoZ equipo) {
		throw new UltimoEstadoException();
	}

}
