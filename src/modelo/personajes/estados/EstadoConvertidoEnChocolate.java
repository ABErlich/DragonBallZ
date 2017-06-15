package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.tablero.Coordenada;
import modelo.personajes.Stats;
import modelo.excepciones.PersonajeInhabilitadoException;

public class EstadoConvertidoEnChocolate extends Estado {

    private int cantidadTurnos;
    private Estado estadoAnterior;
    
    public EstadoConvertidoEnChocolate(Estado pEstadoAnterior) {
		setEstadoAnterior(pEstadoAnterior);
        setCantidadTurnos(3);
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new PersonajeInhabilitadoException();
    }

    @Override
    public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats) {
        throw new PersonajeInhabilitadoException();
    }

    @Override
    public void Mover(Coordenada pDestino, Stats stats){
		throw new PersonajeInhabilitadoException();
	}

	public int getCantidadTurnos() {
		return cantidadTurnos;
	}

	public void setCantidadTurnos(int cantidadTurnos) {
		this.cantidadTurnos = cantidadTurnos;
	}

	public Estado getEstadoAnterior() {
		return estadoAnterior;
	}

	public void setEstadoAnterior(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}
}