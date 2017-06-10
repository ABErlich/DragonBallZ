package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class Cell extends Personaje{
	
    public Cell (Coordenada pCoordenada){
    	super(pCoordenada);
        vida = 500;
        poder = 20;
        distanciaAtaque = 3;
        velocidadMov = 2;
        ki = 0;
    }
    
    public Cell (){
        vida = 500;
        poder = 20;
        distanciaAtaque = 3;
        velocidadMov = 2;
        ki = 0;
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

    public void absorber(){
        ki = ki - 5;
        vida = vida + 20;
    }
    */
}

