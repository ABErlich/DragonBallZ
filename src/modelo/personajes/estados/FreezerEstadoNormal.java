package modelo.personajes.estados;

import modelo.excepciones.NoPuedeTransformarException;

public class FreezerEstadoNormal extends FreezerEstado {

    public FreezerEstadoNormal(){
    	super();
		vida = 400;
		poder = 20;
		distanciaAtaque = 2;
		velocidadMov = 4;
		ki = 0;

    }

	@Override
	public FreezerEstado transformar() {
		 if(ki > 20){
			 ki = ki -20;
			 FreezerEstado nuevoestado = new FreezerEstadoSegundaForma();
			 nuevoestado.vida = vida;
			 nuevoestado.ki = ki;
			 nuevoestado.ubicacion = ubicacion;
			 return nuevoestado;
		 }
		 throw new NoPuedeTransformarException();
		 
	}


}
