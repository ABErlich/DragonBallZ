package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoBooMalo extends Estado {

    public MajinBooEstadoBooMalo(Coordenada pUbicacion) {
        super(pUbicacion);
        ki = ki - 20;
        poder = 50;
        distanciaAtaque = 2;
        velocidadMov = 3;
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}