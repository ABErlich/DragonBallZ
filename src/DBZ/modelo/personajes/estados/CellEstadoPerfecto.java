package DBZ.modelo.personajes.estados;


import DBZ.modelo.excepciones.UltimoEstadoException;

public class CellEstadoPerfecto extends CellEstado {

    public CellEstadoPerfecto() {

		poder = 80;
		distanciaAtaque = 4;
		velocidadMov = 4;
    }


	@Override
	public CellEstado transformar() {
		throw new UltimoEstadoException();
	}
}