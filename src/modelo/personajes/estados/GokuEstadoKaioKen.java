package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GokuEstadoKaioKen extends Estado {

	public GokuEstadoKaioKen(Coordenada pUbicacion){
		super(pUbicacion);
		ki = ki - 20;
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
	}

	@Override
	public void Atacar(IPersonajeEquipoZ pPersonaje) {
		throw new AtaqueMismoEquipoException();
	}


}
