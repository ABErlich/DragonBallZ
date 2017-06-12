package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.PersonajeEquipoZ;
public class Piccolo extends PersonajeEquipoZ {

    public Piccolo (Coordenada pCoordenada){
        super(pCoordenada);
        /*vida = 500;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;*/
    }

    /*
    public void fortalecido(){
        ki = ki - 20;
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    public void protector(){
        poder = 60;
        distanciaAtaque  = 6;
        velocidadMov = 4;
    }

    public void makankosappo(){
        ki = ki - 10;
        poder = 31; //Deberia ser 31.25, pero por ser int y no float se tomo el valor mas proximo.
    }
    */
}

