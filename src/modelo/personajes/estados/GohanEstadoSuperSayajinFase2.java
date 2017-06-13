package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoSuperSayajinFase2 extends Estado {

    public GohanEstadoSuperSayajinFase2(Coordenada pUbicacion){
        super(pUbicacion);
        ki = ki - 30;
        poder = 100;
        distanciaAtaque  = 4;
        velocidadMov = 3;
    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
