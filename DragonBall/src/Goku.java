/**
 * Created by pizzini on 06-Jun-17.
 */
public class Goku extends Personaje {

    public Goku (){
        vida = 500;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
    }

    public void kaioKen(){
        ki = ki - 20;
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    public void superSayajin(){
        ki = ki - 50;
        poder = 60;
        distanciaAtaque  = 4;
        velocidadMov = 5;
    }

    public void kamehameha(){
        ki = ki - 20;
        poder = 30;
    }
}

