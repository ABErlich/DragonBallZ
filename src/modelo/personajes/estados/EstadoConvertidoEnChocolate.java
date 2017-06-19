package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.tablero.Coordenada;
import modelo.excepciones.PersonajeInhabilitadoException;

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