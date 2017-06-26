package DBZ.modelo.excepciones;

public class UltimoEstadoException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "El personaje ya esta en su ultima transformacion";
}
