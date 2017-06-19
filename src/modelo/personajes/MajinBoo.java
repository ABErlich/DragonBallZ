package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.MajinBooEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.estados.MajinBooEstado;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class MajinBoo extends Personaje implements IPersonajeEquipoVillano {

	MajinBooEstado estado;
	
    public MajinBoo (Coordenada coordenada){
    	this.estado = new MajinBooEstadoNormal();
    	this.estado.setUbicacion(coordenada);
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

    public void convierteEnChocolate(IPersonajeEquipoZ personaje){
        this.estado.convierteEnChocolate(personaje);
    }

    public void convierteEnChocolate(IPersonajeEquipoVillano personaje){
        throw new AtaqueMismoEquipoException();
    }
    
    public void transformar(){
    	MajinBooEstado nuevoEstado = this.estado.transformar();
        this.estado = nuevoEstado;
    }

	public void terminoTurno() {
		this.estado.terminoTurno();
	}
    
}

