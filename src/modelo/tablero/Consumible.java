package modelo.tablero;

import modelo.personajes.estados.Estado;

public abstract class Consumible {


	protected boolean consumido;
	
	public abstract void consumir(Estado estado);

	public boolean estaConsumido(){
		return this.consumido;
	}

}
