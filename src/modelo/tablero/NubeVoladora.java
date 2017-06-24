package modelo.tablero;

import modelo.personajes.estados.Estado;
import modelo.tablero.Consumible;

public class NubeVoladora extends Consumible {
	
	private int turnosBonificacion;

	public NubeVoladora(){
		this.consumido = false;
		this.turnosBonificacion = 2;
	}

	@Override
	public void consumir(Estado estado) {
		estado.setBonificacionNube(turnosBonificacion);
		this.consumido = true;
	}

}
