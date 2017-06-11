package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IPersonajeEquipoVillano;;
public class MajinBoo extends Personaje implements IPersonajeEquipoVillano {

    public MajinBoo (Coordenada pCoordenada){
        super(pCoordenada);
        /*vida = 300;
        poder = 30;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;*/
    }

    /*
    public void booMalo(){
        ki = ki - 20;
        poder = 50;
        distanciaAtaque = 2;
        velocidadMov = 3;
    }

    public void booOriginal(){
        ki = ki - 50;
        poder = 60;
        distanciaAtaque  = 3;
        velocidadMov = 4;
    }

    public void convierteEnChocolate(){
        ki = ki - 30;
    }
    */
}

