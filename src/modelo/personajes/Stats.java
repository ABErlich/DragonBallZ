package modelo.personajes;

import modelo.tablero.Coordenada;

public class Stats {

	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	protected Coordenada ubicacion;

    public int getVida(){
        return this.vida;
    }

    public void setVida(int pVida){
        this.vida = pVida;
    }
    
    public int getPoder(){
        return this.poder;
    }

    public void setPoder(int pPoder){
        this.poder = pPoder;
    }

    public int getDistanciaAtaque(){
        return this.distanciaAtaque;
    }

    public void setDistanciaAtaque(int pDistanciaAtaque){
        this.distanciaAtaque = pDistanciaAtaque;
    }

    public int getVelocidadMov(){
        return this.velocidadMov;
    }

    public void setVelocidadMov(int pVelocidadMov){
        this.velocidadMov = pVelocidadMov;
    }

    public int getKi(){
        return this.ki;
    }

    public void setKi(int pKi){
        this.ki = pKi;
    }

    public Coordenada getUbicacion(){
        return this.ubicacion;
    }

    public void setUbicacion(Coordenada pCoordenada){
        this.ubicacion = pCoordenada;
    }
    
}

