package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoProtector extends Estado {

    public PiccoloEstadoProtector(Stats stats){

		stats.setPoder(60);
		stats.setDistanciaAtaque(6);
		stats.setVelocidadMov(4);

    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
