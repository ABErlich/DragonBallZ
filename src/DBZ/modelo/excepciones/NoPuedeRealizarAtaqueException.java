package DBZ.modelo.excepciones;

public class NoPuedeRealizarAtaqueException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "No puede realizar el ataque";
}
