package DBZ.modelo.personajes.estados;


import DBZ.modelo.excepciones.NoPuedeTransformarException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;


public class GohanEstadoNormal extends GohanEstado {

    public GohanEstadoNormal(){
    	super();
		vida = 300;
		poder = 15;
		distanciaAtaque = 2;
		velocidadMov = 2;
		ki = 0;
    }

	@Override
	public GohanEstado transformar(IJugadorEquipoZ equipo) {
		if(ki > 10){
            ki = ki - 10;
			GohanEstado nuevoestado = new GohanEstadoSuperSayajinFase1();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
        }
        throw new NoPuedeTransformarException();
	}

}