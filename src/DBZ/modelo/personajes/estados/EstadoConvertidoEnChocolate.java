package DBZ.modelo.personajes.estados;


import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.excepciones.PersonajeInhabilitadoException;

public class EstadoConvertidoEnChocolate extends Estado {

    private int cantidadTurnos;
    private Estado estadoAnterior;

    public EstadoConvertidoEnChocolate(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
        this.cantidadTurnos = 3;
    }

    @Override
    public void atacar(IPersonajeEquipoVillano personaje) {
        throw new PersonajeInhabilitadoException();
    }

    @Override
    public void atacar(IPersonajeEquipoZ personaje) {
        throw new PersonajeInhabilitadoException();
    }

    @Override
    public void mover(Coordenada destino){
		throw new PersonajeInhabilitadoException();
	}

    @Override
    public Estado terminoTurno(){
    	cantidadTurnos--;
    	if(cantidadTurnos == 0){
    		return estadoAnterior;
    	}else{
    		return null;
    	}
    }

}