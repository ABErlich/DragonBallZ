package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoNormal extends Estado {

    public PiccoloEstadoNormal(Coordenada pUbicacion){
        super(pUbicacion);
        vida = 500;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
    }

    @Override
    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}