package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoBooOriginal extends Estado {

    public MajinBooEstadoBooOriginal(Coordenada pUbicacion) {
        super(pUbicacion);
        ki = ki - 50;
        poder = 60;
        distanciaAtaque = 3;
        velocidadMov = 4;
    }

    @Override
    public void Atacar(PersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}