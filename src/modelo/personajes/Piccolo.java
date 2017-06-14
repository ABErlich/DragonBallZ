package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.PiccoloEstadoNormal;
import modelo.personajes.estados.PiccoloEstadoFortalecido;
import modelo.personajes.estados.PiccoloEstadoProtector;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.excepciones.NoPuedeTransformarException;

public class Piccolo extends Personaje implements IPersonajeEquipoVillano {

    public Piccolo (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new PiccoloEstadoNormal(stats);

    }

    @Override
    public void transformar(){
        if(this.stats.getKi() >= 20){
            this.stats.setKi(this.stats.getKi() - 20);
            this.estado = new PiccoloEstadoFortalecido(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
    }

    // VER CON TOMAS COMO HACER ESTO DE UNA MANERA MEJOR
    @Override
    public void transformar(IJugadorEquipo equipo) {
        if(equipo.getPersonaje("Gohan").getVida() < 60){
            this.estado = new PiccoloEstadoProtector(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
	}
    /*

    public void makankosappo(){
        ki = ki - 10;
        poder = 31; //Deberia ser 31.25, pero por ser int y no float se tomo el valor mas proximo.
    }
    */
}

