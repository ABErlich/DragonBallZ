package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeTransformarException;
import modelo.juego.interfaces.IJugadorEquipoZ;

public class PiccoloEstadoFortalecido extends PiccoloEstado {

    public PiccoloEstadoFortalecido(){

		poder = 40;
		distanciaAtaque = 4;
		velocidadMov = 3;

    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public PiccoloEstado transformar(IJugadorEquipoZ equipo) {
        if(equipo.getPersonaje("Gohan").vidaMenor30porc()){
			PiccoloEstado nuevoestado = new PiccoloEstadoProtector();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
        }
        throw new NoPuedeTransformarException();
        
	}

}
