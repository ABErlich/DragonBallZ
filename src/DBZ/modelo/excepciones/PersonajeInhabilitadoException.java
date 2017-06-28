package DBZ.modelo.excepciones;

public class PersonajeInhabilitadoException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Este personaje esta convertido en chocolate";
}
