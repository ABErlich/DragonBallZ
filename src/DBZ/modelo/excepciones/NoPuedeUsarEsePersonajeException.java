package DBZ.modelo.excepciones;

public class NoPuedeUsarEsePersonajeException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "No puede utilizar este personaje";
}
