package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.personajes.Personaje;

public class MajinBoo extends Personaje {

    public MajinBoo (){
        vida = 300;
        poder = 30;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
    }

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
}
}
