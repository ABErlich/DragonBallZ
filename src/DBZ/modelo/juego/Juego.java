package DBZ.modelo.juego;

import DBZ.modelo.excepciones.JugadorYaExisteException;
import DBZ.modelo.excepciones.JugadoresNoSeleccionadosException;
import DBZ.modelo.excepciones.NoPuedeUsarEsePersonajeException;
import DBZ.modelo.excepciones.YaRealizoAtaqueException;
import DBZ.modelo.excepciones.YaRealizoMovimientoException;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Freezer;
import DBZ.modelo.personajes.Gohan;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.personajes.MajinBoo;
import DBZ.modelo.personajes.Piccolo;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.Tablero;

public class Juego {

	public Juego(int tamanioTablero){
		this.tablero = new Tablero(tamanioTablero);
	}

	public Jugador jugadorEquipoZ;
	public Jugador jugadorEquipoVillano;
	private Jugador jugadorActual;
	private Tablero tablero;
	private boolean realizoMovimiento;
	private boolean realizoAtaque;

	// INICIALIZADORES //////////////

	public void agregarJugadorZ(Jugador jugador){
		if(jugadorEquipoZ == null){
			jugadorEquipoZ = jugador;
			jugadorEquipoZ.asignarEquipoZ(this.tablero);
		}else{
			throw new JugadorYaExisteException();
		}
	}

	public void agregarJugadorVillano(Jugador jugador){
		if(jugadorEquipoVillano == null){
			jugadorEquipoVillano = jugador;
			jugadorEquipoVillano.asignarEquipoVillano(this.tablero);
		}else{
			throw new JugadorYaExisteException();
		}
	}

	//////////////////////////////////


	/////////MECANICA DEL JUEGO ////////////////

	public Jugador comenzarJuego(){
		if(jugadorEquipoZ == null || jugadorEquipoVillano == null){
			throw new JugadoresNoSeleccionadosException();
		}

		jugadorEquipoZ.agregarRival(jugadorEquipoVillano);
		jugadorEquipoVillano.agregarRival(jugadorEquipoZ);

		double selector = Math.random();
		if(selector > 0.5){
			jugadorActual = jugadorEquipoZ;
		}else{
			jugadorActual = jugadorEquipoVillano;
		}

		this.comenzarTurno();
		return jugadorActual;
	}
	private void comenzarTurno() {
		realizoMovimiento = false;
		realizoAtaque = false;
	}
	public void moverPersonaje(IPersonaje personaje, Coordenada coordenada, Jugador jugador){
		if(jugador.puedeUsarPersonaje(personaje)){
			if(!realizoMovimiento){
				tablero.moverPersonaje(personaje, coordenada);
				realizoMovimiento = true;
			}else{
				throw new YaRealizoMovimientoException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}
	public void atacarPersonaje(IPersonaje atacante , IPersonaje atacado, Jugador jugador){
		if(jugador.puedeUsarPersonaje(atacante)){
			if(!realizoAtaque){
				atacante.atacar(atacado);
				realizoAtaque = true;
			}else{
				throw new YaRealizoAtaqueException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}
	public void atacarPersonaje(IPersonajeEquipoVillano atacante , IPersonaje atacado, Jugador jugador){
		if(jugador.puedeUsarPersonaje(atacante)){
			if(!realizoAtaque){
				atacante.atacar(atacado);
				realizoAtaque = true;
			}else{
				throw new YaRealizoAtaqueException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}

	public void ataqueEspecialPersonaje(IPersonaje atacante, IPersonaje atacado, Jugador jugador) {
		if(jugador.puedeUsarPersonaje(atacante)){
			if(!realizoAtaque){
				atacante.ataqueEspecial(atacado);
				realizoAtaque = true;
			}else{
				throw new YaRealizoAtaqueException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}

	public void ataqueEspecialPersonaje(IPersonajeEquipoZ atacante , IPersonajeEquipoVillano atacado, Jugador jugador){
		if(jugador.puedeUsarPersonaje(atacante)){
			if(!realizoAtaque){
				atacante.ataqueEspecial(atacado);
				realizoAtaque = true;
			}else{
				throw new YaRealizoAtaqueException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}
	public void ataqueEspecialPersonaje(IPersonajeEquipoVillano atacante , IPersonajeEquipoZ atacado, Jugador jugador){
		if(jugador.puedeUsarPersonaje(atacante)){
			if(!realizoAtaque){
				atacante.ataqueEspecial(atacado);
				realizoAtaque = true;
			}else{
				throw new YaRealizoAtaqueException();
			}
		}else{
			throw new NoPuedeUsarEsePersonajeException();
		}
	}
	public Jugador terminarTurno(){
		jugadorActual = jugadorActual.terminarTurno();
		this.comenzarTurno();
		return jugadorActual;
	}

	public int cantidadPersonajesVivos(Jugador jugador) {
		return jugador.cantidadPersonajesVivos();
	}

	public Goku getGoku(){
		return (Goku) jugadorEquipoZ.getPersonaje("Goku");
	}

	public Gohan getGohan(){
		return (Gohan) jugadorEquipoZ.getPersonaje("Gohan");
	}

	public Piccolo getPiccolo(){
		return (Piccolo) jugadorEquipoZ.getPersonaje("Piccolo");
	}

	public Freezer getFreezer(){
		return (Freezer) jugadorEquipoVillano.getPersonaje("Freezer");
	}

	public Cell getCell(){
		return (Cell) jugadorEquipoVillano.getPersonaje("Cell");
	}

	public MajinBoo getMajinBoo(){
		return (MajinBoo) jugadorEquipoVillano.getPersonaje("MajinBoo");
	}

}
