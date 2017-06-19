package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.Estado;
import modelo.personajes.estados.EstadoConvertidoEnChocolate;
import modelo.personajes.estados.GokuEstado;
import modelo.personajes.estados.GokuEstadoNormal;
import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Goku extends Personaje implements IPersonajeEquipoZ {
	
	Estado estado;
	
    public Goku (Coordenada coordeanda){
    	this.estado = new GokuEstadoNormal();
    	estado.setUbicacion(coordeanda);
    }
    
    public void atacar(IPersonajeEquipoZ personaje){
		this.estado.atacar(personaje);
	}

	public void atacar(IPersonajeEquipoVillano personaje){
		this.estado.atacar(personaje);
	}

	public void mover(Coordenada destino){
		this.estado.mover(destino);
	}

	public void recibirAtaque(int danio){
		this.estado.recibirAtaque(danio);
	}

	public void ubicar(Coordenada coordenada){
		this.estado.setUbicacion(coordenada);
	}

	public Coordenada obtenerUbicacion(){
		return this.estado.getUbicacion();
	}
	
	public int getVida() {
		return this.estado.getVida();
	}
	
	public boolean vidaMenor30porc(){
		return this.estado.vidaMenor30porc();
	}
    
    public void kamehameha(IPersonajeEquipoZ personaje){
    	throw new AtaqueMismoEquipoException();
    }
    
    public void kamehameha(IPersonajeEquipoVillano personaje){
    	((GokuEstado) this.estado).kamehameha(personaje);
    	
    }
    
	public void transformar(){
		GokuEstado nuevoEstado = ((GokuEstado) this.estado).transformar();
    	estado = nuevoEstado;
	}

	@Override
	public void convertirEnChocolate() {
		this.estado = (Estado) (new EstadoConvertidoEnChocolate(estado));
		
	}

	@Override
	public void terminoTurno() {
		this.estado.terminoTurno();
		
	}

	@Override
	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}
}

