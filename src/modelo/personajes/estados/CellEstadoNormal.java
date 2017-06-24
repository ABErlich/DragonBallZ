package modelo.personajes.estados;

import modelo.excepciones.NoPuedeTransformarException;

public class CellEstadoNormal extends CellEstado {

	public CellEstadoNormal(){
		super();
		vida = 500;
		poder = 20;
		distanciaAtaque = 3;
		velocidadMov = 2;
		ki = 0;

	}
	

	@Override
	public CellEstado transformar() {
		if(this.cantAbsorciones >= 4){
			CellEstado nuevoestado = new CellEstadoSemiPerfecto();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}else{
			throw new NoPuedeTransformarException();
		}
	}


}
