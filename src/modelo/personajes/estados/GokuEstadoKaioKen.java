package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class GokuEstadoKaioKen extends Estado {

	public GokuEstadoKaioKen(){
		ki = ki - 20;
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
	}

	@Override
	public void Atacar(IPersonajeEquipoZ pPersonaje) {
		// ACA LANZO EXCEPCION YA QUE GOKU NO PUEDE ATACAR A ALGUIEN DE SU EQUIPO
	}

	public void Atacar(IPersonajeEquipoVillano pPersonaje){

	}

	@Override
	public String obtenerEstado() {
		return "KaioKen";
	}


}
