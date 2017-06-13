package modelo.personajes.estados;

import modelo.personajes.IPersonajeEquipoZ;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoSuperSayajinFase1 extends Estado {

    public GohanEstadoSuperSayajinFase1(Coordenada pUbicacion){
        super(pUbicacion);
        ki = ki - 10;
        poder = 30;
        distanciaAtaque  = 2;
        velocidadMov = 2;
    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
