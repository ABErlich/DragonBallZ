package modelo.tablero;

import modelo.personajes.estados.Estado;
import modelo.tablero.Consumible;

public class SemilladelHermitano extends Consumible {
	
	private int vidaExtra;
	
	public SemilladelHermitano(){
		this.vidaExtra = 100;
		this.consumido = false;
	}
	

	public void consumir(Estado estado) {
		this.consumido = true;
		estado.sumarVida(this.vidaExtra);
	}


}
