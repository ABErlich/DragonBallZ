package modelo.personajes.estados;

import modelo.personajes.IEquipoVillano;
import modelo.personajes.IEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class GokuEstadoKaioKen implements IEstado {

	@Override
	public void Atacar(IEquipoZ pPersonaje) {
		// ACA LANZO EXCEPCION YA QUE GOKU NO PUEDE ATACAR A ALGUIEN DE SU EQUIPO
	}

	public void Atacar(IEquipoVillano pPersonaje){

	}

	@Override
	public void Mover(Coordenada pCoordenada) {

	}

	@Override
	public String obtenerEstado() {
		return "KaioKen";
	}


}
