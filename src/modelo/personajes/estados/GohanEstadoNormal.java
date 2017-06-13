package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoNormal extends Estado {

    public GohanEstadoNormal(Coordenada pUbicacion){
        super(pUbicacion);
        vida = 300;
        poder = 15;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
    }

    @Override
    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}