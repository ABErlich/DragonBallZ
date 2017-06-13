package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IPersonajeEquipoVillano;
import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoSemiPerfecto extends Estado {

    public CellEstadoSemiPerfecto(Coordenada pUbicacion) {
        super(pUbicacion);
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}