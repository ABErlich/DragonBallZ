package DBZ.modelo.personajes.estados;


import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeTransformarException;

public class MajinBooEstadoBooMalo extends MajinBooEstado {

    public MajinBooEstadoBooMalo() {

		poder = 50;
		distanciaAtaque = 2;
		velocidadMov = 3;

    }

    @Override
    public void atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public MajinBooEstado transformar() {
		if(ki > 50){
	    	ki = ki - 50;
			MajinBooEstado nuevoestado = new MajinBooEstadoBooOriginal();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}
		throw new NoPuedeTransformarException();
	}
}