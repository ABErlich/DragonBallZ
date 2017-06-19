package modelo.personajes.estados;

import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.MovimientoFueraRangoException;
import modelo.excepciones.AtaqueFueraDeRangoException;

public abstract class Estado {

	protected int vidaMaxima;
	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	protected Coordenada ubicacion;
	
	public void atacar(IPersonajeEquipoZ personaje){
		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			personaje.recibirAtaque(poder); 
		}
	}
	
	public void atacar(IPersonajeEquipoVillano personaje){
		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			personaje.recibirAtaque(poder); 
		}
	}
	
	public void mover(Coordenada destino){
		if(ubicacion.calcularDistancia(destino) <= velocidadMov){
			ubicacion = destino;
		}else{
			throw new MovimientoFueraRangoException();
		}
	}

	public void recibirAtaque(int danio) {
		vida = vida - danio;
	}

	public void setUbicacion(Coordenada coordeanda) {
		ubicacion = coordeanda;
	}
	public Coordenada getUbicacion(){
		return this.ubicacion;
	}

	public boolean vidaMenor30porc() {
		if(vida < 0.3*vidaMaxima){
			return true;
		}else{
			return false;
		}
	}

	public int getVida() {
		return vida;
	}
	
	public void terminoTurno(){
		ki = ki + 5;
	}

}
