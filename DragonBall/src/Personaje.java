
public abstract class Personaje implements Ubicable {

	private String Nombre;
	
	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	
	public void Atacar(Personaje pPersonaje){
		
	}
	public void Mover(Coordenada pCoordenada){
		
	}
	public void RecibirAtaque(Personaje pPersonaje){
		
	}
	@Override
	public void Ubicar(Coordenada pCoordenada) {
		
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
