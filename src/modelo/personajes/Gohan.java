package modelo.personajes;

import modelo.juego.interfaces.IJugadorEquipo;
import modelo.personajes.Personaje;
import modelo.personajes.estados.GohanEstadoNormal;
import modelo.personajes.estados.GohanEstadoSuperSayajinFase1;
import modelo.personajes.estados.GohanEstadoSuperSayajinFase2;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.NoPuedeTransformarException;

public class Gohan extends Personaje implements IPersonajeEquipoZ{

    public Gohan (Coordenada pCoordeanda){
    	stats.setUbicacion(pCoordeanda);
    	this.estado = new GohanEstadoNormal(stats);

    }
    
    public void masenko(IPersonajeEquipoZ pPersonaje){
    	throw new AtaqueMismoEquipoException();
    }
    
    public void masenko(IPersonajeEquipoVillano pPersonaje){
    	if(this.stats.getKi() < 10){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		this.stats.setKi(this.stats.getKi() - 10);
    		pPersonaje.setVida( (int) (pPersonaje.getVida() - this.stats.getPoder()*1.25) );
    	}
    }
    
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

