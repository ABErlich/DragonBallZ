package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GokuEstadoSuperSayajin extends Estado {

	public GokuEstadoSuperSayajin(Coordenada pUbicacion){
		super(pUbicacion);
		ki = ki - 50;
        poder = 60;
        distanciaAtaque  = 4;
        velocidadMov = 5;
	}

	public void Atacar(IPersonajeEquipoZ pPersonaje){
		throw new AtaqueMismoEquipoException();
	}

}
