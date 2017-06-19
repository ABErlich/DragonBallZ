package modelo.personajes.estados;

import modelo.tablero.Consumible;
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
	protected double bonificacionEsfera;
	protected int turnosEsferaActiva;
	protected int turnosNubeActiva;
	
	public void atacar(IPersonajeEquipoZ personaje){
		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			personaje.recibirAtaque(poder, calcularDanio()); 
		}
	}
	
	public void atacar(IPersonajeEquipoVillano personaje){
		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			personaje.recibirAtaque(poder, calcularDanio()); 
		}
	}
	
	public void mover(Coordenada destino){
		if(ubicacion.calcularDistancia(destino) <= calcularVelocidadMov()){
			ubicacion = destino;
		}else{
			throw new MovimientoFueraRangoException();
		}
	}

	public void recibirAtaque(int poderbase, int danio) {
		// Si el personaje es atacado por uno de menor poder de pelea, el danio se reduce un 20%
		if(poderbase >= this.poder){
			vida = vida - danio;
		}else{
			vida = vida - (int)(danio*0.8);
		}
		
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
		turnosEsferaActiva--;
		turnosNubeActiva--;
	}

	public void consumir(Consumible consumible) {
		this.consumir(consumible);
	}

	public void sumarVida(int vidaExtra) {
		this.vida = vida + vidaExtra;
	}
	
	protected int calcularDanio(){
		if(turnosEsferaActiva > 0){
			return (int)(poder*bonificacionEsfera);
		}else{
			return poder;
		}
	}
	
	protected int calcularVelocidadMov() {
		if(turnosNubeActiva > 0){
			return this.velocidadMov*2;
		}else{
			return this.velocidadMov;
		}
	}

	public void setBonificacionEsfera(double bonificacionAtaque, int turnosBonificacion) {
		this.turnosEsferaActiva = turnosBonificacion;
		this.bonificacionEsfera = bonificacionAtaque;
	}
	public void setBonificacionNube(int turnosBonificacion) {
		this.turnosNubeActiva = turnosBonificacion;
	}

}
