package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoSuperSayajinFase1 extends Estado {

    public GohanEstadoSuperSayajinFase1(Stats stats){
		stats.setPoder(30);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(2);
		stats.setKi(stats.getKi() - 10);
    }

    public void Atacar(IPersonajeEquipoZ pPersonaje){
        throw new AtaqueMismoEquipoException();
    }

}
