package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class GokuEstadoSuperSayajin extends Estado {

	public GokuEstadoSuperSayajin(){
		ki = ki - 50;
        poder = 60;
        distanciaAtaque  = 4;
        velocidadMov = 5;
	}

	public void Atacar(IPersonajeEquipoVillano pPersonaje){

	}

	public void Atacar(IPersonajeEquipoZ pPersonaje){
		// lanzo excepcion
	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public String obtenerEstado() {
		return "Super Sayajin";
	}
}
