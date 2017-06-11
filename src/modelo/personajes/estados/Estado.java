package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IEquipoVillano;
import modelo.personajes.IEquipoZ;
import modelo.excepciones.MovimientoFueraRangoException;

public abstract class Estado {

	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	
	public String obtenerEstado(){
		return "Sin estado";
	}
	public void Atacar(IEquipoZ pPersonaje){}
	public void Atacar(IEquipoVillano pPersonaje){}
	public void Mover(Coordenada pDestino, Coordenada pOrigen){
		if(this.calcularDistancia(pDestino, pOrigen) <= this.velocidadMov){
			// Si se puede mover esa distancia, lo muevo
			pOrigen.setCoordenadas(pDestino);
		}else{
			throw new MovimientoFueraRangoException();
		}
	}

	private int calcularDistancia(Coordenada destino, Coordenada origen){
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
