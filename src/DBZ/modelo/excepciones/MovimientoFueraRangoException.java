package DBZ.modelo.excepciones;

public class MovimientoFueraRangoException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Movimiento fuera de rango";

}
