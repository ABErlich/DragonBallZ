package DBZ.modelo.personajes.estados;


import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeTransformarException;

public class MajinBooEstadoNormal extends MajinBooEstado {

    public MajinBooEstadoNormal(){
    	super();
		vida = 300;
		poder = 30;
		distanciaAtaque = 2;
		velocidadMov = 2;
		ki = 0;

    }

    @Override
    public void atacar(IPersonajeEquipoVillano pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public MajinBooEstado transformar() {
		if(ki > 20){
        	ki = ki - 20;
			MajinBooEstado nuevoestado = new MajinBooEstadoBooMalo();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}
        throw new NoPuedeTransformarException();

	}


}
