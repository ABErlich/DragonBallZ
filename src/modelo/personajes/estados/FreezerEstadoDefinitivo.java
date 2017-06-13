package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
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
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}