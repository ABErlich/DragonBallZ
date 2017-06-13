package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoFortalecido extends Estado {

    public PiccoloEstadoFortalecido(Stats stats){
		stats.setPoder(40);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(3);
		stats.setKi(stats.getKi() - 20);

    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
