package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.tablero.Coordenada;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.PersonajeInhabilitadoException;

public class EstadoConvertidoEnChocolate extends Estado {

    private int cantidadTurnos;
    private Estado estadoAnterior;
    public EstadoConvertidoEnChocolate(Estado pEstadoAnterior) {
		estadoAnterior = pEstadoAnterior;
        cantidadTurnos = 3;
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
}