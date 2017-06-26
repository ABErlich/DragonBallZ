package DBZ.modelo.excepciones;

public class NoPuedeTransformarException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "El personaje no se puede transformar";
}
