package modelo.personajes;

import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.tablero.IUbicable;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.estados.CellEstado;
import modelo.personajes.estados.CellEstadoNormal;
import modelo.excepciones.AtaqueMismoEquipoException;

public class Cell implements IPersonajeEquipoVillano, IUbicable{
	
	private CellEstado estado;

    public Cell (Coordenada coordenada){
    	this.estado = new CellEstadoNormal();
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

    public void absorber(IPersonajeEquipoZ personaje){
    	this.estado.absorber(personaje);
    }
    
    public void absorber(IPersonajeEquipoVillano personaje){
        throw new AtaqueMismoEquipoException();
    }
    
    public void transformar(){
    	CellEstado nuevoEstado = this.estado.transformar();
        this.estado = nuevoEstado;
    }

	public void terminoTurno() {
		this.estado.terminoTurno();
	}

	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}
	
	public boolean estaVivo(){
		return this.estado.estaVivo();
	}
	

}

