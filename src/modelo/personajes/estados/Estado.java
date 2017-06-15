package modelo.personajes.estados;

import modelo.personajes.Stats;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.MovimientoFueraRangoException;
import modelo.excepciones.AtaqueFueraDeRangoException;

public abstract class Estado {

	public Estado(){

	}

	public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats){
		if(this.calcularDistancia(pPersonaje.obtenerUbicacion(), stats.getUbicacion()) > stats.getDistanciaAtaque()){
			throw new AtaqueFueraDeRangoException();
		}else{
			pPersonaje.setVida(pPersonaje.getVida() - stats.getPoder()); 
		}
	}
	
	public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats){
		if(this.calcularDistancia(pPersonaje.obtenerUbicacion(), stats.getUbicacion()) > stats.getDistanciaAtaque()){
			throw new AtaqueFueraDeRangoException();
		}else{
			pPersonaje.setVida(pPersonaje.getVida() - stats.getPoder()); 
		}
	}
	public void Mover(Coordenada pDestino, Stats stats){
		if(this.calcularDistancia(pDestino, stats.getUbicacion()) <= stats.getVelocidadMov()){
			// Si se puede mover esa distancia, lo muevo
			stats.setUbicacion(pDestino);
		}else{
			throw new MovimientoFueraRangoException();
		}
	}

	public int calcularDistancia(Coordenada destino, Coordenada origen){
		int origenX = origen.getCoordX();
		int origenY = origen.getCoordY();
		int destinoX = destino.getCoordX();
		int destinoY = destino.getCoordY();

		int distanciaX = Math.abs(origenX - destinoX);
		int distanciaY = Math.abs(origenY - destinoY);

		int distanciaTotal = 0;
		if( distanciaX == distanciaY){
			distanciaTotal = distanciaX;
		}else{
			distanciaTotal = distanciaX + distanciaY;
		}
		
		return distanciaTotal;
	}

}
