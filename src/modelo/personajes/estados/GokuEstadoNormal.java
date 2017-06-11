package modelo.personajes.estados;

import modelo.personajes.IEquipoVillano;
import modelo.personajes.IEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class GokuEstadoNormal extends Estado {

	public GokuEstadoNormal(){
		vida = 500;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
	}

	public void Atacar(IEquipoVillano pPersonaje){

	}

	public void Atacar(IEquipoZ pPersonaje){
		// lanzo excepcion
	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public String obtenerEstado() {
		return "Normal";
	}
}
