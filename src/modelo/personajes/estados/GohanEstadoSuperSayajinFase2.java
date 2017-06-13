package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoSuperSayajinFase2 extends Estado {

    public GohanEstadoSuperSayajinFase2(Stats stats){
    	stats.setPoder(100);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(3);
		stats.setKi(stats.getKi() - 30);
    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
