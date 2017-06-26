package DBZ.modelo.personajes.estados;

import DBZ.modelo.excepciones.NoPuedeTransformarException;

public class GokuEstadoKaioKen extends GokuEstado {

	public GokuEstadoKaioKen(){

		poder = 40;
		distanciaAtaque = 4;
		velocidadMov = 3;

	}

	@Override
	public GokuEstado transformar() {
		if(ki < 50){
			throw new NoPuedeTransformarException();
		}else{
			ki = ki - 50;
			GokuEstado nuevoestado = new GokuEstadoSuperSayajin();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}
	}

}
