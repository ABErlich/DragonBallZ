package DBZ.modelo.personajes.estados;

import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.UltimoEstadoException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;

public class GohanEstadoSuperSayajinFase2 extends GohanEstado {

    public GohanEstadoSuperSayajinFase2(){

		poder = 100;
		distanciaAtaque = 2;
		velocidadMov = 3;

    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public GohanEstado transformar(IJugadorEquipoZ equipo) {
		throw new UltimoEstadoException();
	}

}
