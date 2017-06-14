package modelo.personajes;

import modelo.juego.interfaces.IJugadorEquipo;
import modelo.juego.JugadorEquipoZ;
import modelo.personajes.Personaje;
import modelo.personajes.estados.GohanEstadoNormal;
import modelo.personajes.estados.GohanEstadoSuperSayajinFase1;
import modelo.personajes.estados.GohanEstadoSuperSayajinFase2;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipo;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.NoPuedeTransformarException;

public class Gohan extends Personaje implements IPersonajeEquipoZ{

    public Gohan (Coordenada pCoordeanda){
    	stats.setUbicacion(pCoordeanda);
    	this.estado = new GohanEstadoNormal(stats);

    }
    /*
    public void masenko(){
        ki = ki - 10;
        poder = 19; //El poder deberia ser 18.75, pero estamos usando int, no float.
    }*/
    @Override
    public void transformar(){
        if(this.stats.getKi() >= 10){
            this.stats.setKi(this.stats.getKi() - 10);
            this.estado = new GohanEstadoSuperSayajinFase1(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
    }

    // VER CON TOMAS COMO HACER ESTO DE UNA MANERA MEJOR
    @Override
    public void transformar(IJugadorEquipo equipo) {
        if((this.stats.getKi() >= 30) && (equipo.getPersonaje("Goku").getVida() < 150) && (equipo.getPersonaje("Piccolo").getVida() < 150)){
             this.stats.setKi(this.stats.getKi() - 30);
            this.estado = new GohanEstadoSuperSayajinFase2(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
	}
}

