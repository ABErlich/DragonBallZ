package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IEquipoVillano;

public class Freezer extends Personaje implements IEquipoVillano {

    public Freezer (Coordenada pCoordenada){
        super(pCoordenada);
        /*vida = 400;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 4;
        ki = 0;*/
    }

    /*
    public void segundaForma(){
        ki = ki - 20;
        poder = 40;
        distanciaAtaque = 3;
        velocidadMov = 4;
    }

    public void definitivo(){
        ki = ki - 50;
        poder = 50;
        distanciaAtaque  = 3;
        velocidadMov = 6;
    }

    public void rayoMortal(){
        ki = ki - 20;
        poder = 30;
    }
    */
}

