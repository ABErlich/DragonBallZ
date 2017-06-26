package DBZ.modelo.tablero;

import DBZ.modelo.personajes.estados.Estado;
import DBZ.modelo.tablero.Consumible;

public class EsferaDelDragon extends Consumible {

	private double bonificacionAtaque;
	private int turnosBonificacion;

	public EsferaDelDragon(){
		bonificacionAtaque = 1.25;
		turnosBonificacion = 2;
		this.consumido = false;
	}

	@Override
	public void consumir(Estado estado) {
		this.consumido = true;
		estado.setBonificacionEsfera(this.bonificacionAtaque, turnosBonificacion);
	}

}
