package DBZ.modelo.personajes;

import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.personajes.estados.Estado;
import DBZ.modelo.personajes.estados.EstadoConvertidoEnChocolate;
import DBZ.modelo.personajes.estados.GohanEstado;
import DBZ.modelo.personajes.estados.GohanEstadoNormal;
import DBZ.modelo.tablero.Consumible;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.IUbicable;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeRealizarAtaqueException;
import DBZ.modelo.excepciones.PersonajeYaEsChocolateException;

public class Gohan implements IPersonajeEquipoZ, IUbicable{

	Estado estado;
	boolean convertidoEnChocolate;

    public Gohan (Coordenada coordeanda){
    	this.estado = new GohanEstadoNormal();
    	estado.setUbicacion(coordeanda);
    }

    @Override
	public void atacar(IPersonaje atacado) {
    	try{
    		this.estado.atacar((IPersonajeEquipoVillano) atacado);
    	}catch(AtaqueFueraDeRangoException ex){
    		throw new AtaqueFueraDeRangoException();
    	}catch(Exception ex){
    		throw new AtaqueMismoEquipoException();
    	}
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

    public void ataqueEspecial(IPersonajeEquipoZ atacado) {
    	throw new AtaqueMismoEquipoException();

	}

    public void ataqueEspecial(IPersonajeEquipoVillano atacado){
    	((GohanEstado) this.estado).masenko(atacado);
    }
    @Override
	public void ataqueEspecial(IPersonaje atacado) {
    	try{
    		((GohanEstado) this.estado).masenko((IPersonajeEquipoVillano) atacado);
    	}catch(AtaqueFueraDeRangoException ex){
    		throw new AtaqueFueraDeRangoException();
    	}catch(NoPuedeRealizarAtaqueException ex){
    		throw new NoPuedeRealizarAtaqueException();
    	}
    	catch(Exception ex){
    		throw new AtaqueMismoEquipoException();
    	}
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


	public int getVidaMax() {
		return this.estado.getVidaMax();
	}

	public int getKi() {
		return this.estado.getKi();
	}

	@Override
	public void transformar() {

	}

	@Override
	public String getNombreEstado() {
		return this.estado.getClass().getSimpleName();
	}

	public boolean personajeVivo(){
		return this.estado.personajeVivo();
	}

}

