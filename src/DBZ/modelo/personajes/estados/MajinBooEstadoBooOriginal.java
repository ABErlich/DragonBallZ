package DBZ.modelo.personajes.estados;


import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.UltimoEstadoException;

public class MajinBooEstadoBooOriginal extends MajinBooEstado {

    public MajinBooEstadoBooOriginal() {

		poder = 60;
		distanciaAtaque = 3;
		velocidadMov = 4;

    }

    @Override
    public void atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }

	@Override
	public MajinBooEstado transformar() {
		throw new UltimoEstadoException();
	}
}