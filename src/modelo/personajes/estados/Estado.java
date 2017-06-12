package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.IPersonajeEquipoZ;
import modelo.excepciones.MovimientoFueraRangoException;
import modelo.excepciones.AtaqueFueraDeRangoException;

public abstract class Estado {

	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	protected Coordenada ubicacion;
	
	public Estado(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
	}

	public String obtenerEstado(){
		return "Sin estado";
	}

	public void Atacar(PersonajeEquipoZ pPersonaje){
		if(this.calcularDistancia(pPersonaje.obtenerUbicacion(), this.ubicacion) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			pPersonaje.setVida(pPersonaje.getVida() - this.poder); 
		}
	}
	public void Atacar(PersonajeEquipoVillano pPersonaje){
		if(this.calcularDistancia(pPersonaje.obtenerUbicacion(), this.ubicacion) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			pPersonaje.setVida(pPersonaje.getVida() - this.poder); 
		}
	}
	public void Mover(Coordenada pDestino){
		if(this.calcularDistancia(pDestino, ubicacion) <= this.velocidadMov){
			// Si se puede mover esa distancia, lo muevo
			this.ubicacion.setCoordenadas(pDestino);
		}else{
			throw new MovimientoFueraRangoException();
		}
	}

	protected int calcularDistancia(Coordenada destino, Coordenada origen){
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

	public int getVida(){
		return this.vida;
	}

	public void setVida(int pVida){
		this.vida = pVida;
	}
}
