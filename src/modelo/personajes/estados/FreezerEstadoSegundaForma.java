package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeTransformarException;

public class FreezerEstadoSegundaForma extends FreezerEstado {

    public FreezerEstadoSegundaForma() {

		poder = 40;
		distanciaAtaque = 3;
		velocidadMov = 4;

    }

    @Override
    public void atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public FreezerEstado transformar() {
		if(ki > 50){
			 ki = ki - 50;
			 FreezerEstado nuevoestado = new FreezerEstadoDefinitivo();
			 nuevoestado.vida = vida;
			 nuevoestado.ki = ki;
			 nuevoestado.ubicacion = ubicacion;
			 return nuevoestado;

		}
		throw new NoPuedeTransformarException();
	}
}