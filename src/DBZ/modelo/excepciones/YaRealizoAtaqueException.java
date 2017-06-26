package DBZ.modelo.excepciones;

public class YaRealizoAtaqueException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Ya realizo un ataque en este turno";
}
