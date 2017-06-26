package DBZ.modelo.excepciones;

public class YaRealizoMovimientoException extends RuntimeException{
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Ya realizo un movimiento en este turno";
}
