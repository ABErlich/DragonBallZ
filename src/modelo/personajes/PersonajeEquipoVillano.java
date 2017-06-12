package modelo.personajes;

import modelo.personajes.IPersonajeEquipo;
import modelo.tablero.Coordenada;


public class PersonajeEquipoVillano extends Personaje implements IPersonajeEquipoVillano {

    public PersonajeEquipoVillano(Coordenada pCoordenada){
        super(pCoordenada);
    }

}
