package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.UltimoEstadoException;
import modelo.juego.interfaces.IJugadorEquipoZ;

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
