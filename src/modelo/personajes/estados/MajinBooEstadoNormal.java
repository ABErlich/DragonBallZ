package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoNormal extends Estado {

    public MajinBooEstadoNormal(Coordenada pUbicacion){
        super(pUbicacion);
        vida = 300;
        poder = 30;
        distanciaAtaque = 2;
        velocidadMov = 2;
        ki = 0;
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje){
        throw new AtaqueMismoEquipoException();
    }


}
