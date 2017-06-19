package modelo.juego;

import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import modelo.excepciones.JugadorYaExisteException;
import modelo.excepciones.JugadoresNoSeleccionadosException;
import modelo.excepciones.YaRealizoAtaqueException;
import modelo.excepciones.YaRealizoMovimientoException;
import modelo.personajes.interfaces.IPersonaje;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Juego {

	public Juego(int tamanioTablero){
		this.tablero = new Tablero(tamanioTablero);
	}
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	private Tablero tablero;
	private boolean realizoMovimiento;
	private boolean realizoAtaque;
	
	public void agregarJugador1(Jugador jugador){
		if(jugador1 == null){
			jugador1 = jugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}
	
	public void agregarJugador2(Jugador jugador){
		if(jugador2 == null){
			jugador2 = jugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}
	
	public void comenzarJuego(){
		if(jugador1 == null || jugador2 == null){
			throw new JugadoresNoSeleccionadosException();
		}
		jugador1.agregarRival(jugador2);
		jugador2.agregarRival(jugador1);
		
		double selector = Math.random();
		if(selector > 0.5){
			jugadorActual = jugador1;
		}else{
			jugadorActual = jugador2;
		}
		this.comenzarTurno();
	}
	
	private void comenzarTurno() {
		realizoMovimiento = false;
		realizoAtaque = false;
	}
	
	public void moverPersonaje(IPersonaje personaje, Coordenada coordenada){
		if(!realizoMovimiento){
			tablero.moverPersonaje(personaje, coordenada);
			realizoMovimiento = true;
		}else{
			throw new YaRealizoMovimientoException();
		}
	}
	
	public void atacarPersonaje(IPersonajeEquipoZ atacante , IPersonajeEquipoVillano atacado){
		if(!realizoAtaque){
			atacante.atacar(atacado);
			realizoAtaque = true;
		}else{
			throw new YaRealizoAtaqueException();
		}
	}
	
	public void atacarPersonaje(IPersonajeEquipoVillano atacante , IPersonajeEquipoZ atacado){
		if(!realizoAtaque){
			atacante.atacar(atacado);
			realizoAtaque = true;
		}else{
			throw new YaRealizoAtaqueException();
		}
	}
	
	public void ataqueEspecialPersonaje(IPersonajeEquipoZ atacante , IPersonajeEquipoVillano atacado){
		if(!realizoAtaque){
			atacante.ataqueEspecial(atacado);
			realizoAtaque = true;
		}else{
			throw new YaRealizoAtaqueException();
		}
	}
	
	public void ataqueEspecialPersonaje(IPersonajeEquipoVillano atacante , IPersonajeEquipoZ atacado){
		if(!realizoAtaque){
			atacante.ataqueEspecial(atacado);
			realizoAtaque = true;
		}else{
			throw new YaRealizoAtaqueException();
		}
	}

	public void terminarTurno(){
		jugadorActual = jugadorActual.terminarTurno();
	}

	
	
	
	
	
	
	
	
	public void asignarEquipoZ(Jugador jugador) {
		jugador.asignarEquipoZ(this.tablero);
		jugador.ubicarPersonajes(tablero);
	}

	public void asignarEquipoVillano(Jugador jugador) {
		jugador.asignarEquipoVillano(this.tablero);
		jugador.ubicarPersonajes(tablero);
	}

	public Object cantidadPersonajesVivos(Jugador jugador) {
		return jugador.cantidadPersonajesVivos();
	}


}
