import java.util.ArrayList;

public class Tablero {
	
	public Tablero(int pTamanio){
		this.celdas = new ArrayList<Celda>();
		
		for(int i = 0; i < pTamanio; i++){
			for(int j = 0; j<pTamanio; j++){
				
			}
		}
	}
	
	private ArrayList<Celda> celdas;
	
	public boolean PuedeUbicar(Coordenada pCoordenada){
		return false;
	}
	public void Ubicar(Ubicable pUbicable){
		
	}
	
}
