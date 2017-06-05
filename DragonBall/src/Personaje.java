
public abstract class Personaje implements Ubicable {

	private String Nombre;
	
	private int vida;
	private int poder;
	private int distanciaAtaque;
	private int velocidadMov;
	private int ki;
	
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
