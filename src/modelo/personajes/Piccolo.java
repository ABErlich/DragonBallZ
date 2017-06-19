package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.PiccoloEstadoNormal;
import modelo.personajes.estados.Estado;
import modelo.personajes.estados.PiccoloEstado;
import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;

public class Piccolo extends Personaje implements IPersonajeEquipoZ {

	Estado estado;
	
    public Piccolo (Coordenada coordenada){
    	this.estado = new PiccoloEstadoNormal();
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

    public void transformar(IJugadorEquipoZ equipo) {
    	PiccoloEstado nuevoEstado = ((PiccoloEstado) this.estado).transformar(equipo);
    	estado = nuevoEstado;
	}
    
    public void makankosappo(IPersonajeEquipoZ personaje){
    	throw new AtaqueMismoEquipoException();
    }
    
    public void makankosappo(IPersonajeEquipoVillano personaje){
    	((PiccoloEstado) this.estado).makankosappo(personaje);

    }

	@Override
	public void terminoTurno() {
		this.estado.terminoTurno();
	}

	@Override
	public void convertirEnChocolate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}

}

