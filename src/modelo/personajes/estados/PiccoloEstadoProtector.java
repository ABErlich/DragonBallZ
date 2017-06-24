package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.UltimoEstadoException;
import modelo.juego.interfaces.IJugadorEquipoZ;

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
