package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
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
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}