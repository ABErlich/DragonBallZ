package DBZ.modelo.personajes;

import DBZ.modelo.tablero.Consumible;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.IUbicable;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.personajes.estados.CellEstado;
import DBZ.modelo.personajes.estados.CellEstadoNormal;
import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeRealizarAtaqueException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;

public class Cell implements IPersonajeEquipoVillano, IUbicable{

	private CellEstado estado;

    public Cell (Coordenada coordenada){
    	this.estado = new CellEstadoNormal();
    	estado.setUbicacion(coordenada);
    }

    @Override
	public void atacar(IPersonaje atacado) {
    	try{
    		this.estado.atacar((IPersonajeEquipoZ) atacado);
    	}catch(AtaqueFueraDeRangoException ex){
    		throw new AtaqueFueraDeRangoException();
    	}
    	catch(Exception ex){
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


	public void ataqueEspecial(IPersonajeEquipoZ atacado) {
		this.estado.absorber(atacado);
	}

    public void ataqueEspecial(IPersonajeEquipoVillano personaje){
        throw new AtaqueMismoEquipoException();
    }
    @Override
	public void ataqueEspecial(IPersonaje atacado) {
    	try{
    		this.estado.absorber((IPersonajeEquipoZ) atacado);
    	}catch(AtaqueFueraDeRangoException ex){
    		throw new AtaqueFueraDeRangoException();
    	}catch(NoPuedeRealizarAtaqueException ex){
    		throw new NoPuedeRealizarAtaqueException();
    	}
    	catch(Exception ex){
    		throw new AtaqueMismoEquipoException();
    	}

	}
	public int getVidaMax() {
		return this.estado.getVidaMax();
	}

	public int getKi() {
		return this.estado.getKi();
	}

	@Override
	public void transformar(IJugadorEquipoZ equipo) {

	}

	@Override
	public String getNombreEstado() {
		return this.estado.getClass().getSimpleName();
	}

	public boolean personajeVivo(){
		return this.estado.personajeVivo();
	}




}

