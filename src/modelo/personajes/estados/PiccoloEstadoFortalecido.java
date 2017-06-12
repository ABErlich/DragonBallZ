package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoFortalecido extends Estado {

    public PiccoloEstadoFortalecido(Coordenada pUbicacion){
        super(pUbicacion);
        ki = ki - 20;
        poder = 40;
        distanciaAtaque  = 4;
        velocidadMov = 3;
    }

    public void Atacar(PersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
