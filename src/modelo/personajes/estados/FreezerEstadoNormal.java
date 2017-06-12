package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoNormal extends Estado {

    public FreezerEstadoNormal(Coordenada pUbicacion){
        super(pUbicacion);
        vida = 400;
        poder = 20;
        distanciaAtaque = 2;
        velocidadMov = 4;
        ki = 0;
    }

    @Override
    public void Atacar(PersonajeEquipoVillano pPersonaje){
        throw new AtaqueMismoEquipoException();
    }


}
