package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.estados.FreezerEstado;
import modelo.personajes.estados.FreezerEstadoNormal;
import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.tablero.IUbicable;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Freezer implements IPersonajeEquipoVillano, IUbicable {

	private FreezerEstado estado;
	
    public Freezer (Coordenada coordenada){
    	this.estado = new FreezerEstadoNormal();
    	estado.setUbicacion(coordenada);
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

	public void recibirAtaque(int poderBase, int danio){
		this.estado.recibirAtaque(poderBase, danio);
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

    public void rayoMortal(IPersonajeEquipoZ personaje){
    	this.estado.rayoMortal(personaje);
    }
    
    public void rayoMortal(IPersonajeEquipoVillano personaje){
        throw new AtaqueMismoEquipoException();
    }

    public void transformar(){
    	FreezerEstado nuevoEstado = this.estado.transformar();
        this.estado = nuevoEstado;
    }

	public void terminoTurno() {
		this.estado.terminoTurno();
	}

	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
		
	}

	@Override
	public boolean estaVivo() {
		return this.estado.estaVivo();
	}

    
}

