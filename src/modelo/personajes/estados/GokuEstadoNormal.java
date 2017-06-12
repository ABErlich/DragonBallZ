package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GokuEstadoNormal extends Estado {

	public GokuEstadoNormal(Coordenada pUbicacion){
		super(pUbicacion);
		vida = 500;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
	}
	
	@Override
	public void Atacar(PersonajeEquipoZ pPersonaje){
		throw new AtaqueMismoEquipoException();
	}

}
