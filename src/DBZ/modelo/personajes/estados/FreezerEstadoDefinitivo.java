package DBZ.modelo.personajes.estados;


import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.UltimoEstadoException;

public class FreezerEstadoDefinitivo extends FreezerEstado {

    public FreezerEstadoDefinitivo() {

		poder = 50;
		distanciaAtaque = 3;
		velocidadMov = 6;

    }

    @Override
    public void atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public FreezerEstado transformar() {
		throw new UltimoEstadoException();
	}
}