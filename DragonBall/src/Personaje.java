
public abstract class Personaje implements Ubicable {

	private String Nombre;
	
	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	
	public void Atacar(Personaje pPersonaje){
		pPersonaje.RecibirAtaque(poder);
	}

	public void Mover(Coordenada pCoordenada){
		if pCoordenada.estaVacia(){
			//UBICAR PERSONAJE
		}
	}
	public void RecibirAtaque(int danio){
		vida = vida - danio;
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
