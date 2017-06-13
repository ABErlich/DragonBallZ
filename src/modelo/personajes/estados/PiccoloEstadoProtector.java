package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoProtector extends Estado {

    public PiccoloEstadoProtector(Coordenada pUbicacion){
        super(pUbicacion);
        poder = 60;
        distanciaAtaque  = 6;
        velocidadMov = 4;
    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
