package modelo.personajes.interfaces;

import modelo.tablero.Coordenada;
import modelo.personajes.estados.Estado;

public interface IPersonajeEquipo {
    Coordenada obtenerUbicacion();
    Estado obtenerEstado();
    int getVida();
    void setVida(int pVida);
    void transformar(Estado pEstado);
}
