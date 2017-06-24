package modelo.personajes.estados;

import modelo.excepciones.NoPuedeTransformarException;

public class GokuEstadoNormal extends GokuEstado {

	public GokuEstadoNormal(){
		super();
		vida = 500;
		poder = 20;
		distanciaAtaque = 2;
		velocidadMov = 2;
		ki = 0;

	}

	@Override
	public GokuEstado transformar() {
		if(ki < 20){
			throw new NoPuedeTransformarException();
		}else{
			ki = ki - 20;
			GokuEstado nuevoestado = new GokuEstadoKaioKen();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}
	}

}
