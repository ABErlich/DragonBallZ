package modelo.personajes.estados;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class CellEstado extends Estado {
	
	protected int cantAbsorciones;
	
	public CellEstado(){
		cantAbsorciones = 0;
		vidaMaxima = 500;
	}
	
	
	public void absorber(IPersonajeEquipoZ personaje){
        if(ki < 5){
            throw new NoPuedeRealizarAtaqueException();
        }else{
            this.cantAbsorciones += 1;
            ki = ki - 5;
            vida = vida + poder;
            personaje.recibirAtaque(poder);
        }
	}


	public abstract CellEstado transformar();
}
