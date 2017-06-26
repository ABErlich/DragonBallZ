package DBZ.modelo.personajes.estados;

import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeTransformarException;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;

public class GohanEstadoSuperSayajinFase1 extends GohanEstado {

    public GohanEstadoSuperSayajinFase1(){

		poder = 30;
		distanciaAtaque = 2;
		velocidadMov = 2;

    }

    public void Atacar(IPersonajeEquipoZ personaje){
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public GohanEstado transformar(IJugadorEquipoZ equipo) {
		if(ki > 30 && (equipo.getPersonaje("Goku").vidaMenor30porc()) && (equipo.getPersonaje("Piccolo").vidaMenor30porc())){
			ki = ki - 30;
			GohanEstado nuevoestado = new GohanEstadoSuperSayajinFase2();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
       }else{
           throw new NoPuedeTransformarException();
       }
	}

}
