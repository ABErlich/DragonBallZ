package modelo.personajes.estados;

import modelo.personajes.IEquipoVillano;
import modelo.personajes.IEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class GokuEstadoNormal implements IEstado {
	
	public void Atacar(IEquipoVillano pPersonaje){

	}

	public void Atacar(IEquipoZ pPersonaje){
		// lanzo excepcion
	}

	public void Mover(Coordenada pCoordenada){

	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public String obtenerEstado() {
		return "Normal";
	}
}
