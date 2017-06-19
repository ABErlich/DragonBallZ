package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.FreezerEstado;
import modelo.personajes.estados.FreezerEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Freezer extends Personaje implements IPersonajeEquipoVillano {

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
		//this.ubicacion = pDestino;
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

	@Override
	public void terminoTurno() {
		this.estado.terminoTurno();
	}

    
}

