package DBZ.modelo.personajes.estados;


import DBZ.modelo.excepciones.NoPuedeTransformarException;

public class CellEstadoSemiPerfecto extends CellEstado {

    public CellEstadoSemiPerfecto() {
		poder = 40;
		distanciaAtaque = 4;
		velocidadMov = 3;

    }

	@Override
	public CellEstado transformar() {
		if(this.cantAbsorciones >= 4){
			CellEstado nuevoestado = new CellEstadoPerfecto();
			nuevoestado.vida = vida;
			nuevoestado.ki = ki;
			nuevoestado.ubicacion = ubicacion;
			return nuevoestado;
		}else{
			throw new NoPuedeTransformarException();
		}
	}
}