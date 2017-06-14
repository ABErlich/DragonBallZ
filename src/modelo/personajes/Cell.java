package modelo.personajes;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.estados.CellEstadoNormal;
import modelo.personajes.estados.CellEstadoSemiPerfecto;
import modelo.personajes.estados.CellEstadoPerfecto;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.NoPuedeTransformarException;

public class Cell extends Personaje implements IPersonajeEquipoVillano{
	
    private int cantAbsorciones;

    public Cell (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new CellEstadoNormal(stats);
        this.cantAbsorciones = 0;
    }

    public void absorber(IPersonajeEquipoZ pPersonaje){
        if(this.stats.getKi() < 5){
            throw new NoPuedeRealizarAtaqueException();
        }else{
            this.cantAbsorciones += 1;
            this.stats.setKi(this.stats.getKi() - 5);
            this.stats.setVida(this.stats.getVida() + 20);
            pPersonaje.setVida(pPersonaje.getVida() - 20);
        }
    }
    
    @Override
    public void transformar(){
        if(this.estado instanceof CellEstadoNormal && cantAbsorciones >= 4){

        }else if(this.estado instanceof CellEstadoSemiPerfecto && cantAbsorciones >= 8){
            
        }else{
            throw new NoPuedeTransformarException();
        }
    }



    /*
    public void semiPerfecto(){
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    public void perfecto(){
        poder = 80;
        distanciaAtaque  = 4;
        velocidadMov = 4;
    }

    
    */
}

