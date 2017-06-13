package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoPerfecto extends Estado {

    public CellEstadoPerfecto(Coordenada pUbicacion) {
        super(pUbicacion);
        poder = 80;
        distanciaAtaque = 4;
        velocidadMov = 4;
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}