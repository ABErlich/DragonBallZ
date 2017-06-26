package DBZ.modelo.excepciones;

public class CeldaOcupadaException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "La celda esta ocupada";
}
