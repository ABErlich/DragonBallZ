package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoNormal extends Estado {

	public CellEstadoNormal(Coordenada pUbicacion){
		super(pUbicacion);
		vida = 500;
        poder = 20;
        distanciaAtaque = 3;
        velocidadMov = 2;
        ki = 0;
	}
	
	@Override
	public void Atacar(PersonajeEquipoVillano pPersonaje){
		throw new AtaqueMismoEquipoException();
	}


}
