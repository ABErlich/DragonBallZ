package DBZ.modelo.excepciones;

public class AtaqueFueraDeRangoException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return message;
	}

	public String message = "Ataque fuera de rango";

}
