package DBZ.modelo.personajes.estados;

import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeTransformarException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;

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
