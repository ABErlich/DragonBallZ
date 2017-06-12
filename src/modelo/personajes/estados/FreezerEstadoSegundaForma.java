package modelo.personajes.estados;


import modelo.personajes.PersonajeEquipoVillano;
import modelo.personajes.PersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoSegundaForma extends Estado {

    public FreezerEstadoSegundaForma(Coordenada pUbicacion) {
        super(pUbicacion);
        ki = ki - 20;
        poder = 40;
        distanciaAtaque = 3;
        velocidadMov = 4;
    }

    @Override
    public void Atacar(PersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}