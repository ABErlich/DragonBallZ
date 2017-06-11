package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IEquipoZ;

public class Gohan extends Personaje implements IEquipoZ{

    public Gohan (Coordenada pCoordeanda){
    	super(pCoordeanda);
        /*vida = 300;
        poder = 15;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;*/
    }
    /*
    public void superSayajinFase1(){
        ki = ki - 10;
        poder = 30;
        distanciaAtaque = 2;
        velocidadMov = 2;
    }

    public void superSayajinFase2(){
        ki = ki - 30;
        poder = 100;
        distanciaAtaque  = 4;
        velocidadMov = 3;
    }

    public void masenko(){
        ki = ki - 10;
        poder = 19; //El poder deberia ser 18.75, pero estamos usando int, no float.
    }
    public void transformar(IEstadoGohan pEstado) {
		this.estado = pEstado;
	}*/
}

