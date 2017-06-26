package DBZ.modelo.personajes;

import DBZ.modelo.personajes.estados.PiccoloEstadoNormal;
import DBZ.modelo.personajes.estados.Estado;
import DBZ.modelo.personajes.estados.EstadoConvertidoEnChocolate;
import DBZ.modelo.personajes.estados.PiccoloEstado;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.tablero.Consumible;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.IUbicable;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.PersonajeYaEsChocolateException;

public class Piccolo implements IPersonajeEquipoZ, IUbicable {

	Estado estado;
	boolean convertidoEnChocolate;

    public Piccolo (Coordenada coordenada){
    	this.estado = new PiccoloEstadoNormal();
    	this.estado.setUbicacion(coordenada);
    }

    @Override
	public void atacar(IPersonaje atacado) {
    	this.estado.atacar(atacado);
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

    public void transformar(IJugadorEquipoZ equipo) {
    	PiccoloEstado nuevoEstado = ((PiccoloEstado) this.estado).transformar(equipo);
    	estado = nuevoEstado;
	}

    public void ataqueEspecial(IPersonajeEquipoZ atacado) {
    	throw new AtaqueMismoEquipoException();

	}

    public void ataqueEspecial(IPersonajeEquipoVillano atacado){
    	((PiccoloEstado) this.estado).makankosappo(atacado);
    }

	public void terminoTurno() {
		Estado estado = this.estado.terminoTurno();
		if(estado != null){
			this.estado = estado;
			this.convertidoEnChocolate = false;
		}
	}

	public void convertirEnChocolate() {
		if(convertidoEnChocolate){
			throw new PersonajeYaEsChocolateException();
		}
		this.estado = (Estado) (new EstadoConvertidoEnChocolate(estado));
	}

	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}

	@Override
	public boolean estaVivo() {
		return this.estado.estaVivo();
	}

	public int getVidaMax() {
		return this.estado.getVidaMax();
	}

	public int getKi() {
		return this.estado.getKi();
	}



}

