package DBZ.modelo.excepciones;

public class PersonajeYaEsChocolateException extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Este personaje ya esta convertido en chocolate";

}
