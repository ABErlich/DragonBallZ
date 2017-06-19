package modelo.personajes;

import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.personajes.estados.Estado;
import modelo.personajes.estados.EstadoConvertidoEnChocolate;
import modelo.personajes.estados.GohanEstado;
import modelo.personajes.estados.GohanEstadoNormal;
import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.tablero.IUbicable;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.PersonajeYaEsChocolateException;

public class Gohan implements IPersonajeEquipoZ, IUbicable{

	Estado estado;
	boolean convertidoEnChocolate;
	
    public Gohan (Coordenada coordeanda){
    	this.estado = new GohanEstadoNormal();
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

	public void recibirAtaque(int poderBase, int danio){
		this.estado.recibirAtaque(poderBase ,danio);
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
    
    public void masenko(IPersonajeEquipoZ personaje){
    	throw new AtaqueMismoEquipoException();
    }
    
    public void masenko(IPersonajeEquipoVillano personaje){
    	((GohanEstado) this.estado).masenko(personaje);
    }
    
    public void transformar(IJugadorEquipoZ equipo){
    	GohanEstado nuevoEstado = ((GohanEstado) this.estado).transformar(equipo);
    	estado = nuevoEstado;
    }

	public void convertirEnChocolate() {
		if(convertidoEnChocolate){
			throw new PersonajeYaEsChocolateException();
		}
		this.estado = (Estado) (new EstadoConvertidoEnChocolate(estado));
	}

	public void terminoTurno() {
		Estado estado = this.estado.terminoTurno();
		if(estado != null){
			this.estado = estado;
			this.convertidoEnChocolate = false;
		}
	}

	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}

	@Override
	public boolean estaVivo() {
		return this.estado.estaVivo();
	}

}

