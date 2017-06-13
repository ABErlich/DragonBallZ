package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class PiccoloEstadoNormal extends Estado {

    public PiccoloEstadoNormal(Stats stats){
    	stats.setVida(500);
		stats.setPoder(20);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(2);
		stats.setKi(0);
    }

    @Override
    public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats){
        throw new AtaqueMismoEquipoException();
    }

}