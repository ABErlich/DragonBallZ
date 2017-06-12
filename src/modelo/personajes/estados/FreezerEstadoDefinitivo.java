package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoDefinitivo extends Estado {

    public FreezerEstadoDefinitivo(Coordenada pUbicacion) {
        super(pUbicacion);
        ki = ki - 50;
        poder = 50;
        distanciaAtaque = 3;
        velocidadMov = 6;
    }

    @Override
    public void Atacar(PersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}