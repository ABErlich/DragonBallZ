package DBZ.modelo.excepciones;

public class AtaqueMismoEquipoException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "No puede atacar un personaje del mismo equipo";
}
