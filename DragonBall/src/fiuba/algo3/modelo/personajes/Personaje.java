package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.excepciones.CeldaNoExisteException;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import fiuba.algo3.modelo.personajes.estados.IEstado;
import fiuba.algo3.modelo.tablero.IUbicable;
import fiuba.algo3.modelo.tablero.Coordenada;
import fiuba.algo3.modelo.tablero.Tablero;

public abstract class Personaje implements IUbicable, IEstado {

	public Personaje(Tablero ptablero){
		this.tablero = ptablero;
	}
	
	public Personaje(){
	}
	
	private Tablero tablero;
	private String Nombre;
	
    protected IEstado estado;
	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	
	public void Atacar(Personaje pPersonaje){
		pPersonaje.RecibirAtaque(poder);
	}

	public void Mover(Coordenada pCoordenada) throws CeldaNoExisteException, CeldaOcupadaException{
		this.tablero.Ubicar(this, pCoordenada);
	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public void Ubicar(Coordenada pCoordenada) throws CeldaNoExisteException, CeldaOcupadaException {
		tablero.Ubicar(this, pCoordenada);
	}
	
	public Coordenada obtenerUbicacion(){
		return tablero.obtenerUbicacion(this);
	}
	
	public String obtenerEstado(){
		return this.estado.obtenerEstado();
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
