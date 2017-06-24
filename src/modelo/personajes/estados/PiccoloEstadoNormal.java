package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeTransformarException;
import modelo.juego.interfaces.IJugadorEquipoZ;

public class PiccoloEstadoNormal extends PiccoloEstado {

    public PiccoloEstadoNormal(){
    	super();
		vida = 500;
		poder = 20;
		distanciaAtaque = 2;
		velocidadMov = 2;
		ki = 0;
    }

    @Override
    public void atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public PiccoloEstado transformar(IJugadorEquipoZ equipo) {
        if(ki > 20){
        	ki = ki - 20;
			PiccoloEstado nuevoestado = new PiccoloEstadoFortalecido();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
        }
        throw new NoPuedeTransformarException();
        
	}

}