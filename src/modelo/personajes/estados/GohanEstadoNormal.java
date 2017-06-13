package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GohanEstadoNormal extends Estado {

    public GohanEstadoNormal(Stats stats){
    	stats.setVida(300);
		stats.setPoder(15);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(2);
		stats.setKi(0);
    }

    @Override
    public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats){
        throw new AtaqueMismoEquipoException();
    }

}